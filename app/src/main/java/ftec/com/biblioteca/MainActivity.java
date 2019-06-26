package ftec.com.biblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ftec.com.biblioteca.Adapter.BibliotecaAdapter;
import ftec.com.biblioteca.data.Biblioteca;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button cadastrarButton;

    private RecyclerView recyclerView;

    private EditText tituloEditText;
    private EditText autorEditText;
    private EditText editoraEditText;

    private List<Biblioteca> dataSourceBiblioteca;
    private BibliotecaAdapter bibliotecaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrarButton = findViewById(R.id.activity_main_cadastrar_button);
        cadastrarButton.setOnClickListener(this);

        recyclerView = findViewById(R.id.activity_principal_recycler_view);

        tituloEditText = findViewById(R.id.activity_main_titulo_editText);
        autorEditText = findViewById((R.id.activity_main_autor_editText));
        editoraEditText = findViewById(R.id.activity_main_editora_editText);


        recarregar();




    }


    public void recarregar(){

        BancoController b = new BancoController(this);
        dataSourceBiblioteca = b.carregaDados();

        bibliotecaAdapter = new BibliotecaAdapter(dataSourceBiblioteca);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(bibliotecaAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public void onClick(View v) {

        if (v==cadastrarButton){
            String tituloString = tituloEditText.getText().toString();
            String autorString = autorEditText.getText().toString();
            String editoraString = editoraEditText.getText().toString();

            String resultado;

            BancoController bc = new BancoController(this);

            resultado = bc.insereDado(tituloString,autorString,editoraString);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            recarregar();

        }

    }
}
