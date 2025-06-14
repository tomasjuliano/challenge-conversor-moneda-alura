package com.tomasjuliano.conversor.api;

import com.google.gson.Gson;
import com.tomasjuliano.conversor.model.ConversorMonedasResponse;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedasClient {
    // Armado de URL con API_KEY privada.
    private Dotenv dotenv = Dotenv.load();
    private final String API_KEY = dotenv.get("ER_API_KEY");
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/" + API_KEY;

    public ConversorMonedasResponse ConsultarMoneda (String codigoMoneda){
        URI direccion = URI.create(URL_BASE + "latest/" + codigoMoneda);

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
