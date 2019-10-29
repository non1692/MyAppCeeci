package www.ceeci.mx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.Random;

public class NotifyActivity extends AppCompatActivity {

    private FloatingActionButton fb;

    private int drawer[] = {
            R.drawable.ic_ham1,
            R.drawable.ic_fruta,
            R.drawable.ic_helado,
            R.drawable.ic_pizza,
            R.drawable.ic_tarta,
            R.drawable.ic_postre
    };

    private int titulos[] = {
            R.string.titulo_1,
            R.string.titulo_2,
            R.string.titulo_3,
            R.string.titulo_4,
            R.string.titulo_5,
            R.string.titulo_6
    };
    private int posicion = 0;
    private int tit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);


        fb = findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        createNotifyBasic();
                    }
                }, 3000);
            }
        });

    }

    private void createNotifyBasic() {

        Uri uri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.sound_2);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);

        Intent myIntent = new Intent(this, MyIntensActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_ONE_SHOT);


        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(this, "CanalDefault");
        notificationCompat.setContentTitle(getString(R.string.titulo_notify));
        notificationCompat.setContentText(getString(R.string.txt_demo));
        notificationCompat.setSmallIcon(R.drawable.ic_notifications_white_24dp);
        notificationCompat.setContentIntent(pendingIntent);
        notificationCompat.setAutoCancel(false);

        notificationCompat.setLargeIcon(bitmap);
        notificationCompat.setStyle(myStyle());
        notificationCompat.setSound(uri);


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CanalDefault", "CanalNombre", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        manager.notify(idNotify(), notificationCompat.build());
    }

    private NotificationCompat.Style myStyle() {

        Random r = new Random();

        for (int i = 0; i < drawer.length; i++) {
            int img = r.nextInt(drawer.length);
            int t = r.nextInt(titulos.length);
            posicion = img;
            tit = t;
            break;
        }

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawer[posicion]);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle()
                .setBigContentTitle(getString(titulos[tit]))
                .setSummaryText(getString(R.string.txt_demo))
                .bigPicture(bitmap);

        return bigPictureStyle;
    }

    private int idNotify() {
        int idnotify = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        return idnotify;
    }
}
