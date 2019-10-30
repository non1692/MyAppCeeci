package www.ceeci.mx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomSheetActivity extends AppCompatActivity {


    private static final String TAG = "BottomSheetActivityApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        FloatingActionButton fb = findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                BottomSheetFragmen bottomSheetFragmen = new BottomSheetFragmen();
                bottomSheetFragmen.show(getSupportFragmentManager(), bottomSheetFragmen.getTag());
            }
        });
    }
}
