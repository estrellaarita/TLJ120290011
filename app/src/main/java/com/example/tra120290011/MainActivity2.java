package com.example.tra120290011;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText txtnombre, txtapellido;
    Button btnmostrar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtnombre=(EditText) findViewById(R.id.txtnombre);
        txtapellido=(EditText) findViewById(R.id.txtapellido);
        btnmostrar =(Button) findViewById(R.id.btnmostrar);

        btnmostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity2.this, txtnombre.getText()+"-"+txtapellido.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}