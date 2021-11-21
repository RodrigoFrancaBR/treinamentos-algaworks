package br.com.franca.apiEnriquecimentoRestaurante.api.controller;

import br.com.franca.apiEnriquecimentoRestaurante.domain.model.Restaurante;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/enriquecimento/restaurante")
public class RestauranteController {

    @GetMapping(path = "/id", produces = MediaType.TEXT_XML_VALUE)
    public Restaurante getRestaurante(@RequestParam Long id, @RequestParam String token) {
    return new Restaurante(1l, "Nome do Restaurante", "99999999999999");
    }
}
