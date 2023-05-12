package com.example.job__listing.repository;

import com.example.job__listing.Models.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
