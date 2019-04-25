package agrosindeforestacion.com.agrosindeforestacion.Menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import agrosindeforestacion.com.agrosindeforestacion.Inicio.MainActivity;
import agrosindeforestacion.com.agrosindeforestacion.R;

public class MenuPrincipal extends AppCompatActivity {
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    private boolean doubleBackToExitPressedOnce;
    private Handler mHandler = new Handler();

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (mHandler != null) { mHandler.removeCallbacks(mRunnable); }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la App?");
            builder.setTitle("Alerta!");
            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cerrandoSesion();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Por favor presione dos veces regresar para salir", Toast.LENGTH_SHORT).show();

        mHandler.postDelayed(mRunnable, 2000);
    }
//    @Override
//    public void onBackPressed() {
//      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("¿Desea salir de la App?");
//        builder.setTitle("Alerta!");
//        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                cerrandoSesion();
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//    }

    public void cerrandoSesion(){
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        logout();
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MenuPrincipal.this,MainActivity.class));
    }
}
