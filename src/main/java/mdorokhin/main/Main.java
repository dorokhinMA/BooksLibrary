package mdorokhin.main;

import mdorokhin.model.Author;
import mdorokhin.service.AuthorService;
import mdorokhin.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maxim Dorokhin
 *         09.09.2016.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-database.xml", "classpath:/META-INF/spring/spring-context.xml" );
       // AuthorService authorService = context.getBean("authorServiceImpl", AuthorService.class);
//
//        authorService.delete(4);
//
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
//
        System.out.println(bookService.getById(1, 5).getAuthor().getFio());
//
//        bookService.delete(3);

//        authorService.getAll().stream().forEach(System.out::println);
        //System.out.println(authorService.getById(5));

     //   authorService.save(new Author("Дашкиев"));


    }
}
