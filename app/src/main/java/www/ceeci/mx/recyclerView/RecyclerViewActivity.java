package www.ceeci.mx.recyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import www.ceeci.mx.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Model> lista;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        customAdapter = new CustomAdapter(this, lista);
        recyclerView.setAdapter(customAdapter);

        cargarValores();

    }

    private void cargarValores() {

        lista.add(new Model(0, "CardView Uno", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto.", R.drawable.ic_fruta));
        lista.add(new Model(1, "CardView dos", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto.", R.drawable.ic_helado));
        lista.add(new Model(2, "CardView Tres", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto.", R.drawable.ic_malteada));

        customAdapter.notifyDataSetChanged();

    }

}
