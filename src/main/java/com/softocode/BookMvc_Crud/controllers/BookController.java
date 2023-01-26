package com.softocode.BookMvc_Crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softocode.BookMvc_Crud.beans.Book;
import com.softocode.BookMvc_Crud.dao.BookDAO;

@Controller
public class BookController {

	@Autowired
	BookDAO dao;

	@RequestMapping("/editbook")
	public String showform(Model m) {
		m.addAttribute("command", new Book());
		return "book_entry";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("Book") Book book) {
		dao.insertBook(book);
		return "redirect:/viewbook";
	}

	@RequestMapping("/viewbook")
	public String viewbook(Model m) {
		List<Book> list = dao.getBooks();
		m.addAttribute("list", list);
		return "book_list";
	}

	@RequestMapping(value = "/editbook/{id}")
	public String edit(@PathVariable int id, Model m) {
		Book book = dao.getBookById(id);
		m.addAttribute("command", book);
		return "book_edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("Book") Book book) {
		dao.updateBook(book);
		return "redirect:/viewbook";
	}

	@RequestMapping(value="/deletebook/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id, Model m) {
		dao.deleteBook(id);
		return "redirect:/viewbook";
	}
}
