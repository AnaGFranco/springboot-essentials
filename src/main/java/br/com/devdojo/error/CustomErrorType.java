package br.com.devdojo.error;

/**
 * @author Ana Gabriela
 * 
 * 
 * Class simples para apresentar mensagem de erro
 */
public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
