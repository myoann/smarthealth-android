package website.watchmyhealth.watchmyhealth.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import website.watchmyhealth.watchmyhealth.R;
import website.watchmyhealth.watchmyhealth.activity.ProfilModif;

/**
 * Created by Yoann on 26/04/2015.
 */

public class FragmentProfil extends Fragment {

    private TextView tvEmail;
    private TextView tvDateNaissance;
    private TextView tvTaille;
    private TextView tvPoids;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvEmail = (TextView)view.findViewById(R.id.tvEmail);
        tvDateNaissance = (TextView)view.findViewById(R.id.tvDateNaissance);
        tvTaille =(TextView)view.findViewById(R.id.tvTaille);
        tvPoids=(TextView)view.findViewById(R.id.tvPoids);
        Intent intentFromProfilModif = getActivity().getIntent();
        if( intentFromProfilModif.getExtras() !=null) {

            tvEmail.setText(intentFromProfilModif.getStringExtra("EXTRA_USER_MODIF_EMAIL"));
            tvDateNaissance.setText(intentFromProfilModif.getStringExtra("EXTRA_USER_MODIF_DATE_NAISSANCE"));
            tvTaille.setText(intentFromProfilModif.getStringExtra("EXTRA_USER_MODIF_TAILLE"));
            tvPoids.setText(intentFromProfilModif.getStringExtra("EXTRA_USER_MODIF_POIDS"));
        }

            return view;
    }



}