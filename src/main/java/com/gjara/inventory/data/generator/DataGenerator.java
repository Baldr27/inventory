package com.gjara.inventory.data.generator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.gjara.inventory.data.entities.Category;
import com.gjara.inventory.data.entities.Product;
import com.gjara.inventory.data.repository.ICategoryRepository;
import com.gjara.inventory.data.repository.ProductRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository, ICategoryRepository categoryRepository) {

        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (productRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");
            ExampleDataGenerator<Category> categoryGenerator = new ExampleDataGenerator<>(Category.class,
            LocalDateTime.now());
            categoryGenerator.setData(Category::setName, DataType.FOOD_PRODUCT_NAME);
            List<Category> categories = categoryRepository.saveAll(categoryGenerator.create(5, seed));

            logger.info("... generating 50 Product entities...");
            ExampleDataGenerator<Product> productGenerator = new ExampleDataGenerator<>(Product.class,
                    LocalDateTime.now());
            productGenerator.setData(Product::setName, DataType.FIRST_NAME);

            Random r = new Random(seed);
            List<Product> products = productGenerator.create(10, seed).stream().map(product -> {
                product.setCategory(categories.get(r.nextInt(categories.size())));
                return product;
            }).collect(Collectors.toList());

            productRepository.saveAll(products);

            logger.info("Generated demo data");
        };
    }

}
