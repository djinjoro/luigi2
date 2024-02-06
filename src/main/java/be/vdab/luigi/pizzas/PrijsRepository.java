package be.vdab.luigi.pizzas;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PrijsRepository {
    private final JdbcTemplate template;
    private final JdbcClient jdbcClient;

    public PrijsRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.template = template;
        this.jdbcClient = jdbcClient;
    }
    void create(Prijs prijs){
        var sql= """
                insert into prijzen(prijs, vanaf, pizzaId)
                values(?,?,?);
                """;
        jdbcClient.sql(sql)
                .params(prijs.getPrijs(), prijs.getVanaf(),prijs.getPizzaId())
                .update();
    }
}
