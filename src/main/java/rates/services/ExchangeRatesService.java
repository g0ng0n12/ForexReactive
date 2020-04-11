package src.main.java.rates.services;

import io.reactivex.Single;
import src.main.java.rates.model.ExchangeRatesResponse;

public interface ExchangeRatesService {

    Single<ExchangeRatesResponse> getExchangeRates(String base);
}
