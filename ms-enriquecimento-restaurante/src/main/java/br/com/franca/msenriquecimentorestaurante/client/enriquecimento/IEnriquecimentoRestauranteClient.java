package br.com.franca.msenriquecimentorestaurante.client.enriquecimento;

import br.com.franca.msenriquecimentorestaurante.config.FeignConfig;
import br.com.franca.msenriquecimentorestaurante.domain.AuthenticatedUser;
import br.com.franca.msenriquecimentorestaurante.domain.model.Restaurante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api-enriquecimento", url = "http://localhost:8090/api/enriquecimento/restaurante")
public interface IEnriquecimentoRestauranteClient {

    @GetMapping(path="id", produces = MediaType.TEXT_XML_VALUE)
    Restaurante getRestaurante(@RequestParam Long id);

    @GetMapping(path = "token", produces = MediaType.TEXT_XML_VALUE)
    AuthenticatedUser getToken(@RequestParam String user, @RequestParam String password, @RequestParam String client);

}
