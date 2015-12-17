package fucapi.br.pizzaria.conexao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fernando on 12/12/15.
 */
public class Conexao extends SQLiteOpenHelper {

    private static final String banco = "pizzaria";
    private static final int VERSION = 11;

    public Conexao(Context context){
        super(context,banco,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String usuario = "create table if not exists usuario("+
                "_usuid integer primary key autoincrement,"+
                "usunome varchar(60) not null,"+
                "ususenha varchar(20) not null,"+
                "usuemail varchar(60) not null,"+
                "usutipo varchar(60) not null);";
        db.execSQL(usuario);

        String cliente = "create table if not exists cliente("+
                "_cliid integer primary key autoincrement,"+
                "clinome varchar(60) not null,"+
                "clifone varchar(20) not null,"+
                "cliend varchar(60) not null);";
        db.execSQL(cliente);

        String produto = "create table if not exists produto("+
                "_proid integer primary key autoincrement,"+
                "prodesc varchar(60) not null,"+
                "proqtd varchar(20) not null,"+
                "provl varchar(60) not null);";
        db.execSQL(produto);

        String fornecedor = "create table if not exists fornecedor("+
                "_forid integer primary key autoincrement,"+
                "forcnpj varchar(60) not null,"+
                "forfone varchar(20) not null,"+
                "forrazao varchar(60) not null);";
        db.execSQL(fornecedor);

        String entregador = "create table if not exists entregador("+
                "_entrid integer primary key autoincrement,"+
                "entrnome varchar(60) not null,"+
                "entrfone varchar(20) not null);";
        db.execSQL(entregador);

        String pedido = "create table if not exists pedido("+
                "_pedid integer primary key autoincrement,"+
                "codprocod int not null,"+
                "codclicod int not null,"+
                "codentcod int not null);";
        db.execSQL(pedido);
        //select clinome,prodesc,valor from pedido inner join cliente on codclicod = _cliid inner join produti on codprocod = _proid
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
