package fr.epita.android.currencyconvertor.monney;

/**
 * Created by valentin on 8/21/17.
 */

public class Dollar implements Monney {

    public Dollar()
    {

    }

    @Override
    public double getMonneyEuros(double sum) {
        return sum * 0.850388;
    }

    @Override
    public double transmission(double sum) {
        return sum * 1.175888;
    }
}
