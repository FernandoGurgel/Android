package fucapi.br.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fucapi.br.pizzaria.bean.EntregadorBean;
import fucapi.br.pizzaria.conexao.Conexao;

/**
 * Created by fernando on 12/12/15.
 */
public class EntregadorDao {

    private Conexao conexao;
    private String msg;

    public EntregadorDao(Context context){
        conexao = new Conexao(context);
    }


   /* "create table if not exists entregador("+
            "_entrid integer primary key autoincrement,"+
            "entrnome varchar(60) not null,"+
            "entrfone varchar(20) not null);";
            */
    
    public String inserir(EntregadorBean ob){
        String msg = null;
        try{
            ContentValues v=new ContentValues();
            //resgatando valores informados
            v.put("entrnome",ob.getNome());
            v.put("entrfone",ob.getFone());
            conexao.getWritableDatabase().insert("entregador", null, v);
            msg = "Dados Salvos!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//inserir
    
    public String editar(EntregadorBean ob){
        ContentValues v=new ContentValues();
        //resgatando valores informados
        try{
            v.put("entrnome",ob.getNome());
            v.put("entrfone",ob.getFone());

            String[] args = {(ob.getIdEnt().toString())};

            conexao.getWritableDatabase().update("entregador", v, "_entrid=?", args);
            msg = "Alterado com sucesso!";
        }catch (Exception e){
            msg=e.getMessage();
        }
        return msg;

    }//editar

    public String deletar(EntregadorBean ob){

        try{
            String[] args = {(ob.getIdEnt().toString())};
            conexao.getWritableDatabase().delete("entregador", "_entrid=?",args);
            msg = "Deletado com sucesso!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//excluir

    public List<EntregadorBean> listarUsuario(){

        List<EntregadorBean> lista = new ArrayList<>();
        String query = "select * from entregador";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){

            EntregadorBean bean = new EntregadorBean();
            bean.setIdEnt(cursor.getLong(0));
            bean.setNome(cursor.getString(1));
            bean.setFone(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }


}
