package com.example.jonathan.leccionrecuperacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editResultado;
    Button btnJugar;
    TextView textAciertosCottectos;
    private int contadorAciertosCorrectos = 0;
    private int contadorAciertosIncorrectos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAciertosCottectos = (TextView)findViewById(R.id.lblAciertos);
        editResultado = (EditText) findViewById(R.id.txtRespuesta);
        btnJugar = (Button) findViewById(R.id.btnResultado);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultadoTpm = "5";
                if(editResultado.getText().toString().equals(resultadoTpm)){
                    contadorAciertosCorrectos ++;
                    textAciertosCottectos.setText(String.valueOf(contadorAciertosCorrectos));
                    Log.w("RespuestaLog", "Respuestas Correctas: " + String.valueOf(contadorAciertosCorrectos));

                    mostrarNotificacion();
                    editResultado.setText("");

                    if(contadorAciertosCorrectos == 3){
                        Intent intent = new Intent(MainActivity.this, Respuestas_Activity.class);
                        intent.putExtra(Respuestas_Activity.aciertoCorrectos, String.valueOf(contadorAciertosCorrectos));
                        intent.putExtra(Respuestas_Activity.aciertoIncorrectos, String.valueOf( contadorAciertosIncorrectos));
                        startActivity(intent);
                    }

                }else {
                    contadorAciertosIncorrectos++;
                    Toast.makeText(MainActivity.this,"Acerto mal intente de nuevo", Toast.LENGTH_LONG);
                    editResultado.setText("");
                }
            }
        });





    }
    public void mostrarNotificacion(){
        NotificationCompat.Builder mBuilder;
        NotificationManager mNotifyMgr =(NotificationManager)
                getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        int icono = R.mipmap.ic_launcher;
        Intent intent = new Intent(MainActivity.this, Notifiacion_Activity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(MainActivity.this, 0,intent, 0);

        //mBuilder = new NotificationCompat.Builder(getApplicationContext());

        mBuilder =new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setContentTitle("Felicidades")
                .setContentText("Haz acertado correctamente")
                .setVibrate(new long[] {100, 250, 100, 500})
                .setAutoCancel(true);
        mNotifyMgr.notify(1, mBuilder.build());
    }
}
