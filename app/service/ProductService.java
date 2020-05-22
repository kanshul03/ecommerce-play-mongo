package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Product;
import play.libs.Json;
import repository.ProductRepositoryInterface;

import javax.inject.Singleton;
import java.util.List;

public class ProductService implements ProductServiceInterface {
    @Singleton
    @Inject
    ProductRepositoryInterface ri;


    @Override
    public String createProduct(JsonNode json) {
        Product product = Json.fromJson(json, Product.class);
        ri.save(product);
        return "Product added successfully.";
    }

    @Override
    public List<Product> getProducts() {
        return ri.getProducts();
    }

    @Override
    public Product getProduct(String id) {
        return ri.getProduct(id);
    }

    @Override
    public String deleteProduct(String id) {
        ri.delete(id);
        return "Product deleted successfully.";
    }
}
