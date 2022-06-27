package com.example.MyBookShopApp.controllers;


import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookShop")
public class MainPageController {

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    private final BookService bookService;
    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookService.getBooksData());
        model.addAttribute("searchPlaceholder", "new search placeholder");
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(){
        return "genres/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model){
        model.addAttribute("author", bookService.getAuthors());
        return "authors/index";
    }
}
