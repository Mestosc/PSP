package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Monedas {
    @SerializedName("data")
    List<CriptoMoneda> monedas;
}
