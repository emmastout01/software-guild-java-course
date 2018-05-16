package corbos.library.ui;

import corbos.library.App;
import corbos.library.models.Book;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class View {

    private Scanner scanner = new Scanner(System.in);

    public int printMenuAndSelect() {
        print("1. List all books.");
        print("2. Find books by title.");
        print("3. Add a book.");
        print("4. Delete a book.");
        print("0. Exit [--]");
        return readInt("Select: ", 0, 4);
    }

    public void printAllBooks(Collection<Book> books) {
        printHeader("All Books");
        printBooks(books);
        printFooter();
    }
    
     public void printBooksFromTitle(String title, Collection<Book> books) {
        printHeader(String.format("Books that start with '%s'", title));
        printBooks(books);
        printFooter();
    }

    public void printBooks(Collection<Book> books) {

        if (books.size() <= 0) {
            print("(No books found...)");
        } else {
            for (Book b : books) {
                print(String.format("%s. %s %s %s",
                        b.getId(),
                        b.getTitle(),
                        b.getIsbn(),
                        b.getPublishDate().format(App.DateFormatter)));
            }
        }
    }

    public void printSaveSuccess(Book b) {
        print("Success!");
        print(String.format("Book ID %s Saved.", b.getId()));
    }

    public void printDeleteSuccess(int bookId) {
        print("Success!");
        print(String.format("Book ID %s was deleted.", bookId));
    }

    public void printGoodbye() {
        print("Goodbye!");
    }

    public void printErrors(Collection<String> messages) {
        printHeader("Errors");
        for (String message : messages) {
            print(message);
        }
        printFooter();
    }

    public Book getBook() {
        printHeader("Add a book");
        Book b = new Book();
        b.setIsbn(readString("ISBN: "));
        b.setTitle(readString("Title: "));
        b.setPublishDate(readLocalDate("Publish Date (yyyy-MM-dd): "));
        return b;
    }

    public int getBookIdToDelete() {
        printHeader("Delete a book");
        return readInt("Enter the book ID:");
    }

    public String getTitle() {
        printHeader("Find a book by title");
        return readString("Title starts with:");
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void printHeader(String message) {
        print(message + " ===== ");
    }

    private void printFooter() {
        print("============");
    }

    private int readInt(String prompt, int min, int max) {
        boolean isValid = false;
        int result = 0;
        while (!isValid) {
            result = readInt(prompt);
            if (result < min || result > max) {
                print(String.format("Value must be between %s and %s.", min, max));
            } else {
                isValid = true;
            }
        }
        return result;
    }

    private int readInt(String prompt) {
        boolean isValid = false;
        int result = 0;
        while (!isValid) {
            String value = readString(prompt);
            if (value.length() < 10 && value.chars().allMatch(Character::isDigit)) {
                result = Integer.parseInt(value);
                isValid = true;
            } else {
                print(value + " is not a valid number.");
            }
        }
        return result;
    }

    private LocalDate readLocalDate(String prompt) {
        boolean isValid = false;
        LocalDate result = null;
        while (!isValid) {
            String value = readString(prompt);
            try {
                result = LocalDate.parse(value, App.DateFormatter);
                isValid = true;
            } catch (DateTimeParseException ex) {
                print(value + " is not a date.");
            }
        }
        return result;
    }

    private String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

}
