package com.eya.pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.eya.pays.entities.Pays;
import com.eya.pays.service.PaysService;
@SpringBootApplication
public class PaysProjApplication implements CommandLineRunner {

    @Autowired
    PaysService paysService;

    public static void main(String[] args) {
        SpringApplication.run(PaysProjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        paysService.savePays(new Pays("Tunisia", 12000000L, "Africa", new Date()));
        paysService.savePays(new Pays("France", 67000000L, "Europe", new Date()));
        paysService.savePays(new Pays("USA", 331000000L, "North America", new Date()));
        paysService.savePays(new Pays("Japan", 126000000L, "Asia", new Date()));
        paysService.savePays(new Pays("Brazil", 211000000L, "South America", new Date()));
    }
}
