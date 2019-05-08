package agrosindeforestacion.com.agrosindeforestacion.Inicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import agrosindeforestacion.com.agrosindeforestacion.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class Registrar extends AppCompatActivity {
    ImageView imageView9;
    Button btnRegistrar;
    EditText txtnombresUsuario,txtcorreoUsuario,txtdniUsuario,txtpassUsuario,txtapellidoPaterno,txtapellidoMaterno,txtPredioUusario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        txtnombresUsuario =(EditText)findViewById(R.id.txtnombresUsuario);
        txtcorreoUsuario =(EditText)findViewById(R.id.txtcorreoUsuario);
        txtdniUsuario=(EditText)findViewById(R.id.txtdniUsuario);
        txtpassUsuario=(EditText)findViewById(R.id.txtpassUsuario);
        txtapellidoPaterno=(EditText)findViewById(R.id.txtapellidoPaterno);
        txtapellidoMaterno=(EditText)findViewById(R.id.txtapellidoMaterno);
        txtPredioUusario=(EditText)findViewById(R.id.txtPredioUsuario);
        imageView9=(ImageView)findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnRegistrar =(Button)findViewById(R.id.btnRegistrar3);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( validate()==false) {
                    Toast.makeText(Registrar.this, "Debe ingresar datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    Thread tr2 = new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            RegistrarUsuarioPost(
                                    txtnombresUsuario.getText().toString(),
                                    txtcorreoUsuario.getText().toString(),
                                    txtdniUsuario.getText().toString(),
                                    txtpassUsuario.getText().toString(),
                                    txtapellidoPaterno.getText().toString(),
                                    txtapellidoMaterno.getText().toString(),
                                    txtPredioUusario.getText().toString()
                            );
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "USTED SE HA REGISTRADO", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(i);
                                }
                            });
                        }
                    };
                    tr2.start();
                }
            }
        });

    }

    public void RegistrarUsuarioPost(String nombres,String correo,String dni, String password, String apellido_paterno, String apellido_materno, String predio){

        String urlParameters="&correo="+correo+"&dni="+dni+"&password="+password+"&apellido_paterno="+apellido_paterno+"&apellido_materno="+apellido_materno+"&predio="+predio;
        HttpURLConnection conection=null;
        try {

            URL url = new URL("http://natu.vrammdev.com/registrarUsuario.php?"+"&nombres="+nombres);
            conection = (HttpURLConnection) url.openConnection();

            //estableciendo el metodo
            conection.setRequestMethod("POST");
            //longitud de datos que se envian
            conection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

            //comando para la salida de datos
            conection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            InputStream is = conection.getInputStream();
        } catch (Exception ex){ }
    }



    private boolean validate() {

        boolean valid=true;
        if (txtnombresUsuario.getText().toString().isEmpty()|| txtnombresUsuario.length()>32){
            txtnombresUsuario.setError("Debe ingresar su Nombres");
            valid =false;
        } if (txtapellidoPaterno.getText().toString().isEmpty()|| txtapellidoPaterno.length()>32) {
            txtapellidoPaterno.setError("Debe ingresar su Apellido Paterno");
            valid = false;
        }if (txtapellidoMaterno.getText().toString().isEmpty()|| txtapellidoMaterno.length()>32)
        {
            txtapellidoMaterno.setError("Debe ingresar su Apellido Materno");
            valid = false;
        }if (txtcorreoUsuario.getText().toString().isEmpty()|| txtcorreoUsuario.length()>40) {
            txtcorreoUsuario.setError("Debe ingresar su Correo");
            valid = false;

        }if (txtdniUsuario.getText().toString().isEmpty()|| txtdniUsuario.length()>40) {
            txtdniUsuario.setError("Debe ingresar su Dni");
            valid = false;

        }if (txtpassUsuario.getText().toString().isEmpty()|| txtpassUsuario.length()>40) {
            txtpassUsuario.setError("Debe ingresar su Contraseña");
            valid = false;

        }if (txtPredioUusario.getText().toString().isEmpty()|| txtPredioUusario.length()>40) {
            txtPredioUusario.setError("Debe ingresar Predio");
            valid = false;

        }
        return valid;

    }
}
