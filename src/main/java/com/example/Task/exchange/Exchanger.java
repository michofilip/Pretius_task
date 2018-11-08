package com.example.Task.exchange;

import com.example.Task.nbp.NbpConnector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class Exchanger {
    private Map<String, BigDecimal> currencyRates;
    private NbpConnector nbpConnector;

    public Exchanger(NbpConnector nbpConnector) {
        this.nbpConnector = nbpConnector;
        this.currencyRates = nbpConnector.getCurrencyRates();
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void updateCurrencyRates() {
        this.currencyRates = nbpConnector.getCurrencyRates();
    }

    public BigDecimal exchange(BigDecimal value, String sourceCurr, String targetCurr) throws NoSuchCurrencyException {
        if (currencyRates.containsKey(sourceCurr)
                && currencyRates.containsKey(targetCurr)) {
            BigDecimal sourceRate = currencyRates.get(sourceCurr);
            BigDecimal targetRate = currencyRates.get(targetCurr);
            BigDecimal result = value.multiply(sourceRate).divide(targetRate, RoundingMode.HALF_UP);

            return result;
        } else {
            throw new NoSuchCurrencyException();
        }
    }
}
