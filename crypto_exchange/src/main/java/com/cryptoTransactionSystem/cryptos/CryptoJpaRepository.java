package com.cryptoTransactionSystem.cryptos;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CryptoJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	

	public void insert(Crypto crypto) {
		entityManager.merge(crypto);
	}

	public Crypto findById(long id) {
		return entityManager.find(Crypto.class, id);
	}
	public void deleteById(long id) {
		Crypto crypto = entityManager.find(Crypto.class, id);
		entityManager.remove(crypto);
	}
	//public List<Crypto> getCryptos(){
		//return entityManager.createQuery("Select * from Crypto").getResultList();
	//}
	
}
