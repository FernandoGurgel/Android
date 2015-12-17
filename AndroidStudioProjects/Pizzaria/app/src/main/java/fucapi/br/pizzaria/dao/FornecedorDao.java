package fucapi.br.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fucapi.br.pizzaria.bean.FornecedorBean;
import fucapi.br.pizzaria.conexao.Conexao;

/**
 * Created by fernando on 12/12/15.
 */
public class FornecedorDao {

    private Conexao conexao;
    private String msg;

    public FornecedorDao(Context context){
        conexao = new Conexao(context);
    }

    /*
    "create table if not exists fornecedor("+
                "_forid integer primary key autoincrement,"+
                "forcnpj varchar(60) not null,"+
                "forfone varchar(20) not null,"+
                "forrazao varchar(60) not null);";
     */

    public String inserir(FornecedorBean ob){
        String msg = null;
        try{
            ContentValues v=new ContentValues();
            //resgatando valores informados
            v.put("forcnpj",ob.getCnpj());
            v.put("forfone",ob.getFone());
            v.put("forrazao",ob.getRazao());
            conexao.getWritableDatabase().insert("fornecedor", null, v);
            msg = "Dados Salvos!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//inserir
    
    public String editar(FornecedorBean ob){
        ContentValues v=new ContentValues();
        //resgatando valores informados
        try{
            v.put("forcnpj",ob.getCnpj());
            v.put("forfone",ob.getFone());
            v.put("forrazao",ob.getRazao());

            String[] args = {(ob.getIdFor().toString())};

            conexao.getWritableDatabase().update("fornecedor", v, "_forid=?", args);
            msg = "Alterado com sucesso!";
        }catch (Exception e){
            msg=e.getMessage();
        }
        return msg;

    }//editar

    public String deletar(FornecedorBean ob){

        try{
            String[] args = {(ob.getIdFor().toString())};
            conexao.getWritableDatabase().delete("fornecedor", "_forid=?",args);
            msg = "Deletado com sucesso!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//excluir

    public List<FornecedorBean> listarUsuario(){

        List<FornecedorBean> lista = new ArrayList<>();
        String query = "select * from fornecedor";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){

            FornecedorBean bean = new FornecedorBean();
            bean.setRazao(cursor.getString(3));
            bean.setIdFor(cursor.getLong(0));
            bean.setCnpj(cursor.getString(1));
            bean.setFone(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }


}
