package cn.wuweiblog.computertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Jervain on 2016-11-17.
 */
@SpringBootApplication
public class ComputerTestApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ComputerTestApplication.class);
        application.run(args);
    }

}
