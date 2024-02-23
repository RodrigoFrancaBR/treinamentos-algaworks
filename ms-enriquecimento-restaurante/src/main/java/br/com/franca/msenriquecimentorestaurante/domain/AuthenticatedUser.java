package br.com.franca.msenriquecimentorestaurante.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticatedUser {

    private String token;
}
