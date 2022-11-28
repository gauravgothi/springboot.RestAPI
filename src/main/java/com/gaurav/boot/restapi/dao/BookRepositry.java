package com.gaurav.boot.restapi.dao;

import com.gaurav.boot.restapi.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface BookRepositry extends CrudRepository<Book,Integer> {
    public Book findByBookId(int id);
}
