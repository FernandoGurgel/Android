package fucapi.br.pizzaria.controlado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fucapi.br.pizzaria.R;

public class Principal extends AppCompatActivity {

    private TextView nome,email;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nome = (TextView) findViewById(R.id.txt_userNome);
        email = (TextView) findViewById(R.id.txt_userEmail);

        Intent intent = getIntent();
        nome.setText(intent.getStringExtra("nome"));
        email.setText(intent.getStringExtra("email"));
        findViewById(R.id.btn_cli).setOnClickListener(meClickou);
        findViewById(R.id.btn_entrega).setOnClickListener(meClickou);
        findViewById(R.id.btn_pedido).setOnClickListener(meClickou);
        findViewById(R.id.btn_pro).setOnClickListener(meClickou);
        findViewById(R.id.btn_User).setOnClickListener(meClickou);

    }

    private View.OnClickListener meClickou = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_cli:
                    intent = new Intent(Principal.this,Lista_Cliente.class);
                    break;
                case R.id.btn_entrega:
                    intent = new Intent(Principal.this,Lista_Entregador.class);
                    break;

                case R.id.btn_pedido:
                    intent = new Intent(Principal.this,Lista_Pedido.class);
                    break;
                case R.id.btn_pro:
                    intent = new Intent(Principal.this,Lista_Produto.class);
                    break;
                case R.id.btn_User:
                    intent = new Intent(Principal.this,Lista_Usuario.class);
                    break;
            }
            startActivity(intent);
        }
    };


}
