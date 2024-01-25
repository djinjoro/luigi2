package be.vdab.luigi.pizzas;

import java.math.BigDecimal;

public class Pizza {
    private final long id;
    private final String naam;
    private final BigDecimal prijs;
    private final BigDecimal winst;

    public Pizza(long id, String naam, BigDecimal prijs, BigDecimal winst) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.winst = winst;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public BigDecimal getWinst() {
        return winst;
    }
}
