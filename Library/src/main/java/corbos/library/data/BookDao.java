package corbos.library.data;

import corbos.library.models.Book;
import java.util.List;

public interface BookDao {

    List<Book> all() throws DataException;

    boolean delete(int bookId) throws DataException;

    Book findById(int bookId) throws DataException;

    Book findByIsbn(String isbn) throws DataException;

    List<Book> findByTitle(String title) throws DataException;

    Book save(Book book) throws DataException;

}
