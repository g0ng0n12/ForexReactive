package src.main.java.rates.responses;

import java.math.BigDecimal;

public class RatesResponse {

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    private BigDecimal rate;

    public RatesResponse() {
    }

    public RatesResponse(BigDecimal rate){
        this.rate = rate;
    }


}
