package com.bookstore.repostaryyyy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.Entity.Book;
@Repository
public interface BookRepostory extends JpaRepository<Book , Integer> {
	

}
