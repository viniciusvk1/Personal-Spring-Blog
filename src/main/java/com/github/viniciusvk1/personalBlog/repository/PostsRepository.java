package com.github.viniciusvk1.personalBlog.repository;

import com.github.viniciusvk1.personalBlog.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posting, Long> {

    public List<Posting> findAllByTitleContainingIgnoreCase(@Param("title") String title);


}