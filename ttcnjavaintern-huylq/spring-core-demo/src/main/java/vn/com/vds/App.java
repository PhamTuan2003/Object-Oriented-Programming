package vn.com.vds;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.com.vds.config.AppConfig;
import vn.com.vds.model.Account;
import vn.com.vds.service.AccountService;

public class App {

    public static void main(String[] args) {
/*
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("spring-beans.xml");
*/
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        context.getBean("appConfig", AppConfig.class).setEnvironment();

        final Account account = context.getBean("accountService", AccountService.class).findAccountById(1L);
        System.out.println(account);
    }
}
