package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class}) 
public class ServeurGestionStockProduitsApplication {

	public static void main(String[] args) {
	 SpringApplication.run(ServeurGestionStockProduitsApplication.class, args);
		//ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		
//		produitRepository.save(new Produit("Livre", 50, 20));
//		produitRepository.save(new Produit("Cahier", 10, 30));
//		produitRepository.save(new Produit("Stylo", 5, 50));
	}

}

