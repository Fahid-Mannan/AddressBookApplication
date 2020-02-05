package Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new BuddyInfo("Jack", "Bauer", (long) 123));
            repository.save(new BuddyInfo("Jone", "Boy", (long) 456));
            repository.save(new BuddyInfo("Jane", "Bill", (long) 789));
            repository.save(new BuddyInfo("Joseph", "Bell", (long) 246));
            repository.save(new BuddyInfo("Jeremy", "Boo", (long) 357));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Buddy found with findByAddress('Jone'):");
            log.info("--------------------------------------------");
            repository.findByAddress("Boy").forEach(Jone -> {
                log.info(Jone.toString());
            });

            // fetch customers by last name
            log.info("Buddy found with findByName('Jack'):");
            log.info("--------------------------------------------");
            repository.findByName("Jack").forEach(Jack -> {
                log.info(Jack.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}