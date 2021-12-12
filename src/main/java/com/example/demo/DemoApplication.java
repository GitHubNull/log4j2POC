package com.example.demo;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
//	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		// 解决问题代码（实际生产中没人会自己去开启这个会导致系统不安全的选项）
//		System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		if(name.indexOf("select")>0){
			return "";
		}
		logger.info("hello " + name);
		return "hello " + name;
	}
}
