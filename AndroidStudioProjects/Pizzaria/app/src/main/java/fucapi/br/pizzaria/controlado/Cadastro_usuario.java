package fucapi.br.pizzaria.controlado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.UsuarioBean;
import fucapi.br.pizzaria.dao.UsuarioDao;


// tela de cadastro falta editar mais esta tudo OK com salvar

public class Cadastro_usuario extends AppCompatActivity {

    private Button btnsalvar;
    private EditText nome, email, senha;
    private RadioButton radioButton;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        final UsuarioDao dao = new UsuarioDao(this);

        nome = (EditText) findViewById(R.id.nomeUsuario);
        email = (EditText) findViewById(R.id.emailUsuario);
        senha = (EditText) findViewById(R.id.senhaUsuario);
        radioGroup = (RadioGroup) findViewById(R.id.rdgrup);

        final UsuarioBean alterar = (UsuarioBean) getIntent().getSerializableExtra("p_alterar");

        if (alterar != null) {
            setBean(alterar);
            Toast.makeText(Cadastro_usuario.this, alterar.getUsunome(), Toast.LENGTH_SHORT).show();
        }

        btnsalvar = (Button) findViewById(R.id.btnsalva);
        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectRadio = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectRadio);
                if(alterar == null){
                    UsuarioBean bean = new UsuarioBean();
                    bean.setUsusenha(senha.getText().toString());
                    bean.setUsutipo(String.valueOf(radioButton.getText()));
                    bean.setUsunome(nome.getText().toString());
                    bean.setUsuemail(email.getText().toString());
                    String msg = dao.inserir(bean);
                    Toast.makeText(Cadastro_usuario.this,msg,Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    UsuarioBean bean = new UsuarioBean();
                    bean.setUsusenha(senha.getText().toString());
                    bean.setUsutipo(String.valueOf(radioButton.getText()));
                    bean.setUsunome(nome.getText().toString());
                    bean.setUsuemail(email.getText().toString());
                    bean.setUsuid(alterar.getUsuid());
                    String msg = dao.editar(bean);
                    Toast.makeText(Cadastro_usuario.this,msg,Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });
    }

    private void setBean(UsuarioBean alterar) {
        nome.setText(alterar.getUsunome());
        email.setText(alterar.getUsuemail());
        senha.setText(alterar.getUsusenha());
    }
}
