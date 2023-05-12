package com.example.job__listing.repository;

import com.example.job__listing.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User,String>
{
    User findByUsername(String username);
}
