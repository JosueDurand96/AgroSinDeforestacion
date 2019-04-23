
package agrosindeforestacion.com.agrosindeforestacion;

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


public class SessionFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {

    EditText etUsuario;
    EditText etClave;
    static EditText etNombre;
    Button btnSesion,btnRegistrar;

    RequestQueue rq;
    JsonRequest jrq;
    public static final String id="id";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_session, container, false);
        View vista = inflater.inflate(R.layout.fragment_session,container,false);
        etUsuario = (EditText)vista.findViewById(R.id.txtcelular1);
        etClave = (EditText)vista.findViewById(R.id.txtpass1);


        btnSesion =(Button)vista.findViewById(R.id.btnIngresar);
        btnRegistrar=(Button)vista.findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent entrar = new Intent(getContext(),Registrar.class);
              //  startActivity(entrar);
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
        if (etNombre.getText().toString().isEmpty() || etNombre.length() > 32) {
            etNombre.setError("Ingrese la empresa");
            valid = false;
        }
        if (etUsuario.getText().toString().isEmpty() || etUsuario.length() > 32) {
            etUsuario.setError("Ingrese su celular");
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

        Coool= etNombre.getText().toString();
        return Coool;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se encontró al Usuario", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
       // Cliente cliente = new Cliente();
        Toast.makeText(getContext(), "Bienvenido", Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;

        try {
            jsonObject =  jsonArray.getJSONObject(0);
//            cliente.setIdcliente(jsonObject.optString("idcliente"));
//            cliente.setCelular(jsonObject.optString("celular"));
//            cliente.setPassword(jsonObject.optString("password"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        Intent i = new Intent(getContext(),MenuPrincipal.class);
//        i.putExtra(id,cliente.getIdcliente() );
//        startActivity(i);

    }
    private void iniciarSesion() {
        String url ="http://www.capacitasoft.com/site/Cliente/login3.php?nombre="+etNombre.getText().toString()+
                "&celular="+etUsuario.getText().toString()+
                "&password="+etClave.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);

    }

}
