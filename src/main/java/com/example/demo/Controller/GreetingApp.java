package com.example.demo.Controller;

import com.example.demo.Model.Greeting;
import com.example.demo.Model.User;
import com.example.demo.Service.GreetingServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingApp {

    private final GreetingServices greetingServices;

    public GreetingApp(GreetingServices greetingServices) {
        this.greetingServices = greetingServices;
    }

    // GET all greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingServices.getAllGreetings();
    }

    // GET specific greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable int id) {
        return greetingServices.getGreetingById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // POST - Save new greeting
    @PostMapping
    public ResponseEntity<Greeting> saveGreeting(@RequestParam String message, @RequestBody User user) {
        Greeting savedGreeting = greetingServices.saveGreeting(message, user);
        return ResponseEntity.ok(savedGreeting);
    }

    // PUT - Update existing greeting
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable int id, @RequestBody Greeting greeting) {
        return greetingServices.updateGreeting(id, greeting);
    }

    // DELETE greeting
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable int id) {
        greetingServices.deleteGreeting(id);
        return "Greeting with ID " + id + " deleted.";
    }
}
