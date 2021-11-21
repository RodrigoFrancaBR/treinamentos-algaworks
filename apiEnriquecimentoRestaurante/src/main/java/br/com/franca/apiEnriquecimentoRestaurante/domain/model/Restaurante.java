package br.com.franca.apiEnriquecimentoRestaurante.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {
    private Long id;
    private String nome;
    private String cnpj;

    /**
     * @TODO outros atributos de um restaurante.
     */
}
