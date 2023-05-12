package com.example.job__listing.Controller;

import com.example.job__listing.Models.Post;
import com.example.job__listing.repository.PostRepository;
import com.example.job__listing.repository.SearchRepository;
import com.example.job__listing.repository.SearchRrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
public class PostController {

    @Autowired
    SearchRrepo srepo;

    @Autowired
    PostRepository repo;

    @ApiIgnore
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }


    @PostMapping("/postJob")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @GetMapping("/allPosts")
    public List<Post> getAllposts()
    {
        return repo.findAll();
    }

    @GetMapping("/posts/{text2}")
    public List<Post> search(@PathVariable String text2)
    {
        return srepo.findByText(text2);
    }
}
