package www.ceeci.mx;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "LoginActivityApp";
    private ImageView imv_logo;
    private EditText editEmail;
    private EditText editPass;
    private Button btn_iniciar, btn_test;

    private String url = "https://www.trzcacak.rs/myfile/full/1-17160_eagle-sports-png-logos-eagle-logo-png.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // ImageView
        imv_logo = findViewById(R.id.imv_logo);

        // Editext
        editEmail = findViewById(R.id.editEmail);
        editPass = findViewById(R.id.editPass);


        // Button
        btn_iniciar = findViewById(R.id.btn_iniciar);
        btn_test = findViewById(R.id.btn_test);

        loadImage();

        btn_iniciar.setOnClickListener(this);
        btn_test.setOnClickListener(this);

    }

    private void obtenerDatos() {

        String email = "";
        email = editEmail.getText().toString();

        String pass = "";
        pass = editPass.getText().toString();

        Log.d(TAG, "obtenerDatos:email " + email);
        Log.d(TAG, "obtenerDatos:pass " + pass);

        Intent myIntent = new Intent(this, DetalleActivity.class);
        Bundle b = new Bundle();
        b.putString("txt_email", email);
        b.putString("txt_pass", pass);
        myIntent.putExtras(b);
        startActivity(myIntent);

    }

    private void showToast() {
        Toast.makeText(this, "Mensaje Toast", Toast.LENGTH_LONG).show();
    }

    /**
     * Metodo encargado de imagen
     * Libreria Glide
     */
    private void loadImage() {
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imv_logo);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_iniciar:
                obtenerDatos();
                break;

            case R.id.btn_test:
                showToast();
                break;
        }
    }
}
