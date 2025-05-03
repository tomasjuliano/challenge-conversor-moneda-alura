package com.tomasjuliano.conversor.service;

import com.tomasjuliano.conversor.api.ConversorMonedasClient;
import com.tomasjuliano.conversor.model.ConversorMonedasResponse;
import com.tomasjuliano.conversor.model.Moneda;

import java.util.Objects;
import java.util.Scanner;

public class ConversorMonedasService {
    public Moneda PedirMonedaInicial(){
        Scanner scanner = new Scanner(System.in);

        String mensaje = """
        --------------------------------
        ¿Qué moneda desea convertir?
            1. ARS - Peso argentino
            2. BOB - Boliviano boliviano
            3. BRL - Real brasileño
            4. CLP - Peso chileno
            5. COP - Peso colombiano
            6. USD - Dólar estadounidense
            \s
            0. Salir del programa
        --------------------------------
        """;
        System.out.println(mensaje);

        int opcionUsuario = Integer.parseInt(scanner.nextLine());

        if (opcionUsuario == 0){ return null;};

        System.out.println("Monto a transformar: ");
        double monto = scanner.nextDouble();

        if (opcionUsuario == 1) {return new Moneda("ARS", monto);
        } else if (opcionUsuario == 2) {return new Moneda("BOB", monto);
        } else if (opcionUsuario == 3) {return new Moneda("BRL", monto);
        } else if (opcionUsuario == 4) {return new Moneda("CLP", monto);
        } else if (opcionUsuario == 5) {return new Moneda("COP", monto);
        } else if (opcionUsuario == 6) {return new Moneda("USD", monto);}

        return null;
    }

    public String PedirMonedaACambiar(Moneda monedaUsuario){
        Scanner scanner = new Scanner(System.in);

        String monedaPrincipal = monedaUsuario.getCodigo();
        double montoMoneda = monedaUsuario.getMonto();

        String mensaje = """
        --------------------------------
        Transformar $%s %s a:
            1. ARS - Peso argentino
            2. BOB - Boliviano boliviano
            3. BRL - Real brasileño
            4. CLP - Peso chileno
            5. COP - Peso colombiano
            6. USD - Dólar estadounidense
        --------------------------------
       """.formatted(montoMoneda, monedaPrincipal);
        System.out.println(mensaje);

        int opcionUsuario = Integer.parseInt(scanner.nextLine());

        if (opcionUsuario == 1) {return  "ARS";
        } else if (opcionUsuario == 2) {return  "BOB";
        } else if (opcionUsuario == 3) {return "BRL";
        } else if (opcionUsuario == 4) {return  "CLP";
        } else if (opcionUsuario == 5) {return  "COP";
        } else if (opcionUsuario == 6) {return  "USD";}

        System.out.println("Opción inválida.");
        return null;
    }

    public void ConvertirMoneda(Moneda monedaPrincipal, String monedaSecundaria){
        ConversorMonedasClient cliente = new ConversorMonedasClient();

        ConversorMonedasResponse respuesta = cliente.ConsultarMoneda(monedaPrincipal.getCodigo());


        Double valorConvertido = respuesta.conversion_rates().get(monedaSecundaria) * monedaPrincipal.getMonto();

        String mensaje = """
        --------------------------------
        $%s %s equivalen a $%s %s
        --------------------------------
        """.formatted(monedaPrincipal.getMonto(), monedaPrincipal.getCodigo(), valorConvertido, monedaSecundaria);
        System.out.println(mensaje);
    }
}