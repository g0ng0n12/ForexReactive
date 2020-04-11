package src.main.java.exceptions;

public class CurrencyNotFoundException extends Exception{

    public CurrencyNotFoundException() {
        super("Currency Not Supported");
    }
}
