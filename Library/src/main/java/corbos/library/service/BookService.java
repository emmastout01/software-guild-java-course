package corbos.library.service;

import corbos.library.data.BookDao;
import corbos.library.data.DataException;
import corbos.library.models.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    
    @Autowired
    private BookDao bookDao;
    
    public Result<List<Book>> all() {
        Result<List<Book>> result = new Result<>();
        try {
            result.setPayload(bookDao.all());
        } catch (DataException ex) {
            result.addMessage(ex.getMessage());
        }
        return result;
    }
    
    public Result<List<Book>> findByTitle(String title) {
        Result<List<Book>> result = new Result<>();
        try {
            result.setPayload(bookDao.findByTitle(title));
        } catch (DataException ex) {
            result.addMessage(ex.getMessage());
        }
        return result;
    }
    
    public Result<Book> save(Book book) {
        Result<Book> result = validate(book);
        if (result.isSuccess()) {
            try {
                bookDao.save(book);
                result.setPayload(book);
            } catch (DataException ex) {
                result.addMessage(ex.getMessage());
            }
        }
        return result;
    }
    
    public Result deleteById(int bookId) {
        Result result = new Result();
        try {
            boolean success = bookDao.delete(bookId);
            if (!success) {
                result.addMessage(String.format("Book Id %s was not found.", bookId));
            }
        } catch (DataException ex) {
            result.addMessage(ex.getMessage());
        }
        return result;
    }
    
    private Result<Book> validate(Book book) {
        Result<Book> result = new Result<>();
        if (!isPresent(book.getIsbn())) {
            result.addMessage("ISBN is required.");
        }
        if (!isPresent(book.getTitle())) {
            result.addMessage("Title is required.");
        }
        if (book.getPublishDate() == null) {
            result.addMessage("Publish Date is required.");
        }

        // Don't bother if something else has failed.
        if (result.isSuccess()) {
            validateRelationships(book, result);
        }
        
        return result;
    }
    
    private void validateRelationships(Book book, Result<Book> result) {
        try {
            Book existing = bookDao.findByIsbn(book.getIsbn());
            if (existing != null && existing.getId() != book.getId()) {
                result.addMessage(String.format("ISBN %s already exists.", book.getIsbn()));
            }
        } catch (DataException ex) {
            result.addMessage(ex.getMessage());
        }
    }
    
    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }
    
}
