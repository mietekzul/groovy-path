package pl.raziel.db;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();

    Product findProductById(int id);

    void insertProduct(Product product);

    void deleteProduct(int id);
}
