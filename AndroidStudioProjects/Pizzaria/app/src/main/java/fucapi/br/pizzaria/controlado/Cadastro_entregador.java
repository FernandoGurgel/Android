package fucapi.br.pizzaria.controlado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.EntregadorBean;
import fucapi.br.pizzaria.dao.EntregadorDao;

public class Cadastro_entregador extends AppCompatActivity {

    EntregadorDao dao = new EntregadorDao(this);
    private Button btnsalvar;
    private EditText nome, fone;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_entregador);

        nome = (EditText) findViewById(R.id.nomeentre);
        fone = (EditText) findViewById(R.id.fonEntre);
        btnsalvar = (Button) findViewById(R.id.btnsalvaEntre);

        final EntregadorBean alterar = (EntregadorBean) getIntent().getSerializableExtra("p_alterar");

        if (alterar != null) {
            setBean(alterar);
            Toast.makeText(Cadastro_entregador.this, alterar.getNome(), Toast.LENGTH_SHORT).show();
        }

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (alterar == null) {
                    EntregadorBean bean = new EntregadorBean();
                    bean.setNome(nome.getText().toString());
                    bean.setFone(fone.getText().toString());
                    String msg = dao.inserir(bean);
                    Toast.makeText(Cadastro_entregador.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    EntregadorBean bean = new EntregadorBean();
                    bean.setNome(nome.getText().toString());
                    bean.setFone(fone.getText().toString());
                    bean.setIdEnt(alterar.getIdEnt());
                    String msg = dao.editar(bean);
                    Toast.makeText(Cadastro_entregador.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });
        
    }

    private void setBean(EntregadorBean alterar) {
        nome.setText(alterar.getNome());
        fone.setText(alterar.getFone());

    }

}
