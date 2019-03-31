package com.nextfolio.server.portfolio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Optional;

public class Portfolio {
    private HashMap<Stock, Integer> stocks = new HashMap();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Portfolio(){}

    public Portfolio(long id){
        this.id = id;
    }

    public Portfolio(int size){
        stocks = new HashMap<>(size);
    }

    public long getId(){
        return this.id;
    }

    public HashMap<Stock, Integer> getPortfolio(){
        return stocks;
    }

    public Optional<Stock> getStock(String ticker){
        for (Stock stock: stocks.keySet()){
            if (stock.getTicker().equals(ticker)){
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }

    public Optional<Integer> getShares(Stock stock){
        return Optional.ofNullable(stocks.getOrDefault(stock, null));
    }

    /*Returns true if successfully added stock, false otherwise*/
    public boolean addStock(Stock stock, int numShares){
        if (stocks.containsKey(stock)){
            stocks.put(stock, new Integer( stocks.get(stock) + numShares));
            return true;
        } else if (!stocks.containsKey(stock)) {
            stocks.put(stock, new Integer(numShares));
            return true;
        } else {
            return false;
        }
    }

    /*Returns true if successful removed number of shares. Removes stock if
    * shares hit 0*/
    public boolean removeShares(Stock stock, int numShares){
        if (stocks.isEmpty()){
            return false;
        }
        else if (!stocks.containsKey(stock)){
            return false;
        } else {
            stocks.replace(stock, new Integer( stocks.get(stock) - numShares));
            if (stocks.get(stock).intValue() == 0){
                this.removeStock(stock);
            }
            return true;
        }
    }

    public boolean removeStock(Stock stock){
        stocks.remove(stock);
        if (stocks.containsKey(stock)){
            return false;
        } else {return true;}
    }
}
