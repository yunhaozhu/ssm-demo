package com.wilsonovo.controller;

import com.wilsonovo.pojo.Books;
import com.wilsonovo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class  BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    public String allBooks(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBooks";
    }

    @RequestMapping("/addBookPage")
    public String addBookPage(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/all";
    }

    @RequestMapping("/editBookPage")
    public String editBookPage(int id, Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("Book",book);
        return "editBook";
    }

    @RequestMapping("/editBook")
    public String editBook(Books books){
        System.out.println(books);
        bookService.updateBook(books);
        return "redirect:/book/all";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/all";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String bookName, Model model){
        Books book = bookService.queryBookByName(bookName);
        List<Books> books = new ArrayList<>();
        if(book==null){
            model.addAttribute("error","Not Found!");
        }
        books.add(book);
        model.addAttribute("list",books);
        return "allBooks";
    }

}
