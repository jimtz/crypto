package com.cryptoTransactionSystem.cryptos;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cryptoTransactionSystem.RealData.RealCryptoService;

@RestController
public class CryptoPricesController {

	
	
	@Autowired
	CryptoService cryptoService;
	
	@Autowired
	RealCryptoService realCryptoService;
	
	@GetMapping(path = "/exampleCrypto")
	public Crypto helloCrypto() {
		Crypto crypto = new Crypto("BTC", 30000, 5);
		return crypto;
	}

	@GetMapping(path = "/createCrypto/{cryptoName}/{price}/{holders}")
	public Crypto helloCryptoName(@PathVariable String cryptoName, @PathVariable int price, @PathVariable int holders) {
		Crypto crypto = new Crypto(cryptoName, price, holders);
		cryptoService.addCryptoToDefaultExchange(crypto);
		return crypto;
	}
	
	@GetMapping(path = "/getCrypto/{exchange}")
	public List<String> getCryptoOfExchange(@PathVariable String exchange){
		return cryptoService.getCryptoOfAnExchange(exchange).stream().map(c -> c.getName()).toList();
	}
	
	@GetMapping(path = "/getConfiguration")
	public CryptoPricesServiceConfiguration getConfiguration(){
		return cryptoService.getConfiguration();
	}
	
	@GetMapping(path = "/getDatabaseCrypto")
	public List<Crypto> getDatabaseCrypto(){
		return cryptoService.getCryptosFromDatabase();
	}
	
	@GetMapping(path = "/cryptoByName/{name}")
	public Crypto getCryptoByName(@PathVariable String name) {
		return cryptoService.getCryptoByName(name);
	}
	
	@GetMapping(path = "/realPriceOf/{name}")
	public String getRealPriceOf(@PathVariable String name) {
		return realCryptoService.getRealCryptoPrice(name);
	}
	
	@PostMapping("/cryptoByName")
	public ResponseEntity<Crypto> createCrypto(@RequestBody Crypto crypto) {
		Crypto savedCrypto = cryptoService.save(crypto);
		//URI location = 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(savedCrypto.getName()).toUri();
		return ResponseEntity.created(location).build();
	}
}
