package bg.softuni.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AuthController {


    @GetMapping("/work")
    public String work(){
        return "work";
    }

    @GetMapping("/stack")
    public String stack(){
        return "stack";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }

    @GetMapping("/services")
    public String services(){
        return "services";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

}
