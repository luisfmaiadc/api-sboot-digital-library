package com.portfolio.api_sboot_digital_library.domain.endereco;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class viaCepAPI {

    public Endereco pesquisaEndereco(String cep, String numero) {
        URI uri = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            viaCepEndereco viaCepEndereco = new Gson().fromJson(response.body(), viaCepEndereco.class);

            if (viaCepEndereco.erro()) {
                throw new RuntimeException("Não foi possível encontrar o CEP informado.");
            }

            return new Endereco(viaCepEndereco, numero);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
