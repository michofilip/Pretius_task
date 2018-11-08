package com.example.Task.nbp;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ExchangeRatesTable {

    private String table;
    private String no;
    private String effectiveDate;
    private Collection<Rate> rates;
}
