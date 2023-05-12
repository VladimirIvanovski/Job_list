package com.example.job__listing.repository;

import com.example.job__listing.Models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String>
{

}
