package com.tomasjuliano.conversor.model;

import java.util.Map;

public record ConversorMonedasResponse(
    String result, //Resultado de la consulta
    String time_last_update_utc, //Última actualización de la valor
    String base_code, //Código de la moneda consultada
    Map<String, Double> conversion_rates //Tasas de cambio de la moneda consultada
){}
