package fucapi.br.pizzaria.controlado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.PedidoBean;
import fucapi.br.pizzaria.dao.PedidoDao;

public class Cadastro_pedido extends AppCompatActivity {

    PedidoDao dao = new PedidoDao(this);
    private Button btnsalvar;
    private EditText cli, pro, entr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        btnsalvar = (Button) findViewById(R.id.btnsalvaPed);
        cli = (EditText) findViewById(R.id.codcli);
        pro = (EditText) findViewById(R.id.codPro);
        entr = (EditText) findViewById(R.id.codEnt);

        final PedidoBean alterar = (PedidoBean) getIntent().getSerializableExtra("p_alterar");

        if (alterar != null) {
            setBean(alterar);
            Toast.makeText(Cadastro_pedido.this, alterar.getIdEntr(), Toast.LENGTH_SHORT).show();
        }

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (alterar == null) {
                    PedidoBean bean = new PedidoBean();
                    bean.setIdUser(Integer.parseInt(cli.getText().toString()));
                    bean.setIdEntr(Integer.parseInt(pro.getText().toString()));
                    bean.setIdPro(Integer.parseInt(pro.getText().toString()));
                    String msg = dao.inserir(bean);
                    Toast.makeText(Cadastro_pedido.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    PedidoBean bean = new PedidoBean();
                    bean.setIdUser(Integer.parseInt(cli.getText().toString()));
                    bean.setIdEntr(Integer.parseInt(entr.getText().toString()));
                    bean.setIdPro(Integer.parseInt(pro.getText().toString()));
                    bean.setIdPedido(Long.valueOf(alterar.getIdEntr()));
                    String msg = dao.editar(bean);
                    Toast.makeText(Cadastro_pedido.this, msg, Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });
    }

    private void setBean(PedidoBean alterar) {
        cli.setText(alterar.getIdUser());
        pro.setText(alterar.getIdPro());
        entr.setText(alterar.getIdEntr());
    }

}
