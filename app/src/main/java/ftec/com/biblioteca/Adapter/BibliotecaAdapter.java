package ftec.com.biblioteca.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ftec.com.biblioteca.R;
import ftec.com.biblioteca.data.Biblioteca;

public class BibliotecaAdapter extends RecyclerView.Adapter<BibliotecaAdapter.bibliotecaItemViewHolder> {


    private List<Biblioteca> datasourceBiblioteca;

    // Recebe o datasource como parâmetro do contrutor que será chamado pela Activity que irá instanciar o Adapter
    public BibliotecaAdapter(List<Biblioteca> datasourceBtc)  {this.datasourceBiblioteca = datasourceBtc; }

    @NonNull
    @Override
    public bibliotecaItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_inflate_biblioteca, viewGroup, false);
        return new bibliotecaItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bibliotecaItemViewHolder bibliotecaItemViewHolder, int i) {
        bibliotecaItemViewHolder.fillBtcOrdens(datasourceBiblioteca.get(i));

    }

    @Override
    public int getItemCount() {
        return datasourceBiblioteca.size();
    }


    public final static class bibliotecaItemViewHolder extends RecyclerView.ViewHolder {

        private TextView idTextView;
        private TextView tituloTextView;
        private TextView autorTextView;
        private TextView editoraTextView;

        public bibliotecaItemViewHolder(@NonNull View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.row_id_textView);
            tituloTextView = itemView.findViewById(R.id.row_titulo_textView);
            autorTextView = itemView.findViewById(R.id.row_autor_textView);
            editoraTextView = itemView.findViewById(R.id.row_editora_textView);
        }


        private void fillBtcOrdens(Biblioteca biblioteca){
           // idTextView.setText("ID: "+ biblioteca.getId());
            tituloTextView.setText("TITULO: "+ biblioteca.getTitulo());
            autorTextView.setText("AUTOR: "+ biblioteca.getAutor());
            editoraTextView.setText("EDITORA: "+ biblioteca.getEditora());
        }




    }















}
