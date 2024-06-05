package com.dev.models;

import com.google.gson.Gson;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryApi {
    public Consulta getConsulta() {
        URI direccionUrl = URI.create("https://v6.exchangerate-api.com/v6/235c1dd61702b15b727f01bd/latest/USD");

    }
}