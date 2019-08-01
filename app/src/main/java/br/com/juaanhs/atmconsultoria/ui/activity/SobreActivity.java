package br.com.juaanhs.atmconsultoria.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.juaanhs.atmconsultoria.R;
import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    public static final String DESCRICAO = "A ATM Consultoria tem como missão apoiar as organizações que desejam alcançar o sucesso atráves da excelência em gestão e da busca pela QUALIDADE.\n\nNosso trabalho é dar suporte às empresas que desejam se certificar em padrões de qualidade ou investir no desenvolvimento eevolução de sua gestão, por meio da otimização dos processos e da disseminação dos fundamentos e critérios de EXCELÊNCIA.";
    public static final String FALE_CONOSCO = "Fale conosco";
    public static final String ATM_EMAIL = "atmconsultoria@gmail.com";
    public static final String TITULO_EMAIL = "Envie um Email";
    public static final String ATM_SITE = "https://www.google.com/";
    public static final String TITULO_SITE = "Visite nosso Site";
    public static final String REDES_SOCIAIS = "Redes sociais";
    public static final String ATM_FACEBOOK = "google";
    public static final String TITULO_FACEBOOK = "Curta no Facebook";
    public static final String ATM_TWITTER = "google";
    public static final String TITULO_TWITTER = "Siga no Twitter";
    public static final String TITULO_YOUTUBE = "Assista no Youtube";
    public static final String ATM_YOUTUBE = "UCdPQtdWIsg7_pi4mrRu46vA";
    public static final String ATM_APP = "com.google.android.apps.plus";
    public static final String TITULO_APP = "Nos avalie na PlayStore";
    public static final String ATM_GITHUB = "juaanhs";
    public static final String TITULO_GITHUB = "Visite nosso GitHub";
    public static final String ATM_INSTAGRAM = "google";
    public static final String TITULO_INSTAGRAM = "Siga no Instagram";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View sobre = criaViewSobre();
        setContentView(sobre);
    }

    private View criaViewSobre() {
        return new AboutPage(this)
                    .setImage(R.drawable.logo)
                    .setDescription(DESCRICAO)
                    .addGroup(FALE_CONOSCO)
                    .addEmail(ATM_EMAIL, TITULO_EMAIL)
                    .addWebsite(ATM_SITE, TITULO_SITE)
                    .addGroup(REDES_SOCIAIS)
                    .addFacebook(ATM_FACEBOOK, TITULO_FACEBOOK)
                    .addTwitter(ATM_TWITTER, TITULO_TWITTER)
                    .addYoutube(ATM_YOUTUBE, TITULO_YOUTUBE)
                    .addPlayStore(ATM_APP, TITULO_APP)
                    .addGitHub(ATM_GITHUB, TITULO_GITHUB)
                    .addInstagram(ATM_INSTAGRAM, TITULO_INSTAGRAM)
                    .create();
    }
}
