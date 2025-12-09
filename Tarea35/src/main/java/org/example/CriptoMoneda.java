package org.example;

import com.google.gson.annotations.SerializedName;

public class CriptoMoneda {
    @SerializedName("id")
    private String id;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("name")
    private String name;

    @SerializedName("nameid")
    private String nameid;

    @SerializedName("rank")
    private int rank;

    @SerializedName("price_usd")
    private String priceUsd;

    @SerializedName("percent_change_24h")
    private String percentChange24h;

    @SerializedName("percent_change_1h")
    private String percentChange1h;

    @SerializedName("percent_change_7d")
    private String percentChange7d;

    @SerializedName("price_btc")
    private String priceBtc;

    @SerializedName("market_cap_usd")
    private String marketCapUsd;

    @SerializedName("volume24")
    private double volume24;

    @SerializedName("volume24a")
    private double volume24a;

    @SerializedName("csupply")
    private String csupply;

    @SerializedName("tsupply")
    private String tsupply;

    @SerializedName("msupply")
    private String msupply;

    // Constructor vacío requerido por Gson
    public CriptoMoneda() {}

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNameid() { return nameid; }
    public void setNameid(String nameid) { this.nameid = nameid; }

    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }

    public String getPriceUsd() { return priceUsd; }
    public void setPriceUsd(String priceUsd) { this.priceUsd = priceUsd; }

    public String getPercentChange24h() { return percentChange24h; }
    public void setPercentChange24h(String percentChange24h) { this.percentChange24h = percentChange24h; }

    public String getPercentChange1h() { return percentChange1h; }
    public void setPercentChange1h(String percentChange1h) { this.percentChange1h = percentChange1h; }

    public String getPercentChange7d() { return percentChange7d; }
    public void setPercentChange7d(String percentChange7d) { this.percentChange7d = percentChange7d; }

    public String getPriceBtc() { return priceBtc; }
    public void setPriceBtc(String priceBtc) { this.priceBtc = priceBtc; }

    public String getMarketCapUsd() { return marketCapUsd; }
    public void setMarketCapUsd(String marketCapUsd) { this.marketCapUsd = marketCapUsd; }

    public double getVolume24() { return volume24; }
    public void setVolume24(double volume24) { this.volume24 = volume24; }

    public double getVolume24a() { return volume24a; }
    public void setVolume24a(double volume24a) { this.volume24a = volume24a; }

    public String getCsupply() { return csupply; }
    public void setCsupply(String csupply) { this.csupply = csupply; }

    public String  getTsupply() { return tsupply; }
    public void setTsupply(String tsupply) { this.tsupply = tsupply; }

    public String getMsupply() { return msupply; }
    public void setMsupply(String msupply) { this.msupply = msupply; }
}
