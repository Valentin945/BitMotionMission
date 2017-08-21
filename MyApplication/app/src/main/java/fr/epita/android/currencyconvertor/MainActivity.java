package fr.epita.android.currencyconvertor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import fr.epita.android.currencyconvertor.aboutFragment.About;
import fr.epita.android.currencyconvertor.convertorFragment.ConvertorFragment;
import fr.epita.android.currencyconvertor.spinner.spinnerAdapter;

public class MainActivity extends AppCompatActivity {

    Fragment lastFragment = null;

    /// The current fragment use
    Fragment actualFragment = null;

    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        actualFragment = new ConvertorFragment();
        fragmentTransaction.replace(R.id.main_container, actualFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_settings:
                if (actualFragment instanceof About) {
                    break;
                } else {
                    final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment actual = new About();
                    frag_switch(actual);
                    fragmentTransaction.replace(R.id.main_container, actual);
                    fragmentTransaction.commit();
                }
                break;
            case  R.id.reverse_settings:
                if (lastFragment != null)
                {
                    final FragmentTransaction fragmentTransac = fragmentManager.beginTransaction();
                    frag_switch(lastFragment);
                    fragmentTransac.replace(R.id.main_container, actualFragment);
                    fragmentTransac.commit();

                }
        }
        return true;
    }

    private void frag_switch(Fragment actual) {
        lastFragment = actualFragment;
        actualFragment = actual;
    }
}
