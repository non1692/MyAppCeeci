package www.ceeci.mx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DetalleActivityApp";
    private String email;
    private String pass;

    private TextView tv_email;
    private TextView tv_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Bundle b = this.getIntent().getExtras();
        if (b != null){
            email = b.getString("txt_email");
            pass = b.getString("txt_pass");
        }

        tv_email = findViewById(R.id.tv_email);
        tv_pass = findViewById(R.id.tv_pass);

        loadDatos();

        Log.d(TAG, "onCreate:email " + email);
        Log.d(TAG, "onCreate:pass " + pass);

        tv_pass.setOnClickListener(this);

    }

    private void loadDatos() {

        tv_email.setText(""+email);
        tv_pass.setText(""+pass);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_pass:
                finish();
                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
