package com.example.controlrevisiontecnica;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.controlrevisiontecnica.databinding.Activity2Binding;
import com.example.controlrevisiontecnica.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class Activity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout myDrawer;
    NavigationView mynav;
    Toolbar myToolbar;

    ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        myDrawer = findViewById(R.id.myDrawer);
        mynav= findViewById(R.id.myNavigationView);
        myToolbar = findViewById(R.id.myToolbar);


        setSupportActionBar(myToolbar);

        mynav.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myFrame,new FragmentoRegistro())
                .commit();
        setTitle("REGISTRO");

        toogle =new ActionBarDrawerToggle(this,myDrawer,myToolbar,R.string.drawer_open,R.string.drawer_close);


        toogle =setDrawerToogle();
        myDrawer.addDrawerListener(toogle);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }

    private ActionBarDrawerToggle setDrawerToogle() {
        return new ActionBarDrawerToggle(this, myDrawer, myToolbar,R.string.drawer_open,R.string.drawer_close);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (item.getItemId()){
            case R.id.itemRegistro:
                ft.replace(R.id.myFrame, new FragmentoRegistro()).commit();
                Toast.makeText(Activity2.this, "Selecionó Registro", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemBusqueda:
                ft.replace(R.id.myFrame, new FragmentoBusqueda()).commit();
                Toast.makeText(Activity2.this, "Selecionó Busqueda", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemModificacion:
                ft.replace(R.id.myFrame, new FragmentoModificar()).commit();
                Toast.makeText(Activity2.this, "Selecionó Modificar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemEliminacion:
                ft.replace(R.id.myFrame, new FragmentoEliminar()).commit();
                Toast.makeText(Activity2.this, "Selecionó Eliminar", Toast.LENGTH_SHORT).show();
                break;
        }
        setTitle(item.getTitle());
        myDrawer.closeDrawers();
        return true;
    }
}