package com.whx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication()
public class EmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class,args);
        System.out.println("     —        —————————     =        —        ————————— ");
        System.out.println("   /   \\      |             |       /  \\      |       |");
        System.out.println("  /     \\     |      ———    |      /    \\     |       |");
        System.out.println(" /———————\\    |       |     |     /——————\\    |       |");
        System.out.println("/         \\   —————————     |    /        \\   —————————");

    }
}
