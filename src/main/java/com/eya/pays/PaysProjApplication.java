package com.eya.pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
import com.eya.pays.service.PaysService;
@SpringBootApplication
public class PaysProjApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    PaysService paysService;

    public static void main(String[] args) {
        SpringApplication.run(PaysProjApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
    repositoryRestConfiguration.exposeIdsFor(Pays.class);
    repositoryRestConfiguration.exposeIdsFor(Classification.class);

    }
    
}
