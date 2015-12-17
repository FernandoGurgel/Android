package fucapi.br.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fucapi.br.pizzaria.bean.ClienteBean;
import fucapi.br.pizzaria.conexao.Conexao;

/**
 * Created by fernando on 12/12/15.
 */
public class ClienteDao {

    private Conexao conexao;
    private String msg;

    public ClienteDao(Context context){
        conexao = new Conexao(context);
    }


    public String inserir(ClienteBean ob){
        String msg = null;
        try{
            ContentValues v=new ContentValues();
            //resgatando valores informados
            v.put("clinome",ob.getNome());
            v.put("clifone",ob.getTelefone());
            v.put("cliend",ob.getEndereco());
            conexao.getWritableDatabase().insert("cliente", null, v);
            msg = "Dados Salvos!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//inserir
    
    public String editar(ClienteBean ob){
        ContentValues v=new ContentValues();
        //resgatando valores informados
        try{
            v.put("clinome",ob.getNome());
            v.put("clifone",ob.getTelefone());
            v.put("cliend",ob.getEndereco());

            String[] args = {(ob.getIdcli().toString())};

            conexao.getWritableDatabase().update("cliente", v, "_cliid=?", args);
            msg = "Alterado com sucesso!";
        }catch (Exception e){
            msg=e.getMessage();
        }
        return msg;

    }//editar

    public String deletar(ClienteBean ob){

        try{
            String[] args = {(ob.getIdcli().toString())};
            conexao.getWritableDatabase().delete("cliente", "_cliid=?",args);
            msg = "Deletado com sucesso!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//excluir

    public List<ClienteBean> listarUsuario(){

        List<ClienteBean> lista = new ArrayList<>();
        String query = "select * from cliente";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){

            ClienteBean bean = new ClienteBean();
            bean.setEndereco(cursor.getString(3));
            bean.setIdcli(cursor.getLong(0));
            bean.setNome(cursor.getString(1));
            bean.setTelefone(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }


}
