package com.example.job__listing.Controller;

import com.example.job__listing.Models.AuthenticationRequest;
import com.example.job__listing.Models.AuthenticationResponse;
import com.example.job__listing.Models.Post;
import com.example.job__listing.Models.User;
import com.example.job__listing.repository.PostRepository;
import com.example.job__listing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private PostRepository postRep;

    //adding a new client to the server
    @PostMapping("/subscription")
    private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
    {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        try {
            userRep.save(user); //save to the databae
        }
        catch (Exception e)
        {
            return ResponseEntity.ok(new AuthenticationResponse("Error adding the user"));
        }


        return ResponseEntity.ok(new AuthenticationResponse("Added new user " + username));
    }
    @GetMapping("/allposts-by-user/{id}")
    private List<Post> subscribeClient(@PathVariable String id)
    {
        List<Post> posts = postRep.findAll();
        List<Post> found =new ArrayList<>();
        for(Post p : posts)
        {
            if(p.getUserId().equals(id))
            {
                found.add(p);
            }
        }
        return found;
    }

    @GetMapping("user/{username}")
    private User getUser(@PathVariable String username)
    {
        if(userRep.findById(username).isEmpty())
            return null;

        return userRep.findById(username).get();
    }

}
