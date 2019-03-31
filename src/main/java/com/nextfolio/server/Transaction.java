package com.nextfolio.server;

public class Transaction {
    private float price;
    private int shares;

    public Transaction(float price, int shares){
        this.price = price;
        this.shares = shares;
    }

    public float getPrice(){
        return this.price;
    }

    public int shares(){
        return this.shares;
    }
}
