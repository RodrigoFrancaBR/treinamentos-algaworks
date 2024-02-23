package br.com.franca.msenriquecimentorestaurante.config;

import feign.Client;
import feign.Request;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class CustomFeignClient extends Client.Default{

    public CustomFeignClient(SSLSocketFactory sslContextFactory, HostnameVerifier hostnameVerifier) {
        super(sslContextFactory, hostnameVerifier);
    }

    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        log.info("iniciando o execute():::::::");
        var response = super.execute(request, options);
         var bodyStream = response.body().asInputStream();
        var responseBody = StreamUtils.copyToString(bodyStream, StandardCharsets.UTF_8);
        log.info("encerrando o execute():::::::");
        return response.toBuilder().body(responseBody, StandardCharsets.UTF_8).build();
    }
}
