package com.cryptoTransactionSystem.cryptos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CryptoCommandLineRunner implements CommandLineRunner{
	//@Autowired
	//private CryptoJdbcRepository repository;
	//@Autowired
	//private CryptoJpaRepository jpaRepo;
	@Autowired
	private CryptoSpringDataJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Crypto("BTC", 3000, 1000));
		repository.save(new Crypto("ETH", 1500, 700));
	
		System.out.println(repository.findByName("BTC"));
		System.out.println(repository.findByName("ETH"));
		
	}

}
