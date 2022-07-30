package bg.softuni.portfolio.model.binding;

import bg.softuni.portfolio.model.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductAddBindingModel {

    public ProductAddBindingModel(){}

    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    @NotNull
    private String name;

    @Length(min = 5, message = "Description length must be more than 5 characters!")
    @NotNull
    private String description;

    @DecimalMin(value = "0", message = "Price must be positive number!")
    @NotNull
    private BigDecimal price;

    @NotNull(message = "Category cannot be empty")
    private CategoryNameEnum category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
