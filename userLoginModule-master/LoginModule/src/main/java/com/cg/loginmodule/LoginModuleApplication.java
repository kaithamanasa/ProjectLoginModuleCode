package com.cg.loginmodule;
import org.apache.log4j.BasicConfigurator;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author MANASA KAITHA
 *
 */


@SpringBootApplication
public class LoginModuleApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginModuleApplication.class, args);
		BasicConfigurator.configure();
		Logger logger=Logger.getLogger(LoginModuleApplication.class);
		logger.info("Open");
		
	}
}
