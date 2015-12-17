package fucapi.br.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fucapi.br.pizzaria.bean.ProdutoBean;
import fucapi.br.pizzaria.conexao.Conexao;

/**
 * Created by fernando on 12/12/15.
 */
public class ProdutoDao {

    private Conexao conexao;
    private String msg;

    public ProdutoDao(Context context){
        conexao = new Conexao(context);
    }


    public String inserir(ProdutoBean ob){
        String msg = null;
        try{
            ContentValues v=new ContentValues();
            //resgatando valores informados
            v.put("prodesc",ob.getDescricao());
            v.put("proqtd",ob.getQtd());
            v.put("provl",ob.getValor());
            conexao.getWritableDatabase().insert("produto", null, v);
            msg = "Dados Salvos!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//inserir
    
    public String editar(ProdutoBean ob){
        ContentValues v=new ContentValues();
        //resgatando valores informados
        try{
            v.put("prodesc",ob.getDescricao());
            v.put("proqtd",ob.getQtd());
            v.put("provl",ob.getValor());

            String[] args = {(ob.getProid().toString())};

            conexao.getWritableDatabase().update("produto", v, "_proid=?", args);
            msg = "Alterado com sucesso!";
        }catch (Exception e){
            msg=e.getMessage();
        }
        return msg;

    }//editar

    public String deletar(ProdutoBean ob){

        try{
            String[] args = {(ob.getProid().toString())};
            conexao.getWritableDatabase().delete("produto", "_proid=?",args);
            msg = "Deletado com sucesso!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//excluir

    public List<ProdutoBean> listarUsuario(){

        List<ProdutoBean> lista = new ArrayList<>();
        String query = "select * from produto";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){

            ProdutoBean bean = new ProdutoBean();
            bean.setQtd(cursor.getString(3));
            bean.setProid(cursor.getLong(0));
            bean.setDescricao(cursor.getString(1));
            bean.setValor(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }


}
