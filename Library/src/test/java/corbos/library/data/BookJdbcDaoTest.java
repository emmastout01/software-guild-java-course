/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.library.data;

import corbos.library.models.Book;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmarch
 */
public class BookJdbcDaoTest {
    
    private BookJdbcDao dao = new BookJdbcDao();
    
    public BookJdbcDaoTest() {
    }

//    @Test
    public void testAll() throws Exception {
        List<Book> all = dao.all();
        assertTrue(all.size() > 0);
    }

//    @Test
    public void testDelete() throws Exception {
    }

//    @Test
    public void testFindById() throws Exception {
    }

//    @Test
    public void testFindByIsbn() throws Exception {
    }

//    @Test
    public void testFindByTitle() throws Exception {
    }

//    @Test
    public void testSave() throws Exception {
    }
    
}
