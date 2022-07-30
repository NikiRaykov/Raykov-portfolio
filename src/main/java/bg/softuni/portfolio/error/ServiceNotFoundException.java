package bg.softuni.portfolio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ServiceNotFoundException extends RuntimeException {

    private final Long id;

    public ServiceNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
