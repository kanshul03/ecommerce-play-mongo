package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.libs.Json;
import play.mvc.*;
import service.CartServiceInterface;

import javax.inject.Singleton;


public class CartController extends Controller {

    @Singleton
    @Inject
    CartServiceInterface csi;


    public Result get(String userId) {
        return ok(Json.toJson(csi.getCart(userId)));
    }

    public Result post(Http.Request request) {
        JsonNode json = request.body().asJson();
        return ok(Json.toJson(csi.createCart(json)));
    }

    public Result put(String userId, String id) {
        return ok(Json.toJson(csi.updateCart(userId, id)));
    }

    public Result delete(String userId, String id) {
        return ok(Json.toJson(csi.deleteCartProduct(userId, id)));
    }
}