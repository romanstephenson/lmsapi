package com.lms.lmsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends CrudRepository<BookCategory, Integer>{

}
