package fr.epita.android.currencyconvertor.monney;

/**
 * Created by valentin on 8/21/17.
 */

public class CanadianDollar implements Monney {

    public CanadianDollar()
    {
    }

    @Override
    public double getMonneyEuros(double sum) {
        return sum * 1.47978;
    }

    @Override
    public double transmission(double sum) {
        return sum * 0.675687;
    }
}
