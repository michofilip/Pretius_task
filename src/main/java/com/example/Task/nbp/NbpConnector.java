package com.example.Task.nbp;

import com.example.Task.nbp.model.ExchangeRatesTable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class NbpConnector {
//    public Map<String, BigDecimal> getCurrencyRates() {
//        final RestTemplate restTemplate = new RestTemplate();
//        final RequestEntity<Void> tableA = RequestEntity.get(URI.create("http://api.nbp.pl/api/exchangerates/tables/A"))
//                .accept(MediaType.APPLICATION_JSON)
//                .build();
//        final RequestEntity<Void> tableB = RequestEntity.get(URI.create("http://api.nbp.pl/api/exchangerates/tables/B"))
//                .accept(MediaType.APPLICATION_JSON)
//                .build();
//
//        final ResponseEntity<? extends Collection<ExchangeRatesTable>> responseA = restTemplate.exchange(tableA, new ParameterizedTypeReference<Collection<ExchangeRatesTable>>() {
//        });
//        final ResponseEntity<? extends Collection<ExchangeRatesTable>> responseB = restTemplate.exchange(tableB, new ParameterizedTypeReference<Collection<ExchangeRatesTable>>() {
//        });
//
//        final Collection<Rate> listA = responseA.getBody().stream().findAny().get().getRates();
//        final Collection<Rate> listB = responseB.getBody().stream().findAny().get().getRates();
//
//        Map<String, BigDecimal> currencyRates = new HashMap<>();
//
//        listA.forEach(rate -> currencyRates.put(rate.getCode(), new BigDecimal(rate.getMid())));
//        listB.forEach(rate -> currencyRates.put(rate.getCode(), new BigDecimal(rate.getMid())));
//        currencyRates.put("PLN", BigDecimal.valueOf(1));
//
//        return currencyRates;
//
//    }

    public Map<String, BigDecimal> getCurrencyRates() {
        String tableAurl = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
        String tableBurl = "http://api.nbp.pl/api/exchangerates/tables/B?format=json";

        RestTemplate restTemplate = new RestTemplate();

        ExchangeRatesTable[] exchangeRatesTablesA = restTemplate.getForObject(tableAurl, ExchangeRatesTable[].class);
        ExchangeRatesTable[] exchangeRatesTablesB = restTemplate.getForObject(tableBurl, ExchangeRatesTable[].class);

        Map<String, BigDecimal> currencyRates = new HashMap<>();
        Arrays.asList(exchangeRatesTablesA[0].getRates()).forEach(rate -> currencyRates.put(rate.getCode(), new BigDecimal(rate.getMid())));
        Arrays.asList(exchangeRatesTablesB[0].getRates()).forEach(rate -> currencyRates.put(rate.getCode(), new BigDecimal(rate.getMid())));
        currencyRates.put("PLN", BigDecimal.valueOf(1));

        return currencyRates;
    }

}
