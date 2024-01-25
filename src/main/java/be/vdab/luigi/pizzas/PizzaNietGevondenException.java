package be.vdab.luigi.pizzas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PizzaNietGevondenException extends RuntimeException{
    PizzaNietGevondenException(long id){
        super("Pizza niet gevonden. Id: " + id);
    }
}
