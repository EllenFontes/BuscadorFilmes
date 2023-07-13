package Excecao;

public class DuracaoNuloException extends RuntimeException {

    private String mensagem;
    public DuracaoNuloException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }

}
