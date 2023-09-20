package com.cryptoTransactionSystem.cryptos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cryptoTransactionSystem.Users.Person;
public class CryptoExchange {
	String name;
	List<Crypto> cryptos = new ArrayList<>();
	List<Person> persons = new ArrayList<>();
	
	public List<Crypto> getCryptos() {
		return cryptos;
	}
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCryptos(List<Crypto> cryptos) {
		this.cryptos = cryptos;
	}

	public CryptoExchange(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	
}
