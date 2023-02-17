package br.com.edusync.desafio6.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
    private String password;	

}
