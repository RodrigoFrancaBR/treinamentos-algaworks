package br.com.franca.apiEnriquecimentoRestaurante.api.controller;

import br.com.franca.apiEnriquecimentoRestaurante.domain.model.Restaurante;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/enriquecimento/restaurante")
public class RestauranteController {

    @GetMapping(path = "id", produces = MediaType.TEXT_XML_VALUE)
    public Restaurante getRestaurante(@RequestParam Long id, @RequestParam String token) {
        log.info("inicio getRestaurante()");
        return new Restaurante(1l, "Nome do Restaurante", "99999999999999");
    }
}
