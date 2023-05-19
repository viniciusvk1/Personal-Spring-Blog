package com.github.viniciusvk1.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atribuito titulo e obrigatorio!")
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 05 e no minimo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O atribuito titulo e obrigatorio!")
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 05 e no maximo 100 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
}