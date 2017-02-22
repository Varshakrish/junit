package com.varsha.bookapp.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.varsha.bookapp.model.Book;

public class BookDAOTest {

	@Test
	public void testSave() {
		Book book=new Book();
		book.setName("C++");
		book.setPrice(500.25f);
		BookDAO dao=new BookDAO();
		dao.save(book);
	}

	@Test
	public void testFindAll() {
		BookDAO dao = new BookDAO();
		List<Book> list = dao.findAll();
		for (Book b : list) {
			System.out.println(b);
	}
	}
}
