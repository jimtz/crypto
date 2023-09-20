package com.cryptoTransactionSystem.cryptos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CryptoJdbcRepository {
	@Autowired
	private JdbcTemplate spr_temp;

	
	public static String insertQuery = """
			insert into crypto(id, name, price, holders)
			values(?, ?, ?, ?);
			""";
	public static String deleteQuery = """
			delete from crypto
			where id = ?
			""";
	public static String selectQuery = """
			select * from crypto
			where id = ?
			""";
	
	public void insert(Crypto crypto)  {
		spr_temp.update(insertQuery, crypto.getId(), crypto.getName(), crypto.getPrice(), crypto.getHolders());
	}
	public void deleteById(long id) {
		spr_temp.update(deleteQuery, id);
	}
	public Crypto findById(long id) {
		return spr_temp.queryForObject(selectQuery, new BeanPropertyRowMapper<>(Crypto.class), id);
	}
}
