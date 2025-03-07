package org.example.hw9bank.config;

import org.example.hw9bank.domains.Account;
import org.example.hw9bank.domains.CurrencyRate;
import org.example.hw9bank.domains.User;
import org.example.hw9bank.services.AccountService;
import org.example.hw9bank.services.CurrencyRateService;
import org.example.hw9bank.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    private final AccountService accountService;
    private final CurrencyRateService currencyRateService;

    public AppConfig(AccountService accountService, CurrencyRateService currencyRateService) {
        this.accountService = accountService;
        this.currencyRateService = currencyRateService;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/templates/style/**")
                .addResourceLocations("classpath:/templates/style/");
    }

    @Bean
    public CommandLineRunner demo(final UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                CurrencyRate crUSD = new CurrencyRate( "USD", 5.0, 6.0 );
                CurrencyRate crEUR = new CurrencyRate( "EUR", 7.0, 7.5 );
                CurrencyRate crUAH = new CurrencyRate( "UAH", 1.0, 1.0 );
                currencyRateService.addCurrencyRate( crUSD );
                currencyRateService.addCurrencyRate( crEUR );
                currencyRateService.addCurrencyRate( crUAH );



                User john = new User("John", "john@gmail.com");
                User donald = new User("Donald", "donald@gmail.com");
                User bob = new User("Bob", "bob@gmail.com");
                userService.addUser(john);
                userService.addUser(donald);
                userService.addUser(bob);

                Account johnUAH = new Account(1000.0, "UAH");
                johnUAH.setUser(john);
                johnUAH.setCurrency(crUAH.getCurrency());
                accountService.addAccount(johnUAH);

                Account donaldUAH = new Account(15600.0, "UAH");
                donaldUAH.setUser(donald);
                donaldUAH.setCurrency(crUAH.getCurrency());
                accountService.addAccount(donaldUAH);

                Account bobUAH = new Account(28000.0, "UAH");
                bobUAH.setUser(bob);
                bobUAH.setCurrency(crUAH.getCurrency());
                accountService.addAccount(bobUAH);



                Account johnUSD = new Account(600.0, "USD");
                johnUSD.setUser(john);
                johnUSD.setCurrency(crUSD.getCurrency());
                accountService.addAccount(johnUSD);

                Account donaldUSD = new Account(1200.0, "USD");
                donaldUSD.setUser(donald);
                donaldUSD.setCurrency(crUSD.getCurrency());
                accountService.addAccount(donaldUSD);

                Account bobUSD = new Account(2800.0, "USD");
                bobUSD.setUser(bob);
                bobUSD.setCurrency(crUSD.getCurrency());
                accountService.addAccount(bobUSD);




                Account johnEUR = new Account(700.0, "EUR");
                johnEUR.setUser(john);
                johnEUR.setCurrency(crEUR.getCurrency());
                accountService.addAccount(johnEUR);

                Account bobEUR = new Account(3500.0, "EUR");
                bobEUR.setUser(bob);
                bobEUR.setCurrency(crEUR.getCurrency());
                accountService.addAccount(bobEUR);



            }
        };
    }

}
