package db;

import org.junit.Before;
import org.junit.Test;
import pl.raziel.db.JavaProductDAO;
import pl.raziel.db.Product;
import pl.raziel.db.ProductDAO;

import static org.junit.Assert.assertEquals;

public class JavaProductDAOTest {
    private ProductDAO dao;

    @Before
    public void setUpDatabase() throws Exception {
        dao = new JavaProductDAO();
    }

    @Test
    public void testGetAllProducts() {
        assertEquals(3, dao.getAllProducts().size());
    }

    @Test
    public void testFindProductById() {
        Product p = dao.findProductById(1);
        assertEquals(1, p.getId());
        assertEquals("baseball", p.getName());
    }

    @Test
    public void testInsertAndDeleteProduct() {
        assertEquals(3, dao.getAllProducts().size());
        Product p = new Product(4, "soccer ball", 16.99);
        dao.insertProduct(p);
        assertEquals(4, dao.getAllProducts().size());
        dao.deleteProduct(4);
        assertEquals(3, dao.getAllProducts().size());
    }
}
