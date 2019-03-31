package com.nextfolio.server;

import org.springframework.web.bind.annotation.*;

@RestController("portfolio")
public class PortfolioController {

    /* Stock Requests */
    @RequestMapping(value="stock", method= RequestMethod.GET)
    public Stock makeStock(@RequestParam String ticker, int numShares){
        // sql database request
        return new Stock();
    }


    @RequestMapping(value="stock/volume", method=RequestMethod.GET)
    public int getVolume(@RequestParam int periodInDays){
        return 0;
    }

    @RequestMapping(value="stock", method=RequestMethod.DELETE)
    public Stock removeStock(@RequestParam String ticker, int numShares){
        // sql database request
        return null;
    }

    @RequestMapping(value="stock", method=RequestMethod.GET)
    public int marketCap(@RequestParam String ticker){
        // sql database request
        return 0;
    }


    /* Portfolio Requests */
    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public Portfolio addStock(@PathVariable("id") long id,
                                   @RequestParam String ticker,
                                   @RequestParam int numShares,
                                   @RequestParam float price){
        // sql database stuff
        Stock stock = new Stock(ticker, price);
        Portfolio portfolio = new Portfolio(id); // get a portfolio from sql
        portfolio.addStock(stock, numShares);
        return portfolio;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public boolean addShares(@PathVariable("id") long id,
                             @RequestParam Stock stock,
                             @RequestParam int numShares){
        //sql get portfolio from id
        Portfolio portfolio = new Portfolio(id);
        portfolio.addStock(stock, numShares);
        return true;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Portfolio removeShares(@PathVariable("id") long id,
                                  @RequestParam String ticker,
                                  @RequestParam int numShares){

        // sql stuff
        Portfolio portfolio = new Portfolio(id); // get a portfolio from sql
        portfolio.getStock(ticker).ifPresent(stock -> portfolio.removeShares(stock, numShares));
        return portfolio;
    }

    @RequestMapping(value="portfolio", method = RequestMethod.POST)
    public Portfolio makePortfolio(){
        // sql stuff, get id
        long id = 0;
        return new Portfolio(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean deletePortfolio(@PathVariable("id") long id){
        // sql stuff, get portfolio from id
        return false; // return boolean whether successfully removed or not
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Stock getStock(@PathVariable("id") long id,
                          @RequestParam String ticker){
        // sql stuff, get portfolio using id
        Portfolio portfolio = new Portfolio(id);
        return portfolio.getStock(ticker).get();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Portfolio getPortfolio(@PathVariable("id") long id){
        // sql stuff, get portfolio using id then return that portfolio
        Portfolio portfolio = new Portfolio(id);
        return portfolio;
    }

    @RequestMapping(value="portfolio", method = RequestMethod.GET)
    public int getShares(@RequestParam Portfolio portfolio, Stock stock){
        // sql stuff
        return portfolio.getShares(stock).get();
    }


}
