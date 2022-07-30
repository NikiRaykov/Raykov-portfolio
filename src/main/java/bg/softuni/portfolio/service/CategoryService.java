package bg.softuni.portfolio.service;

import bg.softuni.portfolio.model.entity.Category;
import bg.softuni.portfolio.model.enums.CategoryNameEnum;
import bg.softuni.portfolio.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void init() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category();
                        category.setName(categoryNameEnum);

                        switch (categoryNameEnum) {
                            case WEB -> category.setDescription("Web services allow you to expose the functionality of your existing code over the network. Once it is exposed on the network, other applications can use the functionality of your program.");
                            case FRONT_END -> category.setDescription("Responsible for implementing visual elements that users see and interact with in a web application.");
                            case OFFICE_365 -> category.setDescription("Office 365 is a Software as a Service (SaaS) solution that combines the traditional Microsoft Office desktop applications, Microsoft application services, and some new productivity services.");
                            case DATABASE_MANAGEMENT -> category.setDescription("Database Management Systems (DBMS) are software systems used to store, retrieve, and run queries on data.");
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    public Category findByName(CategoryNameEnum categoryNameEnum) {
        return this.categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
