package Principal;

import Modelos.ResponseOMDB;
import Utils.*;
import Excecao.DuracaoNuloException;
import Modelos.Titulo;
import Modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List lista = new ArrayList<Titulo>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();


        while (true) {

            //Entrada de dados e chamada da API

            String titulo = EntradaDados.entrada();

            if (titulo.equalsIgnoreCase("sair")) {
                break;
            }

            Connection conexao = new Connection();
            conexao.conectar(titulo);

            //Checa se o titulo foi ou não encontrado
            ResponseOMDB responseOMDB = gson.fromJson(conexao.getBody(), ResponseOMDB.class);

            if (responseOMDB.response() == true) {

                TituloOMDB tituloOMDB = gson.fromJson(conexao.getBody(), TituloOMDB.class);
                System.out.println("Convertendo json em objeto: " + tituloOMDB);

                try {
                    Titulo titulo1 = new Titulo(tituloOMDB);
                    System.out.println("Titulo já convertido");
                    System.out.println(titulo1);
                    lista.add(titulo1);
                } catch (NumberFormatException e1) {
                    System.out.println("Ocorreu um erro ao retornar os dados");
                    System.out.println(e1.getMessage());
                    System.out.println(e1.getCause());
                } catch (DuracaoNuloException e2) {
                    System.out.println(e2.getMensagem());
                }

                FileWriter writer = new FileWriter("titulos.txt");
                writer.write(gson.toJson(lista));
                writer.close();

            } else {
                System.out.println("Titulo não encontrado");
            }
        }

        System.out.println("Filmes adicionados ao txt:" +lista);

    }
}
