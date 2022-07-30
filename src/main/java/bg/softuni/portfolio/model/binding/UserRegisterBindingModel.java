package bg.softuni.portfolio.model.binding;

import bg.softuni.portfolio.model.validation.FieldMatch;
import bg.softuni.portfolio.model.validation.UniqueUserEmail;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterBindingModel {

    @NotEmpty
    @Size(min = 2, max = 20, message = "Username length should be between 2 and 20 characters.")
    private String username;

    @NotEmpty(message = "User email should be provided.")
    @Email(message = "User email should be valid.")
    @UniqueUserEmail(message = "User email should be unique.")
    private String email;

    @NotEmpty
    @Size(min = 5, message = "Username password must be more than 5 characters")
    private String password;

    @DecimalMin(value = "0", message = "Budget must be a positive number")
    private BigDecimal budget;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
