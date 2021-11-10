package br.com.aps;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@WebServlet(name = "Previsoes", urlPatterns = { "/consultaprevisoes" })
@SpringBootApplication
public class ApsApplication extends HttpServlet {

	public static void main(String[] args) {
		SpringApplication.run(ApsApplication.class, args);
	}

}
