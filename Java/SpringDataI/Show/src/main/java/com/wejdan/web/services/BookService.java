package com.wejdan.web.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wejdan.web.models.Book;
import com.wejdan.web.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
	 private final BookRepository bookRepository;
	 
	 public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    
//      public Book updateBook( Long id  , String title ,  String desc ,  String lang, Integer numOfPages ){
//    	Optional<Book> optionalBook = bookRepository.findById(id);
//    	  if(optionalBook.isPresent()) {
//	            Book book =  optionalBook.get();
//	            book.setTitle(title);
//	            book.setDescription(desc);
//	            book.setLanguage(lang);
//	            book.setNumberOfPages(numOfPages);
//	            return bookRepository.save(book);
//	            
//	        } else {
//	            return null;
//	        }
// 
//	    }
	    public Book updateBook(Book b) {
	        return bookRepository.save(b);
	    }
	    
	    
	    
	   public void deleteBook(Long id) {
		   bookRepository.deleteById(id);
        }
	    
	    
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	
	

}