package hello.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class ChatbotApplication {

	public static void main(String[] args) {


		SpringApplication.run(ChatbotApplication.class, args);
	}

}
