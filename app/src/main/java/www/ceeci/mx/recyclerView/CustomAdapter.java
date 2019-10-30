package www.ceeci.mx.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import www.ceeci.mx.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<Model> list;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model item;
        item = list.get(position);
        // Imagen
        holder.imv_foto.setImageResource(item.getImg());

        // Textos
        holder.tv_titulo.setText(item.getTitulo());
        holder.tv_descripcion.setText(item.getDes());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imv_foto;
        TextView tv_titulo, tv_descripcion;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            // ImageView
            imv_foto = itemView.findViewById(R.id.imv_foto);

            // TexView
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_descripcion = itemView.findViewById(R.id.tv_descripcion);

        }
    }
}
