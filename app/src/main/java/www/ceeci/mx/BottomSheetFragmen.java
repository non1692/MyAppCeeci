package www.ceeci.mx;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragmen extends BottomSheetDialogFragment {


    private TextView tv_titulo;
    private ImageView imv_bottom;
    private Button btn_bottom;

    private ConstraintLayout constra_encabezado;

    public BottomSheetFragmen() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);

        tv_titulo = view.findViewById(R.id.tv_titulo);
        imv_bottom = view.findViewById(R.id.imv_bottom);
        btn_bottom = view.findViewById(R.id.btn_bottom);
        constra_encabezado = view.findViewById(R.id.constra_encabezado);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_postre);
        imv_bottom.setImageBitmap(bitmap);

        crearPaletaAsyc(bitmap);

        return view;
    }

    private void crearPaletaAsyc(Bitmap bitmap) {

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette p) {
                Palette.Swatch swatch = p.getDominantSwatch();
                if (swatch != null){
                    int color = swatch.getRgb();
                    btn_bottom.setBackgroundColor(color);
                }

                Palette.Swatch swatch1 = p.getDarkMutedSwatch();
                if (swatch1 != null){
                    int color = swatch1.getRgb();
                    constra_encabezado.setBackgroundColor(color);
                }
            }
        });


    }
}
