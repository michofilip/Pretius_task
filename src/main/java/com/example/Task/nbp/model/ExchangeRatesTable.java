package com.example.Task.nbp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesTable {
    private String table;
    private String no;
    private String effectiveDate;
    private Rate[] rates;
}
