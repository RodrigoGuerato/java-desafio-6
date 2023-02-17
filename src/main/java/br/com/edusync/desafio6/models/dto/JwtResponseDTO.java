package br.com.edusync.desafio6.models.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtResponseDTO implements Serializable {

	private static final long serialVersionUID = 3505540560818582154L;

    private String jwtToken;
}
