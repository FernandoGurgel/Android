package fucapi.br.pizzaria.controlado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import fucapi.br.pizzaria.R;
import fucapi.br.pizzaria.bean.EntregadorBean;
import fucapi.br.pizzaria.dao.EntregadorDao;

public class Lista_Entregador extends AppCompatActivity {

    private Intent intent = null;
    EntregadorDao dao = null;
    EntregadorBean bean = new EntregadorBean();

    // lista que será exibida na tela
    private ListView lista;
    // colecao a ser carregada
    private List<EntregadorBean> listaBean;
    // trasforma veter para lista
    private ArrayAdapter<EntregadorBean> adapter;
    // tipo de lista a ser ultilizada
    private int adapterLayout = android.R.layout.simple_list_item_1;

    // carrega o selecionado
    private EntregadorBean selecionado = null;


    // chamando a lista
    public void carregaLista(){
        dao = new EntregadorDao(this);
        listaBean = dao.listarUsuario();
        adapter = new ArrayAdapter<EntregadorBean>(this,adapterLayout,listaBean);
        lista.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__entregador);

        lista = (ListView) findViewById(R.id.lista_entrg);

        registerForContextMenu(lista);
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selecionado = adapter.getItem(position);
                return false;
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                intent = new Intent(Lista_Entregador.this, Cadastro_entregador.class);
                selecionado = (EntregadorBean) lista.getItemAtPosition(position);
                intent.putExtra("p_alterar", selecionado);
                startActivity(intent);
            }
        });
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Lista_Entregador.this,Cadastro_entregador.class);
                startActivity(intent);
            }
        });
    }

    private void excluir(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja excluir! \n" + selecionado.getNome());

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao = new EntregadorDao(Lista_Entregador.this);
                String mensagem = dao.deletar(selecionado);
                dao.listarUsuario();
                selecionado = null;
                Toast.makeText(Lista_Entregador.this, mensagem, Toast.LENGTH_SHORT).show();
                onResume();
            }
        });
        builder.setNegativeButton("Não", null);
        AlertDialog dialog = builder.create();
        dialog.setTitle("Atenção");
        dialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_lista, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_deleta:
                excluir();
                break;
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregaLista();
    }
}
