package src.main.java.rates;

import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import src.main.java.rates.model.ExchangeRatesResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRatesAdapter {

    private static final EXCHANGE_RATE_BASE_END_POINT="http://api.fixer.io/latest?base=%s";

    public Single<ExchangeRatesResponse> getExchangeRates(String base) {

        return Single.create(new SingleOnSubscribe<ExchangeRatesResponse>() {

            @Override
            public void subscribe(SingleEmitter<ExchangeRatesResponse> subscriber) throws Exception {
                try {
                    String endPoint = String.format(EXCHANGE_RATE_BASE_END_POINT, base);
                    URL obj = new URL(endPoint);

                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    ExchangeRatesResponse response = readRatesFromResponse(in);
                    subscriber.onSuccess();
                } catch (Exception e) {
                    throw new Exception();
                }
            }
        })
    }

    private ExchangeRatesResponse readRatesFromResponse(BufferedReader in) throws Exception{
        String inputLine;
        StringBuffer response = new StringBuffer();

        try {
            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            String responseString = response.toString();
            Gson gson = new Gson();
            return gson.fromJson(responseString, ExchangeRatesResponse.class);
        } catch {
            throw new Exception();
        } finally {
            in.close();
        }
    }
}
