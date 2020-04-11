package src.main.java.rates.services;

import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.rates.ExchangeRatesAdapter;
import src.main.java.rates.model.ExchangeRatesResponse;


public class ExchangeRatesServiceImpl implements ExchangeRatesService{

    private ExchangeRatesAdapter exchangeRatesAdapter;

    @Autowired
    public ExchangeRatesServiceImpl(ExchangeRatesAdapter exchangeRatesAdapter) {
        this.exchangeRatesAdapter = exchangeRatesAdapter;
    }

    public Single<ExchangeRatesResponse> getExchangeRates(final String base){
        return exchangeRatesAdapter.getExchangeRates(base);
    }
}
