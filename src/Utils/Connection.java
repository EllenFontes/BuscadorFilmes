package Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    private String body;

    public void conectar(String busca) throws IOException, InterruptedException {


        String link = "https://www.omdbapi.com/?apikey=39fc64df&t=" + busca;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        this.body = response.body();
        System.out.println("Resposta da API:" + this.getBody());

    }

    public String getBody(){
        return this.body;
    }

}
