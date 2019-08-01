package br.com.juaanhs.atmconsultoria.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import br.com.juaanhs.atmconsultoria.R;
import br.com.juaanhs.atmconsultoria.ui.fragment.ClientesFragment;
import br.com.juaanhs.atmconsultoria.ui.fragment.PrincipalFragment;
import br.com.juaanhs.atmconsultoria.ui.fragment.ServicosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ATMCONSULTORIA_EMAIL = "atmconsultoria@gmail.com";
    public static final String ASSUNTO_EMAIL = "Contato pelo App ATM Consultoria";
    public static final String MENSAGEM_EMAIL = "Mensagem automática";
    public static final String KEY_EMAIL = "menssage/rfc822";
    public static final String TITULO_ESCOLHA_O_APP = "Escolha o app de email:";
    private PrincipalFragment principalFragment;
    private ClientesFragment clientesFragment;
    private ServicosFragment servicosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        instanciaFragments();

        criaFragment(principalFragment);
        FAB();
        configuraNavigationDrawer(toolbar);
    }

    private void configuraNavigationDrawer(Toolbar toolbar) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void FAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
    }

    public void enviarEmail() {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ATMCONSULTORIA_EMAIL});
        email.putExtra(Intent.EXTRA_SUBJECT, ASSUNTO_EMAIL);
        email.putExtra(Intent.EXTRA_TEXT, MENSAGEM_EMAIL);

        //configurar apps para e-mail
        email.setType(KEY_EMAIL); // configura o tipo e app sugestivo para email
        startActivity( Intent.createChooser(email, TITULO_ESCOLHA_O_APP)); // definindo Título da escolha de app
    }

    private void instanciaFragments() {
        principalFragment = new PrincipalFragment();
        clientesFragment = new ClientesFragment();
        servicosFragment = new ServicosFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_principal) {

            criaFragment(principalFragment);

        } else if (id == R.id.nav_servicos) {

            criaFragment(servicosFragment);

        } else if (id == R.id.nav_clientes) {

            criaFragment(clientesFragment);

        } else if (id == R.id.nav_contato) {

            enviarEmail();

        } else if (id == R.id.nav_sobre) {

            startActivity(new Intent(getApplicationContext(), SobreActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void criaFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }
}
