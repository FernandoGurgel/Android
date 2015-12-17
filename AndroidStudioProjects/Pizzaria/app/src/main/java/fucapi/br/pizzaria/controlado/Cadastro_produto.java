package fucapi.br.pizzaria.controlado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.ProdutoBean;
import fucapi.br.pizzaria.dao.ProdutoDao;

public class Cadastro_produto extends AppCompatActivity {

    ProdutoDao dao = new ProdutoDao(this);
    private Button btnsalvar;
    private EditText descricao, valor, qtd;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        
        descricao = (EditText) findViewById(R.id.descPro);
        valor = (EditText) findViewById(R.id.vlPro);
        qtd = (EditText) findViewById(R.id.qtdPro);
        btnsalvar = (Button) findViewById(R.id.btnsalvaPro);

        final ProdutoBean alterar = (ProdutoBean) getIntent().getSerializableExtra("p_alterar");

        if (alterar != null) {
            setBean(alterar);
            Toast.makeText(Cadastro_produto.this, alterar.getDescricao(), Toast.LENGTH_SHORT).show();
        }

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (alterar == null) {
                    ProdutoBean bean = new ProdutoBean();
                    bean.setDescricao(descricao.getText().toString());
                    bean.setValor(valor.getText().toString());
                    bean.setQtd(qtd.getText().toString());
                    String msg = dao.inserir(bean);
                    Toast.makeText(Cadastro_produto.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    ProdutoBean bean = new ProdutoBean();
                    bean.setDescricao(descricao.getText().toString());
                    bean.setValor(valor.getText().toString());
                    bean.setQtd(qtd.getText().toString());
                    bean.setProid(alterar.getProid());
                    String msg = dao.editar(bean);
                    Toast.makeText(Cadastro_produto.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });
    }

    private void setBean(ProdutoBean alterar) {
        descricao.setText(alterar.getDescricao());
        qtd.setText(alterar.getQtd());
        valor.setText(alterar.getValor());
    }
}
