package agrosindeforestacion.com.agrosindeforestacion.Inicio;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import agrosindeforestacion.com.agrosindeforestacion.R;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario, new SessionFragment()).commit();

    }


}
