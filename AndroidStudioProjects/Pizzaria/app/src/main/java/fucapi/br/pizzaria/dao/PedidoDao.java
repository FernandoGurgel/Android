package fucapi.br.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fucapi.br.pizzaria.bean.PedidoBean;
import fucapi.br.pizzaria.conexao.Conexao;

/**
 * Created by fernando on 12/12/15.
 */
public class PedidoDao {

    private Conexao conexao;
    private String msg;

    public PedidoDao(Context context){
        conexao = new Conexao(context);
    }

    public String inserir(PedidoBean ob){
        String msg = null;
        try{
            ContentValues v=new ContentValues();
            //resgatando valores informados
            v.put("codclicod",ob.getIdUser());
            v.put("codentcod",ob.getIdEntr());
            v.put("codprocod",ob.getIdPro());
            conexao.getWritableDatabase().insert("pedido", null, v);
            msg = "Dados Salvos!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//inserir

    public String editar(PedidoBean ob){
        ContentValues v=new ContentValues();
        //resgatando valores informados
        try{
            v.put("codclicod",ob.getIdUser());
            v.put("codentcod",ob.getIdEntr());
            v.put("codprocod",ob.getIdPro());

            String[] args = {(ob.getIdPedido().toString())};

            conexao.getWritableDatabase().update("pedido", v, "_pedid=?", args);
            msg = "Alterado com sucesso!";
        }catch (Exception e){
            msg=e.getMessage();
        }
        return msg;

    }//editar

    public String deletar(PedidoBean ob){

        try{
            String[] args = {(ob.getIdPedido().toString())};
            conexao.getWritableDatabase().delete("pedido", "_pedid=?",args);
            msg = "Deletado com sucesso!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//excluir

    public List<PedidoBean> listarUsuario(){

        List<PedidoBean> lista = new ArrayList<>();
        String query = "select * from pedido";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){

            PedidoBean bean = new PedidoBean();
            bean.setIdPedido(cursor.getLong(0));
            bean.setNomecli(cursor.getString(1));
            bean.setValor(cursor.getString(3));
            bean.setDescripro(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }


}
