package com.cryptoTransactionSystem.cryptos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Crypto implements Comparable<Crypto>{
	@Id
	@GeneratedValue
	long id;
	@Column(name="name")
	String name;
	@Column(name="price")
	int price;
	@Column(name="holders")
	int holders;
	
	public Crypto(String name, int price, int holders) {
		this.name = name;
		this.price = price;
		this.holders = holders;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Crypto [id=" + id + ", name=" + name + ", price=" + price + ", holdersNumber=" + holders + "]";
	}
	public Crypto(){}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getHolders() {
		return holders;
	}


	public void setHolders(int holdersNumber) {
		this.holders = holdersNumber;
	}


	@Override
	public int compareTo(Crypto o) {
		return this.getName().equals(o.getName()) ? 0 : 1;
	}


	

}
