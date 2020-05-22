package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import java.util.List;
import java.util.Map;

@Entity(value = "cart", noClassnameStored = true)
public class Cart {

    @Id
    private String userId;
    private Map<String, Integer> quantity;
    private Integer total;
    @Embedded
    private List<Product> products;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<String, Integer> quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonCreator
    public Cart(@JsonProperty("user_id") String userId, @JsonProperty("products") List<Product> products,
                @JsonProperty("quantity") Map<String, Integer> quantity, @JsonProperty("total") Integer total) {

        this.userId = userId;
        this.products = products;
        this.quantity = quantity;
        this.total = total;
    }

    @JsonCreator
    public Cart() {
    }
}
