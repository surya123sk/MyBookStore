package com.bookstore.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.bookstore.Entity.Book;
import com.bookstore.Entity.MyBookList;
import com.bookstore.serviceeeeee.BookService;
import com.bookstore.serviceeeeee.MyBookListService;

@Controller
public class BookController {

	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService mybookservice;
	
	@GetMapping("/")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
		
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllbooks() {
		List<Book> list = service.getAllBook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("booklist");
//		m.addObject("book" ,list);
		return new ModelAndView("booklist","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
		
	}
	
	@GetMapping("/my_books")
	public String getNyBooks(Model model) {
		List<MyBookList> list = mybookservice.getAllMyBook();
		model.addAttribute("book",list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(), b.getAuther(), b.getPrice());
		mybookservice.saveMyBooks(mb);
		return "redirect:/my_books";
		
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id , Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("Book" , b) ;
		return "bookedit";
		
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteByid(id);
		return "redirect:/available_books";
		
	}
	
}
