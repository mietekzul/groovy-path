package db

import org.junit.Test
import pl.raziel.db.Product
import pl.raziel.db.ProductDAO

class GroovyProductDAOTest {
    ProductDAO dao = GroovyProductDAO.instance

    @Test
    void testGetAllProducts() {
        assert 3 == dao.allProducts.size()
    }

    @Test
    void testFindProductById() {
        Product p = dao.findProductById(1)
        assert 1 == p.id
        assert "baseball" == p.name
    }

    @Test
    void testInsertAndDeleteProduct() {
        assert 3 == dao.allProducts.size()
        Product p = new Product(4, 'soccer ball', 16.99)
        dao.insertProduct(p)
        assert 4 == dao.allProducts.size()
        dao.deleteProduct(4)
        assert 3 == dao.allProducts.size()
    }
}
