package be.vdab.luigi.pizzas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("pizzas/aantal")
    long findAantal(){
        return pizzaService.findAantal();
    }

    @GetMapping("pizzas/{id}")
    Pizza findById(@PathVariable long id){
        return pizzaService.findById(id)
                .orElseThrow(()-> new PizzaNietGevondenException(id));
    }
}