package com.cryptoTransactionSystem.crypto_exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cryptoTransactionSystem.cryptos")
@EntityScan(basePackages = { "com.cryptoTransactionSystem.cryptos"}) 
@ComponentScan(basePackages = { "com.cryptoTransactionSystem.RealData","com.cryptoTransactionSystem.cryptos", "com.cryptoTransactionSystem.crypto_exchange", "com.cryptoTransactionSystem.Users" })
public class CryptoExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoExchangeApplication.class, args);
	}

}
