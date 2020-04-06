package com.example.appmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView tvBienvenida;
    EditText etUsuario, etContrasenna;
    Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBienvenida = (TextView) findViewById(R.id.textBienvenida);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasenna = (EditText) findViewById(R.id.etContrasenna);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }){

        }


    }

    public void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"OPERACION CORRECTA",Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String>  getParams() throws AuthFailureError{
                Map<String, String> parametros = new HashMap<String,String>();
                parametros.put("Usuario", etUsuario.getText().toString());
                parametros.put("Contraseña", etContrasenna.getText().toString());
                return parametros;
            }
        };

        RequestQueue RequestQueue = Volley.newRequestQueue(this);
        RequestQueue.add(stringRequest);

    }


}