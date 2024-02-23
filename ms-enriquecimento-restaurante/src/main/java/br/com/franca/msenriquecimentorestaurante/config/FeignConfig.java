package br.com.franca.msenriquecimentorestaurante.config;

import br.com.franca.msenriquecimentorestaurante.domain.AuthenticatedUser;
import br.com.franca.msenriquecimentorestaurante.domain.service.RestauranteService;
import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class FeignConfig implements RequestInterceptor {

    private static final String PATH_URL= "token";

    @Autowired
    private RestauranteService service;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("inicio apply():::::::");
        Optional.ofNullable(service)
                .filter(auth -> !requestTemplate.url().contains(PATH_URL))
                .map(RestauranteService::login)
                .map(AuthenticatedUser::getToken)
                .ifPresent(token -> requestTemplate.queries(Map.of(PATH_URL, Collections.singleton(token))));
        log.info("fim apply():::::::");
    }

    @Bean
    public Client client(){
        return new CustomFeignClient(null, null);
    }
}
