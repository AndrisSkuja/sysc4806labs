package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@SpringBootApplication
public class AddressBookApplication {

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
/*            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));*/

            AddressBook mybook = new AddressBook();
            BuddyInfo myBuddy = new BuddyInfo("Tom", "dunno", "6");
            BuddyInfo myBuddy2 = new BuddyInfo("Tom2", "dunno2", "62");
            mybook.addBuddy(myBuddy);
            mybook.addBuddy(myBuddy2);
            //mybook.setId(0);

            repository.save(mybook);

            // fetch all AddressBooks
            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook book : repository.findAll()) {
                log.info(book.toString());
            }
            log.info("");

            // fetch an individual AddressBook by ID
//            AddressBook book = repository.findById(0);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(book.toString());
//            log.info("");

/*            // fetch AddressBooks by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");*/

            //fetch buddyInfos from addressBook

//            log.info("Customer found with findById(0):");
//            log.info("--------------------------------");
//            log.info(book.getMylist().get(0).getName() + "\n"+book.getMylist().get(0).getAddress()+"\n"+book.getMylist().get(0).getNumber());
//            log.info("");
        };
    }

//    @Bean
//    @Description("Thymeleaf Template Resolver")
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(new );
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//
//        return templateResolver;
//    }

    @Bean
    @Description("Thymeleaf Template Engine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //templateEngine.setTemplateResolver(templateResolver());
        //templateEngine.setTemplateEngineMessageSource(messageSource());
        return templateEngine;
    }

    @Bean
    @Description("Thymeleaf View Resolver")
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
    }

}