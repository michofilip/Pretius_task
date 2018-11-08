package com.example.Task.index;

import com.example.Task.data.Request;
import com.example.Task.data.Response;
import com.example.Task.exchange.Exchanger;
import com.example.Task.exchange.NoSuchCurrencyException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class ExchangeController {

    private Exchanger exchanger;

    @PostMapping("/exchange")
    public Response exchange(@RequestBody Request request) {
        Response response;
        if (request.getCurrency() != null
                && request.getTargetCurrency() != null
                && request.getValue() != null) {

            final String currency = request.getCurrency().toUpperCase();
            final String targetCurrency = request.getTargetCurrency().toUpperCase();
            try {
                final BigDecimal value = new BigDecimal(request.getValue());

                BigDecimal targetValue = null;

                try {
                    targetValue = exchanger.exchange(value, currency, targetCurrency);
                    response = new Response(currency, request.getValue(), targetCurrency, targetValue.toString());
                } catch (NoSuchCurrencyException e) {
                    response = new Response("", "", "", "");
                }
            } catch (NumberFormatException e) {
                response = new Response("", "", "", "");
            }
        } else {
            System.out.println("Wrong format");
            response = new Response("", "", "", "");
        }

        return response;
    }
}
