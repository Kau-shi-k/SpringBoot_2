package com.example.demo.Controller;
import com.example.demo.Model.Greeting;
import com.example.demo.Service.GreetingServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingApp {
    GreetingServices greetingServices;
    public void GreetingController(GreetingServices greetingServices) {
        this.greetingServices = greetingServices;
    }
    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "WEB") String name){
        return new Greeting("Hello" + " " + name + "!");
    }

    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting){
        return new Greeting("Posted: " + greeting.getMessage());
    }

    @PutMapping("/{id}")
    public Greeting putGreeting(@PathVariable int id, @RequestBody Greeting greeting){
        return new Greeting(id + greeting.getMessage());
    }

    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable int id){
        return id + "Deleted";
    }

    @GetMapping("/services")
    public String greetingServices() {
        return greetingServices.getGreeting();
    }
}
