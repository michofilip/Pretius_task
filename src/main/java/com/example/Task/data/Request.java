package com.example.Task.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private String value;
    private String currency;
    private String targetCurrency;

    @JsonCreator
    public Request(@JsonProperty("value") String value,
                   @JsonProperty("currency") String currency,
                   @JsonProperty("targetCurrency") String targetCurrency) {
        this.value = value;
        this.currency = currency;
        this.targetCurrency = targetCurrency;
    }
}
