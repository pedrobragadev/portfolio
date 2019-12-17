package br.com.embravix.encontrecasa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exemplo {

    @RequestMapping("/")
    public String home(){
        return "Hello World !";
    }
}
