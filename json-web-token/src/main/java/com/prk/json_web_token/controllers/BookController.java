package com.prk.json_web_token.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.prk.json_web_token.entities.Author;
import com.prk.json_web_token.entities.Book;

@Controller
public class BookController {
	
	@QueryMapping
	public Book bookById(@Argument String id) {
		return Book.getById(id);
	}
	
	@SchemaMapping
	public Author author(Book book) {
		return Author.getById(book.authorId());
	}
}
