package corbos.library.ui;

import corbos.library.models.Book;
import corbos.library.service.BookService;
import corbos.library.service.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @Autowired
    private View view;

    @Autowired
    private BookService bookService;

    public void run() {
        int selection = 1;
        while (selection > 0) {
            selection = view.printMenuAndSelect();
            switch (selection) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    findBooksByTitle();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    deleteBook();
                    break;
            }
        }
        view.printGoodbye();
    }

    private void listBooks() {
        Result<List<Book>> result = bookService.all();
        if (!result.isSuccess()) {
            view.printErrors(result.getMessages());
        } else {
            view.printAllBooks(result.getPayload());
        }
    }

    private void findBooksByTitle() {
        String title = view.getTitle();
        Result<List<Book>> result = bookService.findByTitle(title);
        if (!result.isSuccess()) {
            view.printErrors(result.getMessages());
        } else {
            view.printBooksFromTitle(title, result.getPayload());
        }
    }

    private void addBook() {
        Book b = view.getBook();
        Result<Book> result = bookService.save(b);
        if (result.isSuccess()) {
            view.printSaveSuccess(b);
        } else {
            view.printErrors(result.getMessages());
        }
    }

    private void deleteBook() {
        int bookId = view.getBookIdToDelete();
        Result result = bookService.deleteById(bookId);
        if (result.isSuccess()) {
            view.printDeleteSuccess(bookId);
        } else {
            view.printErrors(result.getMessages());
        }
    }

}
