package com.prueba.pruebanttdata.exception;

public class ClientNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8076459214445318542L;

    public static final String message = "Client not found";

    public ClientNotFoundException() {
        super(message);
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
