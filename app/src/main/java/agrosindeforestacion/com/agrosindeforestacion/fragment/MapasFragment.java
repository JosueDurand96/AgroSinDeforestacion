package agrosindeforestacion.com.agrosindeforestacion.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;

import agrosindeforestacion.com.agrosindeforestacion.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapasFragment extends Fragment {


    public MapasFragment() {
        // Required empty public constructor
    }
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

}