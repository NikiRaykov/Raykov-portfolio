package bg.softuni.portfolio.service;

import bg.softuni.portfolio.model.entity.Product;
import bg.softuni.portfolio.model.service.ProductServiceModel;
import bg.softuni.portfolio.model.view.ProductViewModel;
import bg.softuni.portfolio.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public ProductService(ModelMapper modelMapper, CategoryService categoryService, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }


    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);

        product.setCategory(categoryService.findByName(productServiceModel.getCategory().getName()));

        productRepository.save(product);
    }


    public ProductViewModel findById(Long id) {
        return productRepository.findById(id)
                .map(product -> this.modelMapper
                        .map(product, ProductViewModel.class)).orElse(null);
    }


    public List<ProductViewModel> findAllProducts() {
        return productRepository
                .findAll().stream()
                .map(product -> this.modelMapper
                        .map(product, ProductViewModel.class)).collect(Collectors.toList());
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
