package fucapi.br.pizzaria.controlado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.ClienteBean;
import fucapi.br.pizzaria.dao.ClienteDao;

public class Cadastro_cliente extends AppCompatActivity {

    ClienteDao dao = new ClienteDao(this);
    private Button btnsalvar;
    private EditText nome, fone, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        
        btnsalvar = (Button) findViewById(R.id.btnsalvaClie);
        nome = (EditText) findViewById(R.id.nomeCliente);
        fone = (EditText) findViewById(R.id.foneCliente);
        end = (EditText) findViewById(R.id.endCliente);

        final ClienteBean alterar = (ClienteBean) getIntent().getSerializableExtra("p_alterar");

        if (alterar != null) {
            setBean(alterar);
            Toast.makeText(Cadastro_cliente.this, alterar.getNome(), Toast.LENGTH_SHORT).show();
        }

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(alterar == null){
                    ClienteBean bean = new ClienteBean();
                    bean.setNome(nome.getText().toString());
                    bean.setEndereco(end.getText().toString());
                    bean.setTelefone(fone.getText().toString());
                    String msg = dao.inserir(bean);
                    Toast.makeText(Cadastro_cliente.this,msg,Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    ClienteBean bean = new ClienteBean();
                    bean.setNome(nome.getText().toString());
                    bean.setEndereco(end.getText().toString());
                    bean.setTelefone(fone.getText().toString());
                    bean.setIdcli(alterar.getIdcli());
                    String msg = dao.editar(bean);
                    Toast.makeText(Cadastro_cliente.this,msg,Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });
    }

    private void setBean(ClienteBean alterar) {
        nome.setText(alterar.getNome());
        end.setText(alterar.getEndereco());
        fone.setText(alterar.getTelefone());
    }
}
