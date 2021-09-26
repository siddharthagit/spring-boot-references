package example.restapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

//@ComponentScan({"com.bootng"})
@SpringBootApplication
public class SpringBootMysqlApplication {

	@Autowired
    private DispatcherServlet servlet;
	
	public static void main(String[] args) {
		//servlet.setThrowExceptionIfNoHandlerFound(true);
		
		SpringApplication.run(SpringBootMysqlApplication.class, args);
	}

}
