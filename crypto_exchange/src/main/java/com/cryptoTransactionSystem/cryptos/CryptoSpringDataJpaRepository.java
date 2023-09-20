package com.cryptoTransactionSystem.cryptos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoSpringDataJpaRepository extends JpaRepository<Crypto, Long>{

	Crypto findByName(String name);
}
