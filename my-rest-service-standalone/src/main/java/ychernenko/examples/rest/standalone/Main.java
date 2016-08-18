package ychernenko.examples.rest.standalone;

import org.springframework.boot.SpringApplication;

public class Main {

    public static void main(String[] args) {
        new SpringApplication(StandaloneConfig.class).run(args);
    }
}
