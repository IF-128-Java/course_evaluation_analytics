package ita.softserve.course_evaluation_analytics.exception.handler;

import ita.softserve.course_evaluation_analytics.exception.dto.GenericExceptionResponse;
import ita.softserve.course_evaluation_analytics.exception.exceptions.GroupAlreadyExistException;
import ita.softserve.course_evaluation_analytics.exception.exceptions.NotEmptyGroupException;
import ita.softserve.course_evaluation_analytics.exception.exceptions.UserRoleException;
import ita.softserve.course_evaluation_analytics.exception.exceptions.WrongIdException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import javax.persistence.EntityNotFoundException;
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({WrongIdException.class,
            GroupAlreadyExistException.class,
            UserRoleException.class})
    public ResponseEntity<GenericExceptionResponse> handleWrongIdException(RuntimeException exception) {
        GenericExceptionResponse dto = GenericExceptionResponse.builder()
                .message(exception.getMessage())
                .error(exception.getClass().getSimpleName())
                .build();
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({NotEmptyGroupException.class})
    public ResponseEntity<GenericExceptionResponse> handleNotEmptyGroupException(NotEmptyGroupException exception) {
        GenericExceptionResponse dto = GenericExceptionResponse.builder()
                .message(HttpStatus.BAD_REQUEST.name())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(exception.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericExceptionResponse dto = GenericExceptionResponse.builder()
                .message(ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(" ")))
                .status(HttpStatus.BAD_REQUEST.value())
                .error(ex.getClass().getSimpleName())
                .build();
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericExceptionResponse dto = GenericExceptionResponse.builder()
                .message(ex.getCause().getClass().getSimpleName())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(ex.getClass().getSimpleName())
                .build();
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
