package com.github.viniciusvk1.personalBlog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "tb_temas")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This description field is mandatory")
    private String description;

    public List<Posting> getPosting() {
        return posting;
    }

    public void setPosting(List<Posting> posting) {
        this.posting = posting;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "theme", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("theme")
    private List<Posting> posting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
