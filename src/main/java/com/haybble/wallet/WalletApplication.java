package com.haybble.wallet;

import com.github.javafaker.Faker;
import com.haybble.wallet.entities.TransactionType;
import com.haybble.wallet.entities.Users;
import com.haybble.wallet.entities.Wallet;
import com.haybble.wallet.repository.TransactionTypeRepository;
import com.haybble.wallet.repository.UserRepository;
import com.haybble.wallet.repository.WalletRepository;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableJpaRepositories
@SpringBootApplication
public class WalletApplication {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @Bean
    public void seedUserdata() {

        for (int i = 0; i < 5; i++) {
            Faker fakeData = new Faker();
            String name = fakeData.name().firstName();
            String username = name + i;
            Users user = new Users();
            user.setUsername(username);
            Date date = new Date();

            user.setCreatedDate(date);
            user.setCreatedBy(name);

            userRepository.save(user);
            int userId = user.getUserId();
            Wallet wallet = new Wallet();
            wallet.setUserId(userId);
            wallet.setBalance(BigDecimal.ZERO);
            wallet.setLastUpdatedBy(name);
            wallet.setLastUpdated(date);
            wallet.setLastUpdatedBy(name);
            walletRepository.save(wallet);
            //       System.out.println("useride = "+user.getUser_id());
        }

        TransactionType transactionType = new TransactionType();
        transactionType.setCode("cr");
        transactionType.setDescription("credit transaction");
        transactionType.setName("credit");
        transactionType.setLastUpdatedBy("Admin");
        transactionType.setLastUpdated(new Date());
        transactionTypeRepository.save(transactionType);
        TransactionType transactionType2 = new TransactionType();
        transactionType2.setCode("dr");
        transactionType2.setDescription("debit transaction");
        transactionType2.setName("debit");
        transactionType2.setLastUpdatedBy("Admin");
        transactionType2.setLastUpdated(new Date());
        transactionTypeRepository.save(transactionType2);

    }

    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }

}
