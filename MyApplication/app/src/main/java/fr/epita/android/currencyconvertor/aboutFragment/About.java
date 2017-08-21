package fr.epita.android.currencyconvertor.aboutFragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import fr.epita.android.currencyconvertor.R;

/**
 * Created by valentin on 8/21/17.
 */

public class About extends Fragment implements View.OnClickListener {

    public About()
    {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.about, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.linkedinLogo);
        button.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.linkedinLogo:
                String url = "https://www.linkedin.com/in/valentin-lambert/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
