package www.ceeci.mx;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MyIntensActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MyIntensActivity";
    private static final int CODE_INTENT_1 = 1;
    private static final int CODE_INTENT_2 = 2;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;

    private  Button btn_intent_1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intens);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);


        btn_intent_1 = findViewById(R.id.btn_intent_1);


        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);


        btn_intent_1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                //Toast.makeText(this, "Boton 1", Toast.LENGTH_SHORT).show();
                //alertPersonalizado();
                iraConfiguracion();
                break;
            case R.id.btn_2:
                //Toast.makeText(this, "Boton 2", Toast.LENGTH_SHORT).show();
                //alertBasico();
                //intentTextoPlano();

                intentImagen();
                break;

            case R.id.btn_3:
                alertMulti();
                break;

            case R.id.btn_4:
                alertLista();
                break;

            case R.id.btn_5:
                //alert();
                intenteCode2();
                break;

            case R.id.btn_intent_1:
                intenteCode1();
                break;
        }
    }

    private void intentImagen() {

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.ic_ham1);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        String path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "", "");
        Uri uri = Uri.parse(path);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Titulo texto plano");
        intent.putExtra(Intent.EXTRA_TEXT, "Mesanje de texto Plano");
        startActivity(Intent.createChooser(intent, "Compartir"));

    }

    private void intentTextoPlano() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Titulo texto plano");
        intent.putExtra(Intent.EXTRA_TEXT, "Mesanje de texto Plano");
        startActivity(Intent.createChooser(intent, "Compartir"));

    }

    private void iraConfiguracion() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", MyIntensActivity.this.getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

    private void alertBasico() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.titulo_alert);
        builder.setMessage(R.string.mensaje_alert);
        builder.setIcon(R.drawable.ic_error_outline_black_24dp);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    private void alertMulti() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.titulo_alert_multi);

        String[] animales = {"Gato", "Perro", "Vaca", "Caballo", "Burro"};
        boolean[] check = {false, false, false, false, false};

        builder.setMultiChoiceItems(animales, check, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Log.d(TAG, "onClick: ");
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void alertLista() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleciona tu país");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("México");
        arrayAdapter.add("Canada");
        arrayAdapter.add("Alemania");
        arrayAdapter.add("Argentina");

        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "onClick: " + arrayAdapter.getItem(which));
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void alertPersonalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.titulo_alert_person);
        builder.setMessage(R.string.mensaje_alert_person);
        builder.setIcon(R.drawable.ic_error_outline_black_24dp);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyIntensActivity.this, "Haz presionado el boton aceptar", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyIntensActivity.this, "Haz presionado el boton cancelar", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNeutralButton("Neuntro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }

    private void alert() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater layoutInflater = this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.alert_custom, null);

        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(true);

        final Button btn_alert_cerrar = dialogView.findViewById(R.id.btn_alert_cerrar);
        final TextView tv_contenido = dialogView.findViewById(R.id.tv_contenido);

        tv_contenido.setText("jsjnsjnjss");
        btn_alert_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                //tv_contenido.setText("Esta cerrando el AlertDialog");
                alertDialog.dismiss();
            }
        });
        alertDialog.show();

    }


    private void intenteCode1() {

        Intent myIntent = new Intent(MyIntensActivity.this, ConfigActivity.class);
        startActivityForResult(myIntent, CODE_INTENT_1);

    }


    private void intenteCode2() {

        Intent myIntent = new Intent(MyIntensActivity.this, ConfigActivity.class);
        startActivityForResult(myIntent, CODE_INTENT_2);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == CODE_INTENT_1){

                assert data != null;
                String result = data.getStringExtra("result");

                Toast.makeText(this, "" + result, Toast.LENGTH_LONG).show();

            } else if (requestCode == CODE_INTENT_2){
                assert data != null;
                boolean result = data.getBooleanExtra("result", false);
                Log.d(TAG, "onActivityResult: " + result);
                
                String texto;
                if (result){
                    texto = "Notificacion Activada";
                }else {
                    texto = "Notificacion Desactivada";
                }
                Toast.makeText(this, "" + texto, Toast.LENGTH_LONG).show();
            }
        }
    }
}
