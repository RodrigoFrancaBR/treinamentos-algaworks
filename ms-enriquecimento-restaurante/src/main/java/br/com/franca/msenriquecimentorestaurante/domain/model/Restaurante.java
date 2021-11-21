package br.com.franca.msenriquecimentorestaurante.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dataDeCriacao;

    @UpdateTimestamp
    private LocalDateTime dataDeAtualizacao;

    /**
     * @TODO outros atributos de um restaurante.
     */
}