import com.tomasjuliano.conversor.model.Moneda;
import com.tomasjuliano.conversor.service.ConversorMonedasService;

import java.util.Scanner;

public static void main(String[] args) {
    ConversorMonedasService service = new ConversorMonedasService();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Sea bienvenido/a al Conversor de Monedas");

    Moneda monedaPrincipal = service.PedirMonedaInicial();

    if (monedaPrincipal != null){
        String monedaSecundaria = service.PedirMonedaACambiar(monedaPrincipal);
        service.ConvertirMoneda(monedaPrincipal, monedaSecundaria);
    }else {
        System.out.println("Saliendo...");
        return;
    }

}