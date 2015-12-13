package fucapi.br.pizzaria.conexao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fernando on 12/12/15.
 */
public class Conexao extends SQLiteOpenHelper {

    private static final String banco = "pizzaria";
    private static final int VERSION = 8;

    public Conexao(Context context){
        super(context,banco,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String usuario = "create table if not exists usuario("+
                "_usuid integer primary key autoincrement,"+
                "usunome varchar(60)not null,"+
                "ususenha varchar(20) not null,"+
                "usuemail varchar(60) not null,"+
                "usutipo varchar(60) not null);";
        db.execSQL(usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
