package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.libs.Json;
import play.mvc.*;
import service.ProductServiceInterface;

import javax.inject.Singleton;


public class ProductController extends Controller {
    @Singleton
    @Inject
    ProductServiceInterface psi;


    public Result post(Http.Request request) {
        JsonNode json = request.body().asJson();
        return ok(Json.toJson(psi.createProduct(json)));
    }

    public Result get() {
        return ok(Json.toJson(psi.getProducts()));
    }

    public Result getOne(String id) {
        return ok(Json.toJson(psi.getProduct(id)));
    }

    public Result delete(String id) {
        return ok(Json.toJson(psi.deleteProduct(id)));
    }
}
