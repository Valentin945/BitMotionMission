package fr.epita.android.currencyconvertor.convertorFragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import fr.epita.android.currencyconvertor.R;
import fr.epita.android.currencyconvertor.monney.CanadianDollar;
import fr.epita.android.currencyconvertor.monney.Dollar;
import fr.epita.android.currencyconvertor.monney.Euros;
import fr.epita.android.currencyconvertor.monney.Livre;
import fr.epita.android.currencyconvertor.monney.Monney;
import fr.epita.android.currencyconvertor.spinner.spinnerAdapter;

import static java.lang.System.exit;

/**
 * Created by valentin on 8/21/17.
 */

public class ConvertorFragment extends Fragment implements View.OnClickListener{

    String in = "Euros";
    String out = "Euros";
    EditText editText;
    String[] monney = {"Euros", "Dollars", "Canadian Dollars", "Livre"};
    String[] img_monney = {"€", "$", "$", "£"};
    Context context;
    TextView result;
    TextView lastDate;

    public ConvertorFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        context = getContext();
        final View view = inflater.inflate(R.layout.convertor, container, false);

        result = (TextView)  view.findViewById(R.id.result);
        lastDate = (TextView) view.findViewById(R.id.lastDate);
        spinnerAdapter adapter = new spinnerAdapter(getContext(), monney, img_monney);
        Spinner entrySpinner = (Spinner) view.findViewById(R.id.inspinner);
        entrySpinner.setAdapter(adapter);
        entrySpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                                                    @Override
                                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       in = monney[position];
                                                    }

                                                    @Override
                                                    public void onNothingSelected(AdapterView<?> parent) {

                                                    }
                                                }
        );


        spinnerAdapter adapterEnd = new spinnerAdapter(getContext(), monney, img_monney);
        Spinner endSpinner = (Spinner) view.findViewById(R.id.outspinner);
        endSpinner.setAdapter(adapterEnd);
        endSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                out = monney[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        Button validButton = (Button) view.findViewById(R.id.buttonValide);
        validButton.setOnClickListener(this);


        editText = (EditText) view.findViewById(R.id.valToEnter);

        return view;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.buttonValide:
                update();
                break;
            default:
                break;
        }
    }


    private void update()
    {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        lastDate.setText(currentDateTimeString);
        lastDate.setTextColor(Color.BLUE);
        lastDate.setTextSize(10);
        lastDate.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        if (in == "")
        {
            Toast.makeText(context, "Please enter an Entry currency", Toast.LENGTH_LONG);
        }
        else if (out == "")
        {
            Toast.makeText(context, "Please enter an End currency", Toast.LENGTH_LONG);
        }
        else if (editText.getText() == null)
        {
            Toast.makeText(context, "Please enter an amount of monney", Toast.LENGTH_LONG);
        }

        Double val = 0.0;
        try
        {
            val = Double.valueOf(editText.getText().toString());
        }
        catch (Exception exception)
        {
            Toast.makeText(context, "Please put numeric value", Toast.LENGTH_LONG);
            return;
        }

        val = transform(val);
        result.setText(String.format("%.2f", val));
        Toast.makeText(context, val.toString() , Toast.LENGTH_LONG);

    }

    private double transform(double val)
    {
        Monney monnai = getKindMonney(in);
        val = monnai.getMonneyEuros(val);
        monnai = getKindMonney(out);
        val = monnai.transmission(val);
        return val;
    }

    Monney getKindMonney(String s)
    {
        if (s == "Euros")
        {
            return new Euros();
        }
        else if (s == "Dollars")
        {
            return new Dollar();
        }
        else if (s == "Canadian Dollars")
        {
            return new CanadianDollar();
        }
        else
        {
            return new Livre();
        }
    }

}
