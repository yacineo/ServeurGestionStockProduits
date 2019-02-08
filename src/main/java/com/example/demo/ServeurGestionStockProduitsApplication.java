package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.Produit;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.RoleEnum;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class}) 
public class ServeurGestionStockProduitsApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx =  SpringApplication.run(ServeurGestionStockProduitsApplication.class, args);
		
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		
		produitRepository.save(new Produit("Livre", 50, 20));
		produitRepository.save(new Produit("Cahier", 10, 30));
		produitRepository.save(new Produit("Stylo", 5, 50));
	 
	 RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
	 Role userRole = new Role(RoleEnum.ROLE_USER);
	 Role adminRole = new Role(RoleEnum.ROLE_ADMIN);
	 
	 roleRepository.save(userRole);
	 roleRepository.save(adminRole);
	 
	 User user1 = new User("yacine1", "yacine1", true);
	 User user2 = new User("yacine2", "yacine2", true);
	 User user3 = new User("yacine3", "yacine3", true);
	
	 List<Role> user1Roles = new ArrayList<>();
	 user1Roles.add(adminRole);user1Roles.add(userRole);
	 
	 user1.setRoles( (user1Roles));
	 user2.setRoles( Arrays.asList(userRole));
	 user3.setRoles( Arrays.asList(userRole));
	 UserRepository userRepository = ctx.getBean(UserRepository.class);
	 userRepository.save(user1);
	 userRepository.save(user2);
	 userRepository.save(user3);
	}

}

