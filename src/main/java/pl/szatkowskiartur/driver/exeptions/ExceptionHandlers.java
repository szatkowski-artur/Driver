package pl.szatkowskiartur.driver.exeptions;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlers {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        exception.getBindingResult().getAllErrors().stream()
                .filter(error -> "retypedPassword".equalsIgnoreCase(error.getCode()))
                .forEach(error -> errors.put("rePassword", error.getDefaultMessage()));

        @FieldDefaults(makeFinal = true)
        @Data
        class ValidationError {
            Date timestamp = new Date();
            HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
            String message = "Validation failed";
            Map<String, String> failedFields;
        }

        return new ResponseEntity<>(new ValidationError(errors), HttpStatus.NOT_ACCEPTABLE);

    }

}
