package com.bookstore.serviceeeeee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Entity.MyBookList;
import com.bookstore.repostaryyyy.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBook(){
		return mybook.findAll();
		
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
