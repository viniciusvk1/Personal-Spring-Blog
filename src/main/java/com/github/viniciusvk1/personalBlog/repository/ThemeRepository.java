package com.github.viniciusvk1.personalBlog.repository;

import com.github.viniciusvk1.personalBlog.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    public List<Theme> findAllByDescriptionContainingIgnoreCase(@Param("description") String description);

}