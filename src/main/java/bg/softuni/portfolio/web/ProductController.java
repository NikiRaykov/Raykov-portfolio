package bg.softuni.portfolio.web;

import bg.softuni.portfolio.error.ServiceNotFoundException;
import bg.softuni.portfolio.model.binding.ProductAddBindingModel;
import bg.softuni.portfolio.model.service.ProductServiceModel;
import bg.softuni.portfolio.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("productAddBindingModel")) {
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
        }

        return "add-service";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add-service";
        }

        productService.add(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }

    @RequestMapping(value = {"/details"}, method = RequestMethod.GET)
    public ModelAndView details(@RequestParam("id") Long id, ModelAndView modelAndView) {

         if (productService.findById(id) == null) {
            throw new ServiceNotFoundException(id);
        }

        modelAndView.addObject("product", productService.findById(id));
        modelAndView.setViewName("details");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.delete(id);

        return "redirect:/";
    }

    @ModelAttribute()
    public ProductAddBindingModel productAddBindingModel(){
        return new ProductAddBindingModel();
    }
}
