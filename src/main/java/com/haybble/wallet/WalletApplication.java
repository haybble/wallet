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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class WalletApplication {
    
    
      @RequestMapping("/")
    @ResponseBody
   public String home() {
      return "Hello World!" ;
    }

    @Autowired
    UserRepository userRepository;
    
    @Autowired WalletRepository walletRepository;
    
    @Autowired TransactionTypeRepository transactionTypeRepository;

    @Bean
    public void seedUserdata() {

        for (int i = 0; i < 500; i++) {
            Faker fakeData = new Faker();
            String name = fakeData.name().firstName();
            String username =name+i;
            Users user = new Users();
            user.setUsername(username);
            Date date = new Date();

            user.setCreated_date(date);
            user.setCreated_by(name);

            userRepository.save(user);
            int userId = user.getUser_id();
            Wallet wallet = new Wallet();
            wallet.setBalance(BigDecimal.ZERO);
            wallet.setLast_updated_by(name);
            wallet.setLastUpdated(date);
            wallet.setLast_updated_by(name);
            walletRepository.save(wallet);
                //       System.out.println("useride = "+user.getUser_id());
        }
           
            TransactionType transactionType =new TransactionType();
            transactionType.setCode("cr");
            transactionType.setDescription("credit transaction");
            transactionType.setName("credit");
            transactionType.setLast_updated_by("Admin");
            transactionType.setLast_updated(new Date());
            transactionTypeRepository.save(transactionType);
           TransactionType transactionType2 =new TransactionType();
            transactionType2.setCode("dr");
            transactionType2.setDescription("debit transaction");
            transactionType2.setName("debit");
            transactionType2.setLast_updated_by("Admin");
            transactionType2.setLast_updated(new Date());
             transactionTypeRepository.save(transactionType2);

    }

    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }

}
