package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Cart;
import play.libs.Json;
import repository.CartRepositoryInterface;

import javax.inject.Singleton;

public class CartService implements CartServiceInterface {
    @Singleton
    @Inject
    CartRepositoryInterface ci;


    @Override
    public String createCart(JsonNode json) {
        Cart cart = Json.fromJson(json, Cart.class);
        ci.save(cart);
        return "Cart created successfully.";
    }

    @Override
    public Cart getCart(String userId) {
        return ci.get(userId);
    }

    @Override
    public String updateCart(String userId, String id) {
        ci.update(userId, id);
        return "Cart updated successfully.";
    }

    @Override
    public String deleteCartProduct(String userId, String id) {
        ci.delete(userId, id);
        return "Product deleted from cart successfully.";
    }
}
