package agrosindeforestacion.com.agrosindeforestacion.Menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import agrosindeforestacion.com.agrosindeforestacion.Inicio.MainActivity;
import agrosindeforestacion.com.agrosindeforestacion.R;
import agrosindeforestacion.com.agrosindeforestacion.fragment.MapasFragment;
import agrosindeforestacion.com.agrosindeforestacion.fragment.HomeFragment;
import agrosindeforestacion.com.agrosindeforestacion.fragment.SincronizarFragment;

import android.support.v7.widget.Toolbar;
public class MenuPrincipal extends AppCompatActivity {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        changeFragment(new MapasFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        changeFragment(new MapasFragment());
                        break;
                    case R.id.menu_settings:
                        changeFragment(new HomeFragment());
                        break;
                    default:
                        changeFragment(new SincronizarFragment());
                }
                return true;
            }
        });
    }



    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentFragment, fragment)
                .commit();
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
    protected void onDestroy() {
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
