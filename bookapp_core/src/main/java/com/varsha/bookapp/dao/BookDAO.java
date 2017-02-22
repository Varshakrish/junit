package com.varsha.bookapp.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.varsha.bookapp.model.Book;
import com.varsha.bookapp.util.ConnectionUtil;

public class BookDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Book book) {

		String sql = "insert into books(name,price) values(?,?)";
		Object[] args = { book.getName(), book.getPrice() };
		int rows = jdbcTemplate.update(sql, args);
		System.out.println("No. of rows inserted: " + rows);
	}

	public List<Book> findAll() {

		String sql = "select id,name,price from books";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getFloat("price"));
			return book;
		});

	}

}
