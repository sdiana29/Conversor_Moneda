import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Consulta consulta1 = new Consulta();

        try {
            DatosConsulta datos = consulta1.datosConsulta();
            System.out.println("Moneda Base: " + datos.getBase_code());
            System.out.println("Conversiones Disponibles: " + datos.getConversion_rates().keySet());
            System.out.print("Ingrese el monto en " + datos.getBase_code() + ": ");
            double amount = sc.nextDouble();
            System.out.print("Ingrese la moneda a convertir: ");
            String targetCurrency = sc.next().toUpperCase();
            Map<String, Object> conversionRates = datos.getConversion_rates();
            if (conversionRates.containsKey(targetCurrency)) {
                double rate = ((Number)conversionRates.get(targetCurrency)).doubleValue();
                double convertedAmount = amount * rate;
                System.out.printf("%.2f %s es equivalente a %.2f %s%n", amount, datos.getBase_code(), convertedAmount, targetCurrency);
            } else {
                System.out.println("Moneda a convertir es inválida.");
            }
        } catch (InterruptedException | IOException var12) {
            Exception e = var12;
            e.printStackTrace();
        }

    }
}
