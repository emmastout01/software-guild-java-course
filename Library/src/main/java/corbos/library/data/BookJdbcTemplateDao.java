package corbos.library.data;

import corbos.library.models.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookJdbcTemplateDao implements BookDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public List<Book> all() throws DataException {
        return jt.query("SELECT * FROM Book;", new BookMapper());
    }

    @Override
    public boolean delete(int bookId) throws DataException {
        return jt.update("DELETE FROM Book WHERE BookId = ?;", bookId) > 0;
    }

    @Override
    public Book findById(int bookId) throws DataException {
        try {
            return jt.queryForObject(
                    "SELECT * FROM Book WHERE BookId = ?",
                    new BookMapper(),
                    bookId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Book findByIsbn(String isbn) throws DataException {
        try {
            return jt.queryForObject(
                    "SELECT * FROM Book WHERE ISBN = ?;",
                    new BookMapper(),
                    isbn);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Book> findByTitle(String title) throws DataException {
        String sql = "SELECT * FROM Book"
                + " WHERE Title LIKE ?;";
        return jt.query(sql, new BookMapper(), title + "%");
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public Book save(Book book) throws DataException {
        if (book.getId() <= 0) {
            return insert(book);
        } else {
            if (update(book)) {
                return book;
            }
        }
        return null;
    }

    private Book insert(Book book) {

        jt.update(
                "INSERT INTO Book (ISBN, Title, PublishDate) VALUES (?, ?, ?);",
                book.getIsbn(),
                book.getTitle(),
                book.getPublishDate()
        );

        int id = jt.queryForObject("select LAST_INSERT_ID()", Integer.class);

        book.setId(id);
        return book;
    }

    private boolean update(Book book) {

        String sql = "UPDATE Book SET"
                + " ISBN = ?, "
                + " Title = ?"
                + " PublishDate = ?"
                + " WHERE BookId = ?;";

        return jt.update(sql,
                book.getIsbn(),
                book.getTitle(),
                book.getPublishDate(),
                book.getId()) > 0;
    }

    private static final class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book b = new Book();
            b.setId(rs.getInt("BookId"));
            b.setIsbn(rs.getString("ISBN"));
            b.setTitle(rs.getString("Title"));
            b.setPublishDate(rs.getDate("PublishDate").toLocalDate());
            return b;
        }

    }

}
