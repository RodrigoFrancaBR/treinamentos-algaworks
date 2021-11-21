package br.com.franca.apiEnriquecimentoRestaurante.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/enriquecimento/restaurante")
public class GetToken {
    @GetMapping(path = "/token", produces = MediaType.TEXT_XML_VALUE)
    public String getToken(@RequestParam String user, @RequestParam String password, @RequestParam String client) throws JsonProcessingException {
        ObjectMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString("tokenXYZ");
    }
}
