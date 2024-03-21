package com.bookstore.repostaryyyy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.Entity.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList , Integer>{

}
