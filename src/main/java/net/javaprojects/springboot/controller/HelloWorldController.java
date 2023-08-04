package net.javaprojects.springboot.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller //use this to make a java class a spring MVC controller
//@ResponseBody   //use this to tell the controller to automatically convert it to serialized JSON response
// OR just @ResponseController (combines those two^)
@RestController
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world") // we use this to mat HTTP GET request onto specific handler method
    public String helloWorld(){
        return "Hel lo World!";
    }
}
