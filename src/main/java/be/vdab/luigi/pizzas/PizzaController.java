package be.vdab.luigi.pizzas;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

@RestController
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    private record IdNaamPrijs(long id, String naam, BigDecimal prijs){
        IdNaamPrijs(Pizza pizza){
            this(pizza.getId(), pizza.getNaam(), pizza.getPrijs());
        }
    }

    @GetMapping("pizzas/aantal")
    long findAantal(){
        return pizzaService.findAantal();
    }
    @GetMapping("pizzas/{id}")
    IdNaamPrijs findById(@PathVariable long id){
        return pizzaService.findById(id)
                .map(IdNaamPrijs::new)
                .orElseThrow(()-> new PizzaNietGevondenException(id));
    }
    @GetMapping("pizzas")
    Stream<IdNaamPrijs> findAll(){
        return pizzaService.findAll()
                .stream()
                .map(IdNaamPrijs::new);
    }
    @GetMapping(value = "pizzas", params = "naamBevat")
    Stream<IdNaamPrijs> findByNaamBevat(String naamBevat){
        return pizzaService.findByNaamBevat(naamBevat)
                .stream()
                .map(IdNaamPrijs::new);
    }
    @GetMapping(value = "pizzas", params = {"vanPrijs", "totPrijs"})
    Stream<IdNaamPrijs> findByPrijsTussen(BigDecimal vanPrijs, BigDecimal totPrijs){
        return pizzaService.findByPrijsTussen(vanPrijs, totPrijs)
                .stream()
                .map(IdNaamPrijs::new);
    }
    @DeleteMapping("pizzas/{id}")
    void delete(@PathVariable long id){
        pizzaService.delete(id);
    }
    @PostMapping("pizzas")
    long create(@RequestBody NieuwePizza nieuwePizza){
        return pizzaService.create(nieuwePizza);
    }
}