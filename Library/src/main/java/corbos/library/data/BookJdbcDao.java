package corbos.library.data;

import corbos.library.models.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//@Component
public class BookJdbcDao implements BookDao {

    @Override
    public List<Book> all() throws DataException {

        List<Book> result = new ArrayList<>();

        try (Connection conn = MySqlDatabase.getDataSource().getConnection()) {

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Book;");

            while (rs.next()) {
                result.add(readBook(rs));
            }
        } catch (SQLException ex) {
            throw new DataException("DB failure.", ex);
        }

        return result;
    }

    @Override
    public boolean delete(int bookId) throws DataException {

        try (Connection conn = MySqlDatabase.getDataSource().getConnection()) {

            String sql = "DELETE FROM Book WHERE BookId = ?;";
            PreparedStatement deleteStatement = conn.prepareStatement(sql);
            deleteStatement.setInt(1, bookId);

            return deleteStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            throw new DataException("DB Failure.", ex);
        }
    }

    @Override
    public Book findById(int bookId) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book findByIsbn(String isbn) throws DataException {
        try (Connection conn = MySqlDatabase.getDataSource().getConnection()) {

            String sql = "SELECT * FROM Book WHERE ISBN = ?;";
            PreparedStatement findStatement = conn.prepareStatement(sql);
            findStatement.setString(1, isbn);

            ResultSet rs = findStatement.executeQuery();
            if (rs.next()) {
                return readBook(rs);
            }
        } catch (SQLException ex) {
            throw new DataException("DB Failure.", ex);
        }
        return null;
    }

    @Override
    public List<Book> findByTitle(String title) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book save(Book book) throws DataException {
        if (book.getId() <= 0) {
            return insert(book);
        } else {
            // update
            return null;
        }
    }

    private Book readBook(ResultSet rs) throws SQLException {
        Book b = new Book();
        b.setId(rs.getInt("BookId"));
        b.setIsbn(rs.getString("ISBN"));
        b.setTitle(rs.getString("Title"));
        b.setPublishDate(rs.getDate("PublishDate").toLocalDate());
        return b;
    }

    private Book insert(Book book) throws DataException {

        try (Connection conn = MySqlDatabase.getDataSource().getConnection()) {

            String sql = "INSERT INTO Book (ISBN, Title, PublishDate) "
                    + "VALUES (?, ?, ?);";

            PreparedStatement insertStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, book.getIsbn());
            insertStatement.setString(2, book.getTitle());
            insertStatement.setDate(3, Date.valueOf(book.getPublishDate()));
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            rs.next();
            int newId = rs.getInt(1);
            book.setId(newId);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataException("DB Failure", ex);
        }

        return book;
    }

}
