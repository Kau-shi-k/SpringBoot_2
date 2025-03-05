package com.example.demo.Service;

import com.example.demo.Model.Greeting;
import com.example.demo.Model.User;
import com.example.demo.Repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServices {

    private final GreetingRepository greetingRepository;

    public GreetingServices(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message, User user) {
        Greeting greeting = new Greeting("Hello " + user.getFirstName() + " " + user.getLastName() + " " + message, user);
        return greetingRepository.save(greeting);

    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<Greeting> getGreetingById(int id) {
        return greetingRepository.findById(id);
    }

    public Greeting updateGreeting(int id, Greeting newGreeting) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newGreeting.getMessage());
            return greetingRepository.save(greeting);
        }).orElse(null);
    }

    public void deleteGreeting(int id) {
        greetingRepository.deleteById(id);
    }
}
