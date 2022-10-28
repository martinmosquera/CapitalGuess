package com.exercicio.capitalguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String[] estados = {"Acre","Alagoas","Amapa","Amazonas","Bahia","Ceará","Distrito Federal","Espíritu Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
    private final String[] capitais = {"rio branco","maceio","macapa","manaus","salvador","fortaleza","brasilia","vitoria","goiania","sao luis","cuiaba","campo grande","belo horizonte","belem","joao pessoa","curitiba","recife","teresina","rio de janeiro","natal","porto alegre","boa vista","florianopolis","sao paulo","aracaju","palmas"};

    private int count = 0;
    private int success = 0;
    private int state = 0;
    private boolean ansState = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText resposta = findViewById(R.id.resposta);
        resposta.setVisibility(View.GONE);
        TextView result = findViewById(R.id.result);
        result.setVisibility(View.GONE);
        TextView score = findViewById(R.id.scorePlayer);
        score.setVisibility(View.GONE);
        TextView ask = findViewById(R.id.textAsk);
        ask.setVisibility(View.GONE);
        Button confirm = findViewById(R.id.confirm);
        confirm.setVisibility(View.GONE);
        TextView textEstado = findViewById(R.id.textEstado);
        textEstado.setVisibility(View.GONE);
        Button nxt = (Button)findViewById(R.id.next);
        nxt.setText("Start");
    }

    public void Guess(View vew){
        if(ansState){
            Button nxt = (Button)findViewById(R.id.next);
            nxt.setVisibility(View.VISIBLE);
            EditText resposta = findViewById(R.id.resposta);
            TextView result = findViewById(R.id.result);
            if(resposta.getText().toString().equalsIgnoreCase(capitais[state])){
                result.setText("Muito Bemm voce Acertou");
                success++;
            }else{
                result.setText("Nãoo :(... A resposta era "+capitais[state]);
            }
            ansState = false;
        }else{
            TextView result = findViewById(R.id.result);
            result.setText("Não tenta fazer trampinhas!");
        }

    }

    public void next(View view){
        Button nxt = (Button)findViewById(R.id.next);
        TextView textEstado = findViewById(R.id.textEstado);
        TextView result = findViewById(R.id.result);
        TextView score = findViewById(R.id.scorePlayer);
        score.setText(String.valueOf(success*10));
        if(count ==0){
            Button confirm = findViewById(R.id.confirm);
            confirm.setVisibility(View.VISIBLE);
            EditText resposta = findViewById(R.id.resposta);
            resposta.setVisibility(View.VISIBLE);
            result.setVisibility(View.VISIBLE);
            score.setVisibility(View.VISIBLE);
            TextView ask = findViewById(R.id.textAsk);
            ask.setVisibility(View.VISIBLE);
            textEstado.setVisibility(View.VISIBLE);
        }
        if(count <6){
            state = new Random().nextInt(26)+1;
            textEstado.setText(estados[state]);
            count++;
            ansState = true;
            nxt.setText("Next");
            nxt.setVisibility(View.GONE);
            EditText resposta = findViewById(R.id.resposta);
            resposta.setText("");
            result.setText("Qual será? (Não utilice acentos)");
        }else{
            nxt.setText("Game End!");
            EditText resposta = findViewById(R.id.resposta);
            resposta.setVisibility(View.GONE);
            result.setText("Obragad@ por jogar!");
            TextView ask = findViewById(R.id.textAsk);
            ask.setVisibility(View.GONE);
            Button confirm = findViewById(R.id.confirm);
            confirm.setVisibility(View.GONE);
            textEstado.setVisibility(View.GONE);
            count =0;
            success = 0;
        }

    }
}