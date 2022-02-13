package com.adonai.simplehouse.excepitions;

public class BeanError extends RuntimeException {
    public BeanError(String message) {
        super(message);
    }
}
