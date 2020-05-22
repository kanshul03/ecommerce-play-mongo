package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;
import models.Product;

import java.util.List;

@ImplementedBy(ProductService.class)
public interface ProductServiceInterface {

    String createProduct(JsonNode json);

    List<Product> getProducts();

    Product getProduct(String id);

    String deleteProduct(String id);

}
