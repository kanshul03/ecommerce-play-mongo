package repository;

import com.google.inject.ImplementedBy;
import models.Product;

import java.util.List;

@ImplementedBy(ProductRepository.class)
public interface ProductRepositoryInterface {

    void save(Product product);

    List<Product> getProducts();

    Product getProduct(String id);

    void delete(String id);
}
