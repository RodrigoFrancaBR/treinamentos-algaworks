package br.com.franca.msenriquecimentorestaurante.api.controller;

import br.com.franca.msenriquecimentorestaurante.domain.model.Restaurante;
import br.com.franca.msenriquecimentorestaurante.domain.service.RestauranteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/enriquecimento")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurante obterRestauranteEnriquecido(@PathVariable Long id){
        return service.obterRestauranteEnriquecido(id);
    }
}
