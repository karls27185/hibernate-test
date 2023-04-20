package com.javastart.hibernatetest;

import com.javastart.hibernatetest.dao.AccountDAO;
import com.javastart.hibernatetest.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class})
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account("Lori", 15);
        Account saveAccount = accountDAO.save(account);

        System.out.println(accountDAO.findById(saveAccount.getAccountId()));
    }
}
