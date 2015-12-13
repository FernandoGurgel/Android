package fucapi.br.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fucapi.br.pizzaria.bean.UsuarioBean;
import fucapi.br.pizzaria.conexao.Conexao;

/**
 * Created by fernando on 12/12/15.
 */
public class UsuarioDao {

    private Conexao conexao;

    public UsuarioDao(Context context){
        conexao = new Conexao(context);
    }

    public String inserir(UsuarioBean ob){
        String msg = null;
        try{
            ContentValues v=new ContentValues();
            //resgatando valores informados
            v.put("usunome",ob.getUsunome());
            v.put("ususenha",ob.getUsusenha());
            v.put("usuemail",ob.getUsuemail());
            v.put("usutipo",ob.getUsutipo());
            conexao.getWritableDatabase().insert("usuario", null, v);
            msg = "Dados Salvos!";
        }catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }//inserir
    
    public void editar(UsuarioBean ob){
        ContentValues v=new ContentValues();
        //resgatando valores informados
        v.put("usunome",ob.getUsunome());
        v.put("ususenha",ob.getUsusenha());
        v.put("usuemail",ob.getUsuemail());
        v.put("usutipo",ob.getUsutipo());
        //editando
        conexao.getWritableDatabase().update("usuario", v, "_usuid=?", new String[]{"" + ob.getUsuid()});
    }//editar

    public void deletar(UsuarioBean ob){
        conexao.getWritableDatabase().delete("usuario", "_usuid=" + ob.getUsuid(), null);
    }//excluir

    public List<UsuarioBean> listarUsuario(){
        List<UsuarioBean> lista = new ArrayList<>();
        String query = "select * from usuario";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){

            UsuarioBean bean = new UsuarioBean();
            bean.setUsuemail(cursor.getString(3));
            bean.setUsuid(cursor.getLong(0));
            bean.setUsunome(cursor.getString(1));
            bean.setUsusenha(cursor.getString(2));
            bean.setUsutipo(cursor.getString(4));
            lista.add(bean);
        }
        return lista;
    }

    public String validaUsuario(UsuarioBean bean){

        String query = "select * from usuario where usuemail = '" + bean.getUsuemail() + "' and ususenha = '" +bean.getUsusenha()+"'";
        Cursor cursor = conexao.getWritableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){
            bean.setUsuemail(cursor.getString(3));
            bean.setUsuid(cursor.getLong(0));
            bean.setUsunome(cursor.getString(1));
            bean.setUsusenha(cursor.getString(2));
            bean.setUsutipo(cursor.getString(4));

        }

        return bean.getUsunome();
    }

}
