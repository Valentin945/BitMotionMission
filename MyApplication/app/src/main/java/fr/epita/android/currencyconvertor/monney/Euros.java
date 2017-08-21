package fr.epita.android.currencyconvertor.monney;

/**
 * Created by valentin on 8/21/17.
 */

public class Euros implements Monney {

    public Euros()
    {

    }

    @Override
    public double getMonneyEuros(double sum) {
        return sum;
    }

    @Override
    public double transmission(double sum) {
        return sum;
    }

}
