package com.example.Task.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private String sourceCurrency;
    private String sourceValue;
    private String targetCurrency;
    private String targetValue;

    @JsonCreator
    public Response(@JsonProperty("sourceCurrency") String sourceCurrency,
                    @JsonProperty("sourceValue") String sourceValue,
                    @JsonProperty("targetCurrency") String targetCurrency,
                    @JsonProperty("targetValue") String targetValue) {

        this.sourceCurrency = sourceCurrency;
        this.sourceValue = sourceValue;
        this.targetCurrency = targetCurrency;
        this.targetValue = targetValue;
    }
}
