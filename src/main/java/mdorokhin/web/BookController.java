package mdorokhin.web;

import mdorokhin.model.Author;
import mdorokhin.model.Book;
import mdorokhin.service.AuthorService;
import mdorokhin.service.BookService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         10.09.2016.
 */

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;


    @RequestMapping(method = RequestMethod.GET) //+
    public String showAll(Model model) {

        List<Book> allBooks = bookService.getAll();
        List<Author> allAuthors = authorService.getAll();

        model.addAttribute("books", allBooks);
        model.addAttribute("authors", allAuthors);
        model.addAttribute("newAuthor", new Author());

        return "books";

    }


    @RequestMapping(value = "/get/{bookId}/{authorId}", method = RequestMethod.GET) //+
    public String show(@PathVariable("bookId") Integer bookId, @PathVariable("authorId") Integer authorId, Model model) {

        Book book = bookService.getById(bookId, authorId);

        model.addAttribute("book", book);

        return "book";

    }


    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.GET)//+
    public String deleteBook(@PathVariable("bookId") Integer bookId, Model model) {

        bookService.delete(bookId);

        return "redirect:/books";

    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)//+
    public String initAddForm(Model model) {

        List<Author> authorList = authorService.getAll();
        model.addAttribute("authorList", authorList);

        model.addAttribute("newBook", new Book());

        return "bookForm";

    }

//    @ModelAttribute("newBook")
//    public Book getNewBook(){
//        return new Book();
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute ("newBook") Book book,
//                          @RequestParam("authorId") Integer authorId,
                          Model model,
                          BindingResult bindingResult,
                          @RequestParam(value = "image", required = false) MultipartFile file) {

        System.out.println(book.getAuthor().getClass());
        if (bindingResult.hasErrors()) {

            return "bookForm";
        }

        if (file != null) {

            byte[] fileContent = null;
            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null) {
                    return "bookForm";
                } else {

                fileContent = IOUtils.toByteArray(inputStream);
                book.setImage(fileContent);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            book.setImage(fileContent);
        }


        bookService.save(book, book.getAuthor().getId());


        return "redirect:/books";

    }

    @RequestMapping(value = "/photo/{bookId}/{authorId}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable("bookId") Integer bookId, @PathVariable("authorId") Integer authorId ) {
        Book book = bookService.getById(bookId, authorId);

        if (book.getImage() != null) {

        }

        return book.getImage();
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)//+
    public String findByTitle(@RequestParam("title") String title, Model model) {
        List<Book> bookListByTitle = bookService.getByTitle(title);

        model.addAttribute("books", bookListByTitle);
        model.addAttribute("newAuthor", new Author());

        return "books";
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST) //+
    public String addAuthor(@ModelAttribute("newAuthor") Author author, Model model) {

        authorService.save(author);

        return "redirect:/books";

    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET) //+
    public String getBooksByAuthor(@PathVariable("id") Integer authorId, Model model) {

        List<Book> booksByAuthor = bookService.getByAuthor(authorId);
        List<Author> allAuthors = authorService.getAll();

        model.addAttribute("newAuthor", new Author());
        model.addAttribute("authors", allAuthors);
        model.addAttribute("books", booksByAuthor);

        return "books";

    }

    @RequestMapping(value = "/update/{bookId}/{authorId}", method = RequestMethod.GET)
    public String initUpdate(@PathVariable("bookId") Integer bookId, @PathVariable("authorId") Integer authorId, Model model) {

        Book tmp = bookService.getById(bookId, authorId);
        List<Author> allAuthors = authorService.getAll();

        model.addAttribute("authorList", allAuthors);

        model.addAttribute("updatingBook", tmp);

        return "bookForm";

    }


}
