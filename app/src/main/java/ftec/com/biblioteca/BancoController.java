package ftec.com.biblioteca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ftec.com.biblioteca.data.Biblioteca;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;
    public List<Biblioteca> dataSourceBiblioteca;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.TITULO, titulo);
        valores.put(CriaBanco.AUTOR, autor);
        valores.put(CriaBanco.EDITORA, editora);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        String sucesso = "Registro Inserido com sucesso";
        String falha = "Erro ao inserir registro";

        if (resultado ==-1)
            return falha;
        else
            return sucesso;
    }


    public List<Biblioteca> carregaDados(){

        dataSourceBiblioteca = new ArrayList<>();

        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULO, banco.AUTOR, banco.EDITORA};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();

            while (cursor.moveToNext()){
                //Integer id = (Integer) cursor.get(0);
                String titulo = cursor.getString(1);
                String autor = cursor.getString(2);
                String editora = cursor.getString(3);
                dataSourceBiblioteca.add(new Biblioteca(0, titulo, autor, editora));
            }
        }
        db.close();
        return dataSourceBiblioteca;
    }



}
