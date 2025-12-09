package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Monedas {
    @SerializedName("data")
    ArrayList<CriptoMoneda> monedas;
}
