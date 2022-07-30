package bg.softuni.portfolio.model.entity;

import bg.softuni.portfolio.model.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    public Category(){}

    public Category(CategoryNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
