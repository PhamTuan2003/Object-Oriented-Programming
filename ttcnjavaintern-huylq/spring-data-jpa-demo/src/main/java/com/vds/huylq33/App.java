package com.vds.huylq33;

import com.vds.huylq33.config.PersistenceContext;
import com.vds.huylq33.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonService personService = (PersonService) context.getBean("personServiceImpl");
    }
}
