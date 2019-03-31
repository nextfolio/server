package com.nextfolio.server.portfolio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Optional;

public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ArrayList<Stock> stocks;

    public Portfolio(){}

    public Portfolio(long id){
        this.stocks = new ArrayList<>();
        this.id = id;
    }

    public Portfolio(int size){
        stocks = new ArrayList<>(size);
    }

    public long getId(){
        return this.id;
    }

    public ArrayList<Stock> getPortfolio(){
        return stocks;
    }

    public Optional<Stock> getStock(String ticker){
        for (Stock stock: stocks){
            if (stock.getTicker().equals(ticker)){
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }

//    public Optional<Integer> getShares(Stock stock){
//        return Optional.ofNullable(stocks.getOrDefault(stock, null));
//    }

    /*Returns true if successfully added stock, false otherwise*/
//    public boolean addStock(Stock stock, int numShares){
//        if (stocks.containsKey(stock)){
//            stocks.put(stock, new Integer( stocks.get(stock) + numShares));
//            return true;
//        } else if (!stocks.containsKey(stock)) {
//            stocks.put(stock, new Integer(numShares));
//            return true;
//        } else {
//            return false;
//        }
//    }

    /*Returns true if successful removed number of shares. Removes stock if
    * shares hit 0*/
//    public boolean removeShares(Stock stock, int numShares){
//        if (stocks.isEmpty()){
//            return false;
//        }
//        else if (!stocks.containsKey(stock)){
//            return false;
//        } else {
//            stocks.replace(stock, new Integer( stocks.get(stock) - numShares));
//            if (stocks.get(stock).intValue() == 0){
//                this.removeStock(stock);
//            }
//            return true;
//        }
//    }

    public boolean removeStock(Stock stock){
        if (stocks.contains(stock)){
            stocks.remove(stock);
            return true;
        } else {return false;}
    }
}
