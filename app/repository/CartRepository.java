package repository;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import models.Cart;
import models.Product;

import java.util.List;

public class CartRepository implements CartRepositoryInterface {
    private Morphia morphia;
    private Datastore datastore;

    public CartRepository() {
        morphia = new Morphia();
        morphia.mapPackage("models.Cart");
        morphia.mapPackage("models.Product");
        datastore = morphia.createDatastore(new MongoClient(), "ecommerce");
        datastore.ensureIndexes();
    }

    @Override
    public void save(Cart cart) {
        datastore.save(cart);
    }

    @Override
    public Cart get(String userId) {
        return datastore.find(Cart.class).find().toList().get(0);
    }

    @Override
    public void update(String userId, String id) {
        Cart cart = datastore.find(Cart.class).field("userId").equal(userId).find().toList().get(0);
        List<Product> prodList = cart.getProducts();
        Product prod = datastore.find(Product.class).field("id").equal(id).find().toList().get(0);
        prodList.add(prod);
        cart.setProducts(prodList);
        datastore.save(cart);
    }

    @Override
    public void delete(String userId, String id) {
        Cart cart = datastore.find(Cart.class).field("userId").equal(userId).find().toList().get(0);
        List<Product> prodList = cart.getProducts();
        for (int i = 0; i < prodList.size(); i++) {
            if (prodList.get(i).getId().equals(id)) {
                prodList.remove(i);
                break;
            }
        }
        cart.setProducts(prodList);
        datastore.save(cart);
    }
}
