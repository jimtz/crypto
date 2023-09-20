package com.cryptoTransactionSystem.cryptos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CryptoService {
	@Autowired
	CryptoPricesServiceConfiguration confserv;
	@Autowired
	private CryptoSpringDataJpaRepository repository;
		
	Map<String, CryptoExchange> exchanges = Map.of( "Binance", new CryptoExchange("Binance"), "Kraken",  new CryptoExchange("Kraken"));
	
	public CryptoPricesServiceConfiguration getConfiguration() {
		return confserv;
	}

	public void setExchanges(Map<String, CryptoExchange> exchanges) {
		this.exchanges = exchanges;
	}
	public Map<String, CryptoExchange> getExchanges() {
		return exchanges;
	}
	public CryptoExchange getDefaultExchangeObject() {
		return exchanges.get(confserv.getDefaultExchange());
	}
	public void addExchange(String exName) {
		exchanges.put(exName, new CryptoExchange(exName));
	}
	public CryptoExchange getExchange(String name) {
		return exchanges.get(name);
	}
	public void addCryptoToDefaultExchange(Crypto crypto) {
		repository.save(crypto);
		getDefaultExchangeObject().getCryptos().add(crypto);
	}
	public void addCryptoToExchange(String exName, Crypto crypto) {
		repository.save(crypto);
		getExchange(exName).getCryptos().add(crypto);
	}
	public List<Crypto> getCryptoOfAnExchange(String exName) {
		return getExchange(exName).getCryptos();
	}
	public List<Crypto> getCryptoOfDefaultExchange() {
		return getDefaultExchangeObject().getCryptos();
	}
	public List<Crypto> getCryptosFromDatabase(){
		return repository.findAll();
	}

	public Crypto getCryptoByName(String name) {
		return repository.findByName(name);
	}

	public Crypto save(Crypto crypto) {
		repository.save(crypto);
		return crypto;
	}

}
