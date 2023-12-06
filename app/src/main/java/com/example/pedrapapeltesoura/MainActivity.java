package com.example.pedrapapeltesoura;

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
        verificarGanhador("Pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    private String gerarEscolhaAleatoria() {
        String[] opçoes = {"Pedra", "Papel", "Tesoura"};
        Random random = new Random();
        //int numero = new  Random().nextInt(3);
        int numeroAleatorio = random.nextInt(3);

        ImageView imageApp = findViewById(R.id.Image_App);

        String escolhaApp = opçoes[numeroAleatorio];

        switch (escolhaApp) {
            case "Pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoria();
        TextView textoResultado = findViewById(R.id.Text_Resultado);


        if ((escolhaApp == "pedra") && (escolhaUsuario == "tesoura") ||
                (escolhaApp == "papel") && (escolhaUsuario == "pedra") ||
                (escolhaApp == "tesoura") && (escolhaUsuario == "papel")) {
            textoResultado.setText("Você Venceu ");
        }
        else if ((escolhaUsuario == "pedra") && (escolhaApp == "papel")) ||
                ((escolhaUsuario == "papel") && (escolhaApp == "tesoura")) ||
                ((escolhaUsuario == "tesoura") && (escolhaApp == "pedra"))) {
            textoResultado.setText("Você perdeu ");
        } else if(((escolhaUsuario == "pedra") && (escolhaApp == "pedra")) ||
                ((escolhaUsuario == "papel") && (escolhaApp == "papel")) ||
                ((escolhaUsuario == "tesoura") && (escolhaApp == "tesoura")))
            textoResultado.setText("Empatamos ");
    }
}