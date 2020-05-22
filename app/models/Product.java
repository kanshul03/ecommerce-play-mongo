package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.morphia.annotations.*;

import java.util.List;

@Entity(value = "product", noClassnameStored = true)
@Indexes(
        @Index(fields = @Field("categories"))
)
@Embedded
public class Product {
    @Id
    private String id;
    private String title;
    private Integer quantity;
    private Integer price;
    private List<String> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @JsonCreator
    public Product(@JsonProperty("id") String id, @JsonProperty("title") String title,
                   @JsonProperty("quantity") Integer quantity, @JsonProperty("price") Integer price,
                   @JsonProperty("categories") List<String> categories) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.categories = categories;
    }

    @JsonCreator
    public Product() {
    }
}
