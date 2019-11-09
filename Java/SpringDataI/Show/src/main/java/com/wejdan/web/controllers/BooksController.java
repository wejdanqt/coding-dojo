package com.wejdan.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wejdan.web.models.Book;
import com.wejdan.web.services.BookService;

//... imports removed for brevity
@Controller
public class BooksController {
 private final BookService bookService;
 
 public BooksController(BookService bookService) {
     this.bookService = bookService;
 }
 
 //Show all the books
 @RequestMapping("/allbooks")
 public String index(Model model) {
     List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
 }
 
 //Create new book 
 @RequestMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book) {
     return "/books/new.jsp";
 }
 @RequestMapping(value="/books", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/allbooks";
     }
 }
 
 //Show method 
 @RequestMapping("/books/{id}")
 public String show(Model model,@PathVariable("id") Long id) {
	 Book book = bookService.findBook(id);
	  model.addAttribute("book", book);
     return "/books/show.jsp";
 }
 
 //edit methods 
 
 @RequestMapping("/books/{id}/edit")
 public String edit(@PathVariable("id") Long id, Model model) {
     Book book = bookService.findBook(id);
     model.addAttribute("book", book);
     return "/books/edit.jsp";
 }
 
 @RequestMapping(value="/books/edit/{id}", method=RequestMethod.POST)
 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/edit.jsp";
     } else {
         bookService.updateBook(book);
         return "redirect:/allbooks";
     }
 }
 
 //delete method 
 @RequestMapping(value="/books/delete/{id}", method=RequestMethod.POST)
 public String destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
     return "redirect:/allbooks";
 }
 
 
 
}
