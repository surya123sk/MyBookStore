package com.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.serviceeeeee.MyBookListService;

@Controller
public class MyBooklistControler {

	@Autowired
	private MyBookListService myBooklist;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		myBooklist.deleteById(id);
		return "redirect:/my_books";
		
	}
}
