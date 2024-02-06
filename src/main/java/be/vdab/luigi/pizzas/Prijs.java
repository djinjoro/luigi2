package be.vdab.luigi.pizzas;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Prijs {
    private final BigDecimal prijs;
    private final LocalDateTime vanaf;
    private final long pizzaId;

    public Prijs(BigDecimal prijs, LocalDateTime vanaf, long pizzaId) {
        this.prijs = prijs;
        this.vanaf = vanaf;
        this.pizzaId = pizzaId;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public LocalDateTime getVanaf() {
        return vanaf;
    }

    public long getPizzaId() {
        return pizzaId;
    }
}
