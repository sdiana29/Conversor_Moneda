

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public DatosConsulta datosConsulta() throws IOException, InterruptedException {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/235c1dd61702b15b727f01bd/latest/PEN");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), DatosConsulta.class);
    }

    public static void main(String[] args) {
        Consulta consulta = new Consulta();
        try {
            DatosConsulta datos = consulta.datosConsulta();
            System.out.println(datos);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}