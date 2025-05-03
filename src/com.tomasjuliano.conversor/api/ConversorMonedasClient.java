package com.tomasjuliano.conversor.api;

import com.google.gson.Gson;
import com.tomasjuliano.conversor.model.ConversorMonedasResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedasClient {
    public ConversorMonedasResponse ConsultarMoneda (String codigoMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/54d629a5ef2e39c90636b669/latest/"+codigoMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(direccion)))
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ConversorMonedasResponse.class);

        }catch (Exception e){
            throw  new RuntimeException("No encontré esa divisa.");
        }
    }
}
