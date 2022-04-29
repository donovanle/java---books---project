package com.donovan.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.donovan.books.models.Book;
import com.donovan.books.services.BookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model) {
		Book oneBook = bookService.findBook(id);
		model.addAttribute("book", oneBook);
		return "oneBook.jsp";
	}
	
	@GetMapping("/books")
	public String allBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "allBooks.jsp";
	}
}
