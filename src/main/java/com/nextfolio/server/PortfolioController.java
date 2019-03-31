package com.nextfolio.server;

import org.springframework.web.bind.annotation.*;

@RestController("portfolio")
public class PortfolioController {

    @RequestMapping(value="stock", method= RequestMethod.GET)
    public Stock makeStock(@RequestParam String ticker, int numShares){
        // sql database request
        return new Stock();
    }

    @RequestMapping(value="stock", method=RequestMethod.DELETE)
    public Stock removeStock(@RequestParam String ticker, int numShares){
        // sql database request
        return new Stock();
    }

    @RequestMapping(value="portfolio", method = RequestMethod.GET)
    public Portfolio makePortfolio(){
        // sql database stuff
        return new Portfolio();
    }
}
