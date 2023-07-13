package Modelos;

public record TituloOMDB(String title, String year, String runtime, boolean response) {

    public TituloOMDB(String title, String year, String runtime, boolean response) {
        this.title = title;
        this.year = year.replaceAll("[^0-9]", "");
        this.runtime = runtime.replaceAll("[^0-9]", "");
        this.response = response;
    }
}
