package com.danito.datosdepozo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText NombrePozo;
    private EditText TamanioBba;
    private EditText ProfundidadBba;
    private EditText ProfundidadAncla;
    private EditText Varilla1;
    private EditText Varilla78;
    private EditText Varilla34;
    private EditText VarillaPeso;
    private Button convertir;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Estás seguro de que quieres salir de la aplicación?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cierra la aplicación
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Permite al usuario volver a la actividad anterior o cancelar la acción de salida
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar();
        asignarPorId();
        limitarCantidadCaracteres();
       convertir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String nombrePozo = NombrePozo.getText().toString();
               String tamanioBba = TamanioBba.getText().toString();
               String profundidadBba = ProfundidadBba.getText().toString();
               String profundidadAncla = ProfundidadAncla.getText().toString();
               String varilla1 = Varilla1.getText().toString();
               String varilla78 = Varilla78.getText().toString();
               String varilla34 = Varilla34.getText().toString();
               String varillaPeso = VarillaPeso.getText().toString();

               if (camposVacios()) {
                   Toast.makeText(MainActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                   return;
               };

               Intent intent = new Intent(MainActivity.this, ViewsActivity.class);
               intent.putExtra("pozo", nombrePozo);
               intent.putExtra("diametroBba", tamanioBba);
               intent.putExtra("profundidadBba", profundidadBba);
               intent.putExtra("profundidadAncla", profundidadAncla);
               intent.putExtra("varilla1", varilla1);
               intent.putExtra("varilla78", varilla78);
               intent.putExtra("varilla34", varilla34);
               intent.putExtra("varillaPeso", varillaPeso);

               startActivity(intent);
               finish();
           }
       });
    }

    //crea una funcion para validar que los campos no esten vacios
    private boolean camposVacios() {
        return NombrePozo.getText().toString().isEmpty() ||
                TamanioBba.getText().toString().isEmpty() ||
                ProfundidadBba.getText().toString().isEmpty() ||
                ProfundidadAncla.getText().toString().isEmpty() ||
                Varilla1.getText().toString().isEmpty() ||
                Varilla78.getText().toString().isEmpty() ||
                Varilla34.getText().toString().isEmpty() ||
                VarillaPeso.getText().toString().isEmpty();
    };

    //funcion para limitar cantidad de caracteres en los campos
    private void limitarCantidadCaracteres() {
        NombrePozo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        TamanioBba.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        ProfundidadBba.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        ProfundidadAncla.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        Varilla1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        Varilla78.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        Varilla34.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        VarillaPeso.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        convertir.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        convertir.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        convertir.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
    }

    private void asignarPorId() {
            NombrePozo = findViewById(R.id.EtfPozo);
            TamanioBba = findViewById(R.id.EtfTamanioBba);
            ProfundidadBba = findViewById(R.id.EtfProfBba);
            ProfundidadAncla = findViewById(R.id.EtfProfAncla);
            Varilla1 = findViewById(R.id.EtfVarilla1);
            Varilla78 = findViewById(R.id.EtfVarilla78);
            Varilla34 = findViewById(R.id.EtfVarilla34);
            VarillaPeso = findViewById(R.id.EtfVarillaPeso);
            convertir = findViewById(R.id.Convertir);

    }

    public void toolbar(){
        // Configura la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Establece el título en la AppBar
        getSupportActionBar().setTitle("Datos de pozo");
    }
}