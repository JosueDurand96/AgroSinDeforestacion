package agrosindeforestacion.com.agrosindeforestacion.Inicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import agrosindeforestacion.com.agrosindeforestacion.MapsActivity;

import agrosindeforestacion.com.agrosindeforestacion.Menu.MenuPrincipal;
import agrosindeforestacion.com.agrosindeforestacion.R;
import agrosindeforestacion.com.agrosindeforestacion.fragment.MapasFragment;
import agrosindeforestacion.com.agrosindeforestacion.model.nthc_persona;


public class SessionFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {

    EditText etUsuario;
    EditText etClave;

    Button btnSesion,btnRegistrar;

    RequestQueue rq;
    JsonRequest jrq;
    public static final String id="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_session, container, false);
        View vista = inflater.inflate(R.layout.fragment_session,container,false);

        etClave = (EditText)vista.findViewById(R.id.txtpass);
        etUsuario = (EditText)vista.findViewById(R.id.txtcorreo);

        btnSesion =(Button)vista.findViewById(R.id.btnIngresar);
        btnRegistrar=(Button)vista.findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar = new Intent(getContext(),Registrar.class);
                startActivity(entrar);
            }
        });
        rq = Volley.newRequestQueue(getContext());

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()==false){
                    Toast.makeText(getContext(), "Debe ingresar datos", Toast.LENGTH_SHORT).show();

                }else {
                    iniciarSesion();
                }
            }
        });


        return  vista;
    }


    private boolean validate() {

        boolean valid = true;

        if (etUsuario.getText().toString().isEmpty() || etUsuario.length() > 32) {
            etUsuario.setError("Ingrese su correo");
            valid = false;
        }
        if (etClave.getText().toString().isEmpty() || etClave.length() > 4) {
            etClave.setError("Ingrese su password");
            valid = false;

        }
        return valid;
    }

    public  static String Coool;
    public static String getMyVariablePict() {

        //Coool= etNombre.getText().toString();
        return Coool;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(getContext(), "No se encontró al Usuario", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        nthc_persona usuario = new nthc_persona();
        Toast.makeText(getContext(), "Bienvenido", Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;

        try {
            jsonObject =  jsonArray.getJSONObject(0);
            usuario.setId_nthc_persona(jsonObject.optString("id_nthc_persona"));
            usuario.setCorreo(jsonObject.optString("correo"));
            usuario.setPassword(jsonObject.optString("password"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent i = new Intent(getContext(),MapsActivity.class);
        //  i.putExtra(id,usuario.getId_nthc_persona() );
        startActivity(i);

    }
    private void iniciarSesion() {

        String url ="http://natu.vrammdev.com/login.php?correo="

                +etUsuario.getText().toString()+
                "&password=" +etClave.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);

    }

}
