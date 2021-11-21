package br.com.franca.msenriquecimentorestaurante.domain.service;

import br.com.franca.msenriquecimentorestaurante.domain.model.Restaurante;
import br.com.franca.msenriquecimentorestaurante.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    public Restaurante obterRestauranteEnriquecido(Long id) {
        return repository.findById(id).get();
    }
}
