package com.danito.datosdepozo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewsActivity extends AppCompatActivity {

    private TextView NombrePozo;
    private TextView DiametroBba;
    private TextView ProfundidadBBa;
    private TextView ProfundidadAncla;
    private TextView Varilla1;
    private TextView Varilla78;
    private TextView Varilla34;
    private TextView VarillaPeso;
    private Button Regresar;

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        NombrePozo = findViewById(R.id.NombrePozo);
        DiametroBba = findViewById(R.id.tvBbaD);
        ProfundidadBBa = findViewById(R.id.tvProfbba);
        ProfundidadAncla = findViewById(R.id.tvProfancla);
        Varilla1 = findViewById(R.id.tvVarilla1);
        Varilla78 = findViewById(R.id.tvVarilla78);
        Varilla34 = findViewById(R.id.tvVarilla34);
        VarillaPeso = findViewById(R.id.tvVarillapeso);
        Regresar = findViewById(R.id.btnRegresar);


        obtenerIntent();

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(ViewsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }



    private void obtenerIntent() {
        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        String pozo = extras.getString("pozo");
        String diametroBba = extras.getString("diametroBba");
        String profundidadBba = extras.getString("profundidadBba");
        String profundidadAncla = extras.getString("profundidadAncla");
        String varilla1 = extras.getString("varilla1");
        String varilla78 = extras.getString("varilla78");
        String varilla34 = extras.getString("varilla34");
        String varillaPeso = extras.getString("varillaPeso");

        NombrePozo.setText("El nombre de pozo es: "+ pozo);
        DiametroBba.setText("Diametro Bba: "+ Integer.parseInt(diametroBba));
        ProfundidadBBa.setText("Profundidad Bba: "+ Integer.parseInt(profundidadBba) * 3.2808399);
        ProfundidadAncla.setText("Profundidad Ancla: "+ Integer.parseInt(profundidadAncla)* 3.2808399);
        Varilla1.setText("Varillas de 1: "+ Integer.parseInt(varilla1) * 25);
        Varilla78.setText("Varillas de 7/8: "+ Integer.parseInt(varilla78) * 25);
        Varilla34.setText("Varillas de 3/4: "+ Integer.parseInt(varilla34) * 25);
        VarillaPeso.setText("Varillas de peso: "+ Integer.parseInt(varillaPeso) * 25);
    }

}