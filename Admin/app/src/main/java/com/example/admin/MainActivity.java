package com.example.admin;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    Button in, out, rein, salir, manual, inst;
    TextView info, num;

    private RequestQueue queue;

    int cuposTotales=178;    // Escribir el numero total de cupos del parqueadero
    int aux=0, tam=40, cuposActuales;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inst = findViewById(R.id.button5);

        in = findViewById(R.id.button);
        out = findViewById(R.id.button2);
        rein = findViewById(R.id.button4);
        salir = findViewById(R.id.button3);
        manual = findViewById(R.id.button5);
        info = findViewById(R.id.textView);
        num = findViewById(R.id.textView3);


        in.setText(R.string.IN);            in.setTextSize(tam);
        out.setText(R.string.OUT);          out.setTextSize(tam);
        rein.setText(R.string.reinicio);    rein.setTextSize(20);
        salir.setText(R.string.salir);      salir.setTextSize(20);
        manual.setText(R.string.manual);    manual.setTextSize(20);

        info.setTextSize(tam-10);
        num.setTextSize(tam-10);

        queue = Volley.newRequestQueue(this);   // Inicializamos el queue


        String url2 = "https://api.thingspeak.com/channels/1530086/feeds.json?api_key=7N2I61NM0G5W3BEE&results=2";
        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONObject response) {       // Se llegó a la URL y se obtuvieron los datos
                try {
                    JSONArray feeds = response.getJSONArray("feeds");
                    JSONObject datos = feeds.getJSONObject(1);
                    String Lastadmin = datos.getString("field1");
                    cuposActuales = Integer.parseInt(Lastadmin);
                    info.setText(R.string.cupos);
                    num.setText("" +cuposActuales);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }
        );

        queue.add(request2);

        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder instrucciones = new AlertDialog.Builder(MainActivity.this);
                instrucciones.setMessage(R.string.ins1);
                instrucciones.setCancelable(true);
                instrucciones.setPositiveButton("Entiendo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog titulo = instrucciones.create();
                titulo.setTitle(R.string.INS);
                titulo.show();
            }
        });
    }

    // Para hacer la suma o resta de la cantidad de cupos totales
    private void cupos(){
        cuposActuales+=aux;
        if(cuposActuales>cuposTotales){ cuposActuales=cuposTotales; }
        if(cuposActuales<0){ cuposActuales=0; }
        postDatos();
        MostrarDatos();
        aux=0;
    }

    public void onClickReiniciar(View view){
        cuposActuales=cuposTotales; aux=0; cupos();
    }

    // Al entrar un vehiculo se debe restar un cupo en los totales
    public void onClickEntrada(View view){
        aux=-1; cupos();
    }

    // Al salir un vehiculo se debe sumar un cupo en los totales
    public void onClickSalida(View view){
        aux=1; cupos();
    }

    @SuppressLint("SetTextI18n")
    private void postDatos(){

//        String url = "https://api.thingspeak.com/channels/1524993/feeds.json?api_key=DTJ2H6PCR7AKP38I&results=2";       // Feed
        String url = "https://api.thingspeak.com/update?api_key=RUN1MXD59ASFXPXM&field1="+cuposActuales;    // Field1
//        String url2 = "https://api.thingspeak.com/channels/1524993/fields/2.json?api_key=DTJ2H6PCR7AKP38I&results=2";    // Field1
        // Donde se le pasa la URL del API a leer

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(MainActivity.this, "CONECTADO", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // En el argumento del new JsonOR se debe colocar el metodo http request
        // en este caso GET, ademas de la URL del sitio que deseamos

        queue.add(request);
    }

    @SuppressLint("SetTextI18n")
    private void MostrarDatos(){
        info.setText(R.string.cupos);
        num.setText("" +cuposActuales);
    }

    public void salir(View view){
        finish();
    }

}