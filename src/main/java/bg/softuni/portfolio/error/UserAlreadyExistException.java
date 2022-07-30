package bg.softuni.portfolio.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User already exists")
public class UserAlreadyExistException extends RuntimeException {

    private final int statusCode;

    public UserAlreadyExistException(){
        this.statusCode = 409;
    }

    public UserAlreadyExistException(String msg) {
        super(msg);
        this.statusCode = 409;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
