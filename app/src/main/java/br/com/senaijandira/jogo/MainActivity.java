package br.com.senaijandira.jogo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import br.com.senaijandira.jogo.R;

public class MainActivity extends Activity {

    //declarando em escopo de classe para que possam ser usadas no codigo
    TextView txtPalavra, txtDica;
    Button btnLetraA, btnLetraB, btnLetraC, btnLetraD, btnLetraE, btnLetraF, btnLetraG, btnLetraH, btnLetraI,
            btnLetraJ, btnLetraK, btnLetraL, btnLetraM, btnLetraN, btnLetraO, btnLetraP, btnLetraQ, btnLetraR,
            btnLetraS, btnLetraT, btnLetraU, btnLetraV, btnLetraW, btnLetraX, btnLetraY, btnLetraZ, btnDicas;

    MediaPlayer musica;

    String resposta, dica;
    //criado um random para selecionar palavras aleatórias
    Random aleatorio;
    //variaveis inteiras
    int index, sorteio, acerto, comparacao;
    //variavel de chances
    int chance = 6;
    //variavel para receber a palavra sorteada
    String palavraEscolhida;
    //variavel para esconder a palavra
    StringBuilder letra = new StringBuilder();
    //alert
    AlertDialog alertas;

    String[] palavras = {
            "Java",
            "PHP",
            "Eclipse",
            "Android",
            "Linux",
            "Celso",
            "Kassiano",
            "Marcel",
            "Windows",
            "Santos",
            "Palmeiras",
            "Corinthians",
            "Sao Paulo",
            "Vasco"
    };

    String[] dicas = {
            "Melhor linguagem de programação!",
            "Linguagem que dá pro gasto",
            "IDE para Java",
            "Sistema operacional para celular",
            "Rogério ama esse pinguim",
            "Deus de Java",
            "Deus de Kotlin",
            "Deus de Web",
            "SO que trava",
            "Cadê minha torcida?",
            "51 é pinga e não mundial",
            "Os jogadores são da febem",
            "Quando vão sair do armário?",
            "Tem mais dedos no Lula do que pontos nesse time"
    };

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


    public void inicioJogo() {

        aleatorio = new Random(); // criando o objeto
        index = palavras.length; //oegando o indice do vetor
        sorteio = aleatorio.nextInt(index); // sorteia o indice do vetor
        palavraEscolhida = palavras[sorteio].toUpperCase(); // gera a palavra com o indice sorteado

        for (int contador = 0; contador < palavraEscolhida.length(); contador++) {
            letra.append("_ ");
        }
        //setando a palavra dentro do txt
        txtPalavra.setText(letra);



        //setando a função do click do botão
        btnDicas.setOnClickListener(clickDica);

        musica = MediaPlayer.create(this, R.raw.game_music);
        musica.start();

    }

    public void verificarLetra(View v) {
        //tranfroma a view v em botao
        Button botao = (Button) v;
        //pega o que esta escrito no botao
        String botaoLetra = botao.getText().toString();
        //verifica o tamanho da palavra
        comparacao = acerto;
        for (int contador = 0; contador < palavraEscolhida.length(); contador++) {
            //verifica letra por letra
            if (botaoLetra.equals(String.valueOf(palavraEscolhida.charAt(contador)))) {
                //trocando o traço pela letra certa
                letra.setCharAt(contador * 2, botaoLetra.charAt(0));
                acerto += 1;
            }
        }

        //decisão de comparação do clique
        if (acerto == comparacao) {
            chance--;

            botao.setEnabled(false);
            botao.setBackgroundResource(R.color.vermelho);
        } else {
            botao.setEnabled(false);
            botao.setBackgroundResource(R.color.verde);
        }

        if(acerto == palavraEscolhida.length()){
            alert("Resposta certa", "Parabéns pelos acertos.");
        }else if(chance == 0){
            alert("Não acertou!", "A palavra era: " + palavraEscolhida);
        }


        txtPalavra.setText(letra.toString());
    }
//parar a musica
    @Override
    protected void onResume() {
        super.onResume();
        musica.pause();
    }

    //formatando o alert para ser usado em outras coisas
    public void alert(String titulo, String msg) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(msg);

        //impedindo o alert de fechar quando for clicado fora da caixa
        alert.setCancelable(false);

        alert.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        // Se clicado, o jogo muda para a proxima pergunta
        alert.setPositiveButton("Próximo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reiniciar();
            }
        });

        alertas = alert.create();
        alertas.show();

    }

    public void reiniciar(){

        // reinicia o jogo
        this.recreate();

    }



    //click do botão da dica
    View.OnClickListener clickDica = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtDica.setText(dicas[sorteio]);

            btnDicas.setEnabled(false);
            btnDicas.setBackgroundResource(R.color.vermelho);
        }
    };

}

