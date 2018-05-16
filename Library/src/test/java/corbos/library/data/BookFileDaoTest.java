package corbos.library.data;

import corbos.library.models.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BookFileDaoTest {

    private BookFileDao dao = new BookFileDao("src/test/resources/books.txt");

    @Test
    public void testAdd() throws Exception {

        List<Book> all = dao.all();

        Book b = new Book();
        b.setIsbn("123-456-7890");
        b.setTitle("Vroom");
        b.setPublishDate(LocalDate.now());

        dao.save(b);
        List<Book> next = dao.all();

        assertEquals(all.size() + 1, next.size());

    }

    @Test
    public void testUpdate() throws Exception {
        String title = "Title " + LocalDateTime.now().getNano();

        List<Book> all = dao.all();
        Book b = all.get(0);
        b.setTitle(title);

        dao.save(b);

        List<Book> next = dao.all();

        assertEquals(title, next.get(0).getTitle());
    }

    @Test
    public void testDelete() throws Exception {
        
        List<Book> all = dao.all();

        dao.delete(all.get(0).getId());

        List<Book> next = dao.all();
        assertEquals(all.size() - 1, next.size());
    }

}
