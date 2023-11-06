package com.spring.rest_api2;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.rest_api2.modal.Book;

@SpringBootApplication
public class RestApi2Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(RestApi2Application.class, args);
		System.err.println("\n\t\t!!..Application has been started..!!");
		Book b=ctx.getBean(Book.class);
		b.setBook_id(101);
		b.setName("Test name");
		b.setPages(234);
		b.setTitle("test title");
		b.setLastmodified(new Date());

		System.out.println(b.toString());
	}

}
