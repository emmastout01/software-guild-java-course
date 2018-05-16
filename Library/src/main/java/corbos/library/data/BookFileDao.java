package corbos.library.data;

import corbos.library.App;
import corbos.library.models.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

//@Component
public class BookFileDao implements BookDao {

    private String path = "books.txt";

    public BookFileDao() {
    }

    public BookFileDao(String path) {
        this.path = path;
    }

    @Override
    public List<Book> all() throws DataException {

        List<Book> result = new ArrayList<>();

        File file = new File(path);
        if (!file.exists()) {
            return result;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    Book b = new Book();
                    b.setId(Integer.parseInt(tokens[0]));
                    b.setIsbn(tokens[1]);
                    b.setTitle(tokens[2]);
                    b.setPublishDate(LocalDate.parse(tokens[3], App.DateFormatter));
                    result.add(b);
                }
            }
        } catch (IOException ex) {
            throw new DataException("Could not read book.", ex);
        }

        return result;
    }

    @Override
    public List<Book> findByTitle(String title) throws DataException {
        return all().stream()
                .filter(b -> b.getTitle().startsWith(title))
                .collect(Collectors.toList());
    }

    @Override
    public Book findById(int bookId) throws DataException {
        return all().stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book findByIsbn(String isbn) throws DataException {
        return all().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book save(Book book) throws DataException {
        List<Book> books = all();
        if (book.getId() > 0) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId() == book.getId()) {
                    books.set(i, book);
                    break;
                }
            }
        } else {
            book.setId(books.stream().mapToInt(b -> b.getId()).max().orElse(0) + 1);
            books.add(book);
        }
        write(books);
        return book;
    }

    @Override
    public boolean delete(int bookId) throws DataException {
        List<Book> books = all();
        boolean success = books.removeIf(b -> b.getId() == bookId);
        if (success) {
            write(books);
        }
        return success;
    }

    private void write(List<Book> books) throws DataException {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Book b : books) {
                writer.printf("%s,%s,%s,%s\n",
                        b.getId(),
                        b.getIsbn(),
                        b.getTitle(),
                        b.getPublishDate().format(App.DateFormatter));
            }
        } catch (IOException ex) {
            throw new DataException("Could not save books", ex);
        }
    }
}
