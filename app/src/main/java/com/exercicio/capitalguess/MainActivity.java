package com.exercicio.capitalguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // defino um contador para ser reiniciado cada 5 perguntas
    private int count = 0;
    // um contador para saber as respostas corretas
    private int success = 0;
    // um numero que é o indice no array
    private int estado = 0;
    // um array de inteiros para saber quis estado perguntei
    private int[] perguntados = {-1,-1,-1,-1,-1};
    // boleano para verificar se tenho um novo estado escolhido
    private boolean newEstado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // pego os elementos da janela
        EditText resposta = findViewById(R.id.resposta);
        TextView result = findViewById(R.id.result);
        TextView score = findViewById(R.id.scorePlayer);
        TextView ask = findViewById(R.id.textAsk);
        Button confirm = findViewById(R.id.confirm);
        TextView textEstado = findViewById(R.id.textEstado);
        Button nxt = findViewById(R.id.next);

        // oculto os elementos para apresentar unicamente a imagem e o botao de start
        resposta.setVisibility(View.GONE);
        result.setVisibility(View.GONE);
        score.setVisibility(View.GONE);
        ask.setVisibility(View.GONE);
        confirm.setVisibility(View.GONE);
        textEstado.setVisibility(View.GONE);

        // mudo o botao para que apresente a mensagem start
        nxt.setText("Start");
    }

    // funcao encarregada do genrenciamento de visibilidade dos elementos, também sorteia um numero em
    // relação ao numero de estados do array. quando chega na ultima pergunta se reinicia o jogo (contador)

    public void next(View view){
        // defino dos arrays de strings onde posiciono os estados (no mesmo index das capitais)
        String[] estados = {"Acre","Alagoas","Amapa","Amazonas","Bahia","Ceará","Distrito Federal","Espíritu Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba"};

        // pego os elementos da janela
        Button nxt = (Button)findViewById(R.id.next);
        TextView textEstado = findViewById(R.id.textEstado);
        TextView result = findViewById(R.id.result);
        TextView score = findViewById(R.id.scorePlayer);
        Button confirm = findViewById(R.id.confirm);
        TextView ask = findViewById(R.id.textAsk);
        ImageView foto = findViewById(R.id.logo);

        //cada vez que clicar no botao será atualiado os pontos
        score.setText("Score: "+String.valueOf(success*10));

        // coulto a imagem do inicio
        foto.setVisibility(View.GONE);

        // aleatoreamento sorteio um numero de 0 ate 15 -> # de estados
        Random r = new Random();
        estado = r.nextInt(16);
        // para a primeira rodada
        if(count ==0){
            // na primeira interacao deixo visiveis os elementos que estão ocultos
            result.setVisibility(View.VISIBLE);
            score.setVisibility(View.VISIBLE);
            ask.setVisibility(View.VISIBLE);
            textEstado.setVisibility(View.VISIBLE);
            // Mudo o texto do botao de start ou gameend para Next
            nxt.setText("Next");
        }
        if(count <5){
        // verifico que o estado nao tenha sido perguntado
            for(int i = 0;i < count;i++){
                // se o estado fosse igual a um anterior
                if(estado == perguntados[i]){
                    // entra em loop ate que tenha um numero diferente
                    while(!newEstado){
                        estado = r.nextInt(16);
                        if(estado != perguntados[i]){
                            newEstado = true;
                        }
                    }
                    // mudo o boolean para a siguente interacao
                    newEstado = false;
                }
                // assim com cada possicao
            }
            // guardo o estado na possicao da pergunta atual
            perguntados[count] = estado;
            // Apresento o estado sorteado ao usuario
            textEstado.setText(estados[estado]);
            // apresento o espaço para a resposta
            EditText resposta = findViewById(R.id.resposta);
            resposta.setVisibility(View.VISIBLE);
            // limpo o campo
            resposta.setText("");
            // deixo visivel o botao para confirmar a resposta e oculto o de next
            confirm.setVisibility(View.VISIBLE);
            nxt.setVisibility(View.GONE);
            // altero a mensagem onde será apresentado se acertou ou nao
            result.setText("Qual será? (Não utilice acentos)");
            // aumento em 1 o contador
            count++;
        }else{
            // mensagem personalizada para quem acertar todas
            if(success == 5){
                score.setText("Parabens!! "+String.valueOf(success*10));
            }
            // se o contador é maior o igual que 5
            // oculto os elementos para indicar o fin do jogo
            EditText resposta = findViewById(R.id.resposta);
            resposta.setVisibility(View.GONE);
            result.setVisibility(View.GONE);
            ask.setVisibility(View.GONE);
            confirm.setVisibility(View.GONE);
            // mudo o texto do botao de next para Game End e apresento ele
            nxt.setVisibility(View.VISIBLE);
            nxt.setText("Game End!");
            // altero o texto onde se apresenta o estado para a mensagem final
            textEstado.setText("Obragad@ por jogar!");
            // reinicio o contador e o numero de acertos
            count =0;
            success = 0;
            // reinicio o vetor com os perguntados
            for(int j = 0;j<5;j++){
                perguntados[j]= -1;
            }
        }

    }

// funcao encarregada de determinar se o usuario acertou o nao e apresentar a mensagem que corresponde

    public void Guess(View vew){

        // defino dos arrays de strings onde posiciono as capitais
        String[] capitais = {"rio branco","maceio","macapa","manaus","salvador","fortaleza","brasilia","vitoria","goiania","sao luis","cuiaba","campo grande","belo horizonte","belem","joao pessoa"};
            // apresnto o botao para continuar
            Button nxt = (Button)findViewById(R.id.next);
            nxt.setVisibility(View.VISIBLE);
            // oculto o batao de confirmar resposta
            Button confirm = (Button)findViewById(R.id.confirm);
            confirm.setVisibility(View.GONE);

            // pego os elemento para determinar a validez da resposta
            EditText resposta = findViewById(R.id.resposta);
            TextView result = findViewById(R.id.result);
            TextView score = findViewById(R.id.scorePlayer);

            // se o digitado pelo usuario coincide com o que esta no array de capitais...
            if(resposta.getText().toString().equalsIgnoreCase(capitais[estado])){
                // apresento a mensagem que acertou
                result.setText("Muito Bemm voce Acertou");
                //auemnto em 1 ao numero de acertos
                success++;
                // atualizo o texto que apresenta os pontos do jogador
                score.setText("Score: "+String.valueOf(success*10));
            }else{
                // se nao acertou, apresenta a mensagem de erro e o nome da capital correta
                result.setText("Nãoo :(... A resposta era "+capitais[estado]);
            }
    }


}