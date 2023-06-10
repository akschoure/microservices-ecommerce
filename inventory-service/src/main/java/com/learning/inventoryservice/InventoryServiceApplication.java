package com.learning.inventoryservice;

import com.learning.inventoryservice.dao.InventoryRepository;
import com.learning.inventoryservice.entity.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);}

		@Bean
		public CommandLineRunner loadData(InventoryRepository inventoryRepository){
			return args ->
			{
				Inventory inventory1 = new Inventory();
				inventory1.setSkuCode("Iphone_13");
				inventory1.setQuantity(5);

				Inventory inventory2 = new Inventory();
				inventory2.setSkuCode("Iphone_14");
				inventory2.setQuantity(2);

				inventoryRepository.save(inventory1);
				inventoryRepository.save(inventory2);
			};


		};
	}


