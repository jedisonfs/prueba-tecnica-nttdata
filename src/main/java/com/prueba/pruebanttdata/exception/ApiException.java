package com.prueba.pruebanttdata.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Objects;

public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDate localDate;


    public ApiException(String message, HttpStatus httpStatus, LocalDate localDate) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.localDate = localDate;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiException that = (ApiException) o;
        return Objects.equals(message, that.message) && httpStatus == that.httpStatus && Objects.equals(localDate, that.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, httpStatus, localDate);
    }
}
