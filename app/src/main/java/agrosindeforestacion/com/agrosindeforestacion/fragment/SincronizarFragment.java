package agrosindeforestacion.com.agrosindeforestacion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agrosindeforestacion.com.agrosindeforestacion.R;

public class SincronizarFragment extends Fragment {



    public SincronizarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sincronizar, container, false);
        return view;
    }



}
