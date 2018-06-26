package com.example.learn;

public enum HttpResponseCode {
    SUCCESS(200),
    FAILED(400);

    private final int responseCode;

    private HttpResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
