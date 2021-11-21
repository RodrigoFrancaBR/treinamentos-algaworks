package br.com.franca.msenriquecimentorestaurante.domain.repository;

import br.com.franca.msenriquecimentorestaurante.domain.model.Restaurante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante,Long> {
    Optional<Restaurante> findById(Long id);
}
