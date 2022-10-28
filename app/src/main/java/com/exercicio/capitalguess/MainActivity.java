package com.exercicio.capitalguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] estados = {"Acre","Alagoas","Amapa","Amazonas","Bahia","Ceará","Distrito Federal","Espíritu Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
    String[] capitais = {"rio branco","maceio","macapa","manaus","salvador","fortaleza","brasilia","vitoria","goiania","são luis","cuiaba","campo grande","belo horizonte","belem","joao pessoa","curitiba","recife","teresina","rio de janeiro","natal","porto alegre","boa vista","florianopolis","são paulo","aracaju","palmas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}