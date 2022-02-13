package com.adonai.simplehouse.excepitions;

import java.time.LocalDate;
import java.util.Date;

public class ExceptionResponse {

    private Date timestamp;
    private String mensaje;
    private String detalles;
    private String httpCodeMessage;

    public ExceptionResponse(String message, String details,String httpCodeMessage) {
        super();
        this.timestamp = new Date();
        this.mensaje = message;
        this.detalles = details;
        this.httpCodeMessage=httpCodeMessage;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDetalles() {
        return detalles;
    }
}
