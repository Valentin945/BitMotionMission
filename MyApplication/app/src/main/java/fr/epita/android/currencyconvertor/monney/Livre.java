package fr.epita.android.currencyconvertor.monney;

/**
 * Created by valentin on 8/21/17.
 */

public class Livre implements Monney {
    public Livre()
    {

    }

    @Override
    public double getMonneyEuros(double sum) {
        return 1.09460 * sum;
    }

    @Override
    public double transmission(double sum) {
        return 0.913576 * sum;
    }
}
