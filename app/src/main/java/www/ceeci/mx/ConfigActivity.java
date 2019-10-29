package www.ceeci.mx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputEditText;

public class ConfigActivity extends AppCompatActivity {


    private static final String TAG = "ConfigActivity";
    private TextInputEditText txt_inpu;
    private Button btn_accion, btn_status;


    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);


        txt_inpu = findViewById(R.id.txt_inpu);
        btn_accion = findViewById(R.id.btn_accion);
        btn_status = findViewById(R.id.btn_status);

        switch1 = findViewById(R.id.switch1);

        btn_accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String valor = txt_inpu.getText().toString();
                Log.d(TAG, "onClick: " + valor);
                Intent returnIntet = new Intent();
                returnIntet.putExtra("result", valor);
                setResult(Activity.RESULT_OK, returnIntet);
                finish();


            }
        });

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean valor;
                valor = switch1.isChecked();

                Intent returnIntet = new Intent();
                returnIntet.putExtra("result", valor);
                setResult(Activity.RESULT_OK, returnIntet);
                finish();

            }
        });

    }
}
