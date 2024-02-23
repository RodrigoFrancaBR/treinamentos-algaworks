package br.com.franca.msenriquecimentorestaurante.domain.service;

import br.com.franca.msenriquecimentorestaurante.client.enriquecimento.IEnriquecimentoRestauranteClient;
import br.com.franca.msenriquecimentorestaurante.domain.AuthenticatedUser;
import br.com.franca.msenriquecimentorestaurante.domain.model.Restaurante;
import br.com.franca.msenriquecimentorestaurante.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    private String usuario ="rfrancacosta@gmail.com";
    private String senha ="rfrancacosta@gmail.com";
    private String cliente ="Franca";

    @Autowired
    private IEnriquecimentoRestauranteClient client;

    @Autowired
    private RestauranteRepository repository;

    public Restaurante obterRestauranteEnriquecido(Long id) {
        return repository.findById(id).orElseGet(()->getApiEnriquecimento(id));
    }

    private Restaurante getApiEnriquecimento(Long id) {
        return client.getRestaurante(id);
    }

    public AuthenticatedUser login() {
        var authenticatedUser = client.getToken(usuario, senha, cliente);
        return authenticatedUser;
    }
}
