package com.example.jonathan.leccionrecuperacion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Respuestas_Activity extends AppCompatActivity {
    public static final String aciertoCorrectos = "aciertosCorrectos";
    public static final String aciertoIncorrectos = "aciertosIncorrectos";

    private TextView textCorrectos;
    private TextView textIncorrectos;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);

        textCorrectos = (TextView) findViewById(R.id.txtContadorCorrectas);
        textIncorrectos = (TextView) findViewById(R.id.txtContadorIncorrectas);
        String correctosTmp = String.valueOf( getIntent().getStringExtra("aciertosCorrectos"));
        String inCorrectosTmp =String.valueOf( getIntent().getStringExtra("aciertosIncorrectos"));

        textIncorrectos.setText(inCorrectosTmp);
        textCorrectos.setText(correctosTmp);

    }
}
