package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("PEDRA");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("PAPEL");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("TESOURA");
    }

    private String gerarEscolhaApp() {
        String[] opcoes = {"PEDRA", "PAPEL", "TESOURA"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){

            case "PEDRA":
                imagemApp.setImageResource( R.drawable.pedra );
                break;
            case "PAPEL":
                imagemApp.setImageResource( R.drawable.papel );
                break;
            case "TESOURA":
                imagemApp.setImageResource( R.drawable.tesoura );
                break;

        }
        return escolhaApp;
    }

    public void verificarGanhador(String escolhaUsuario) {

        String escolhaApp = gerarEscolhaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
            (escolhaApp == "PEDRA" && escolhaUsuario == "TESOURA") ||
            (escolhaApp == "PAPEL" && escolhaUsuario == "PEDRA") ||
            (escolhaApp == "TESOURA" && escolhaUsuario == "PAPEL")
        ){ //App ganhou
            textoResultado.setText("VOCÊ PERDEU!  :(");
        } else if (
            (escolhaUsuario == "PEDRA" && escolhaApp == "TESOURA") ||
            (escolhaUsuario == "PAPEL" && escolhaApp == "PEDRA") ||
            (escolhaUsuario == "TESOURA" && escolhaApp == "PAPEL")
        ) {// Usuario ganhou
            textoResultado.setText("VOCÊ GANHOU!  :)");
        } else { // Empatou
            textoResultado.setText("EMPATE!  ;)");
        }

    }




}