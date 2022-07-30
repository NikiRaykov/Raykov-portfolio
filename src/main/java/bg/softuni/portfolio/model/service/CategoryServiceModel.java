package bg.softuni.portfolio.model.service;

import bg.softuni.portfolio.model.enums.CategoryNameEnum;

public class CategoryServiceModel {

    public CategoryServiceModel() {
    }

    private Long id;

    private CategoryNameEnum name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
