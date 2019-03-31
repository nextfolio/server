package com.nextfolio.server;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class AlphaVantageRequests {

    public static void test() throws java.io.IOException {

        //Testing JSON parsing code
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=demo";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("01. symbol");
        System.out.println(name);

        //Testing JSON parsing code END
        System.out.println("Hello World");
    }

}
