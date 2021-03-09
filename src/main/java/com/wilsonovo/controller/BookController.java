package com.wilsonovo.controller;

import com.wilsonovo.pojo.Books;
import com.wilsonovo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
