package com.github.viniciusvk1.personalBlog.repository;

import com.github.viniciusvk1.personalBlog.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posting, Long> {
}