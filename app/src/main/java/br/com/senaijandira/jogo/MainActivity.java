package br.com.senaijandira.jogo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import br.com.senaijandira.jogo.R;

public class MainActivity extends Activity {


    TextView txtPalavra, txtDica;
    Button btnLetraA, btnLetraB, btnLetraC, btnLetraD, btnLetraE, btnLetraF, btnLetraG, btnLetraH, btnLetraI,
            btnLetraJ, btnLetraK, btnLetraL, btnLetraM, btnLetraN, btnLetraO, btnLetraP, btnLetraQ, btnLetraR,
            btnLetraS, btnLetraT, btnLetraU, btnLetraV, btnLetraW, btnLetraX, btnLetraY, btnLetraZ, btnDicas;
    String palavraEscolhida;
    String resposta, dica;
    LinearLayout linearPalvra;
    int index;

    //click do botão da dica
    View.OnClickListener clickDica = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtDica.setText(dica);
        }
    };


    public void inicioJogo() {

        final String [] palavras = {
          "Java"
        };

        String [] dicas = {
                "Melhor linguagem de programação!"
        };

        resposta = palavras[0];
        dica = dicas[0];
        for(int contador = 0; contador < resposta.length(); contador++){
            TextView letra = new TextView(this);
            txtPalavra.setText("_");
            txtPalavra.setPadding(0,0,10,0);

        }



        //setando a função do click do botão
        btnDicas.setOnClickListener(clickDica);

    }

    /* public void alert(String titulo, String msg){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        //impedindo o alert de fechar quando for clicado fora da caixa
        alert.setCancelable(false);

        alert.create().show();

    }
    //CONTADOR DE TEMPO
        CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
        //configura a atualização de tela a cada segundo
            txtRelogio.setText(""+ millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            alert("Seu tempo acabou!","É melhor JAIR se acostumando com a derrota!");
        }
    };

    */



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtPalavra = findViewById(R.id.txtPalavra);
        txtDica = findViewById(R.id.txtDica);

        //chamando as letras que estão dentro do botão
        btnLetraA = findViewById(R.id.letraA);
        btnLetraB = findViewById(R.id.letraB);
        btnLetraC = findViewById(R.id.letraC);
        btnLetraD = findViewById(R.id.letraD);
        btnLetraE = findViewById(R.id.letraE);
        btnLetraF = findViewById(R.id.letraF);
        btnLetraG = findViewById(R.id.letraG);
        btnLetraH = findViewById(R.id.letraH);
        btnLetraI = findViewById(R.id.letraI);
        btnLetraJ = findViewById(R.id.letraJ);
        btnLetraK = findViewById(R.id.letraK);
        btnLetraL = findViewById(R.id.letraL);
        btnLetraM = findViewById(R.id.letraM);
        btnLetraN = findViewById(R.id.letraN);
        btnLetraO = findViewById(R.id.letraO);
        btnLetraP = findViewById(R.id.letraP);
        btnLetraQ = findViewById(R.id.letraQ);
        btnLetraR = findViewById(R.id.letraR);
        btnLetraS = findViewById(R.id.letraS);
        btnLetraT = findViewById(R.id.letraT);
        btnLetraU = findViewById(R.id.letraU);
        btnLetraV = findViewById(R.id.letraV);
        btnLetraW = findViewById(R.id.letraW);
        btnLetraX = findViewById(R.id.letraX);
        btnLetraY = findViewById(R.id.letraY);
        btnLetraZ = findViewById(R.id.letraZ);
        btnDicas = findViewById(R.id.btnDica);



        inicioJogo();

    }


}
