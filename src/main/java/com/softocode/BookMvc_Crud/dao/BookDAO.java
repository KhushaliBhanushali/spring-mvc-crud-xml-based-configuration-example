package com.softocode.BookMvc_Crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.softocode.BookMvc_Crud.beans.Book;

public class BookDAO {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insertBook(Book b1) {
		String sql = "insert into book (title,author,price) values (?,?,?)";
		return template.update(sql,b1.getTitle(),b1.getAuthor(),b1.getPrice());
	}
	
public int updateBook(Book b1) {
		String sql = "update book set title=? , author=? , price=? where id=?";
		return template.update(sql,b1.getTitle(),b1.getAuthor(),b1.getPrice(),b1.getId());
	}

public int deleteBook(int id) {
	String sql = "delete from book where id=?";
	return template.update(sql, id);
}

public Book getBookById(int id) {
	String sql = "select * from book where id=?";
	return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Book>(Book.class));
}

public List<Book> getBooks() {
	String sql = "select * from book";
	
	return template.query(sql, new RowMapper<Book>() {

		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book b = new Book();
			b.setId(rs.getInt(1));
			b.setTitle(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getFloat(4));
			return b;
		}
		
	});
}
}
