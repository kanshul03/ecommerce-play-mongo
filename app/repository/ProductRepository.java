package repository;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import models.Product;

import java.util.List;

public class ProductRepository implements ProductRepositoryInterface {

    private Morphia morphia;
    private Datastore datastore;

    public ProductRepository() {
        morphia = new Morphia();
        morphia.mapPackage("models.Product");
        datastore = morphia.createDatastore(new MongoClient(), "ecommerce");
        datastore.ensureIndexes();
    }

    @Override
    public void save(Product product) {
        datastore.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return datastore.find(Product.class).find().toList();
    }

    @Override
    public Product getProduct(String id) {
        return datastore.find(Product.class).field("id").equal(id).find().toList().get(0);
    }

    @Override
    public void delete(String id) {
        Query<Product> query = datastore.createQuery(Product.class).field("id").equal(id);
        datastore.findAndDelete(query);
    }
}
