package me.mason.springbatch;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * @author  mason
 * @since  2019/6/1
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	    SpringApplication app = new SpringApplication(Application.class);
	    app.setBannerMode(Mode.OFF);
	    app.run(args);
	}
}
