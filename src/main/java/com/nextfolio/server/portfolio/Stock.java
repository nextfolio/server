package com.nextfolio.server.portfolio;

public class Stock {


    private String ticker;
    private double price;

    private int volume[];

    private int marketCap;

    private int yearHigh;
    private int yearLow;


    public Stock(){}
    public Stock(String ticker, float price){
        this.ticker = ticker;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Stock) {
            Stock stock = (Stock) obj;
            return this.getTicker().equals(stock.getTicker())
                && this.getPrice() == stock.getPrice();
        }

        return false;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice(){
        return price;
    }

    public int getVolume(int periodInDays){
        if(periodInDays == 1)
            return volume[0];
        else if(periodInDays == 7)
            return volume[1];
        else if(periodInDays == 30)
            return volume[2];
        else
            return 0;
    }

    public int getMarketCap(){
        return marketCap;
    }

    public int getYearHigh(){
        return yearHigh;
    }

    public int getYearLow(){
        return yearLow;
    }



}
