package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;
import models.Cart;

@ImplementedBy(CartService.class)
public interface CartServiceInterface {

    String createCart(JsonNode json);

    Cart getCart(String userId);

    String updateCart(String userId, String id);

    String deleteCartProduct(String userId, String id);

}
