package com.example.projetocatalogocursos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projetocatalogocursos.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    //criando a lista
    ArrayList<Curso> listaCursos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //verificando as infromações
                if (!binding.etNome.getText().toString().equals("")){
                    if (!binding.etCargaHoraria.getText().toString().equals("")){
                        if (!binding.etConceito.getText().toString().equals("")){
                            if (binding.rbTecnologo.isChecked() || binding.rbBacharalelo.isChecked() || binding.rbLicenciatura.isChecked()){
                                //obtendo as informações
                                String nome = binding.etNome.getText().toString();
                                float cargaHoraria = Float.parseFloat(binding.etCargaHoraria.getText().toString());
                                int conceito = Integer.parseInt(binding.etConceito.getText().toString());
                                int tipo = 0;

                                if (binding.rbTecnologo.isChecked()){
                                    tipo = 1; //Tecnólogo
                                } else if(binding.rbBacharalelo.isChecked()){
                                    tipo = 2; //Bacharelado
                                } else{
                                    tipo = 3; //Licenciatura
                                }

                                //criando o objeto
                                Curso meuCurso = new Curso(nome, cargaHoraria, conceito, tipo);

                                //adicionando o objeto na lista
                                listaCursos.add(meuCurso);
                                Toast.makeText(MainActivity.this, "Curso cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                                limpaCampos();

                            }else{
                                Toast.makeText(MainActivity.this, "Selecione o tipo.", Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            binding.etConceito.setError("Digite o conceito.");
                            binding.etConceito.requestFocus();
                        }
                    } else{
                        binding.etCargaHoraria.setError("Digite a carga horária.");
                        binding.etCargaHoraria.requestFocus();
                    }
                } else{
                    binding.etNome.setError("Digite o nome.");
                    binding.etNome.requestFocus();
                }
            }
        });

        binding.bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });

        binding.bVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declarando as variaveis
                int quantidadeTecnologo = 0, quantidadeBacharelado = 0, quantidadeLicenciatura = 0;
                int maiorConceito = Integer.MIN_VALUE;
                Curso cursoMaisAvaliado = null;

                for (int i = 0; i < listaCursos.size(); i++){
                    Curso meuCurso = listaCursos.get(i);

                    if (meuCurso.getTipo() == 1){
                        quantidadeTecnologo++;
                    } else if (meuCurso.getTipo() == 2) {
                        quantidadeBacharelado++;
                    } else {
                        quantidadeLicenciatura++;
                    }
                    //TAREFA: Nome e tipo do curso mais bem avaliado (de maior conceito)
                    //verificando se o curso é o mais avaliado
                    if (meuCurso.getConceito() > maiorConceito){
                        maiorConceito = meuCurso.getConceito();
                        cursoMaisAvaliado = meuCurso; //mostra todos os dados do curso que está selecionado
                    }
                }
                Toast.makeText(MainActivity.this, "Quantidade dos cursos de tecnólogo "+quantidadeTecnologo+", bacharelado "+quantidadeBacharelado+" e licenciatura "+quantidadeLicenciatura+".", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "O curso mais bem avaliado é o "+cursoMaisAvaliado.getNome()+" da categoria de "+cursoMaisAvaliado.getTipoLiteral()+".", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void limpaCampos(){
        binding.etNome.setText("");
        binding.etCargaHoraria.setText("");
        binding.etConceito.setText("");
        binding.rgTipo.clearCheck();
    }
}