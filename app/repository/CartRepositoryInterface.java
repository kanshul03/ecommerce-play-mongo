package repository;

import com.google.inject.ImplementedBy;
import dev.morphia.query.Query;
import models.Cart;

@ImplementedBy(CartRepository.class)
public interface CartRepositoryInterface {

    void save(Cart cart);

    Cart get(String userId);

    void update(String userId,String productId);

    void delete(String id,String userId);

}
