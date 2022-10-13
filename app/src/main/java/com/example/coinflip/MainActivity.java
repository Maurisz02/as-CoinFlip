package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView fejKep;
    private Button irasBtn, fejBtn;
    private TextView dobText, gyozText, veszitText;
    private int fejViras, dob, gyoz, veszit;
    private Random rnd;
    private AlertDialog.Builder ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
    }

    private void addListeners(){

        fejBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fejViras = rnd.nextInt(2);
                dob++;
                if (fejViras == 1){
                    fejKep.setImageResource(R.drawable.heads);
                    gyoz++;
                    Toast.makeText(MainActivity.this, "Fej",Toast.LENGTH_SHORT).show();

                    if (dob == 5){
                        ab.setTitle("Vereség").create();
                        ab.show();
                    }else if(gyoz == 3){
                        ab.setTitle("Győzelem").create();
                        ab.show();
                    }
                }else {
                    fejKep.setImageResource(R.drawable.tails);
                    veszit++;
                    Toast.makeText(MainActivity.this, "Írás",Toast.LENGTH_SHORT).show();
                    if (dob == 5){
                        ab.setTitle("Vereség").create();
                        ab.show();
                    }
                }
                dobText.setText("Győzelem: " + String.valueOf(dob));
                gyozText.setText("Vereség: " + String.valueOf(gyoz));
                veszitText.setText("Dobások: " + String.valueOf(veszit));
            }
        });

        irasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fejViras = rnd.nextInt(2);
                dob++;
                if (fejViras == 1)
                {
                    fejKep.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "Fej", Toast.LENGTH_SHORT).show();
                    veszit++;
                    if (dob == 5)
                    {
                        ab.show();
                    }
                }
                else
                {
                    fejKep.setImageResource(R.drawable.tails);
                    gyoz++;
                    Toast.makeText(MainActivity.this, "Iras", Toast.LENGTH_SHORT).show();
                    if (dob == 5)
                    {
                        ab.setTitle("Vereség").create();
                        ab.show();
                    }
                    else if(gyoz == 3)
                    {
                        ab.setTitle("Győzelem").create();
                        ab.show();
                    }
                }
                dobText.setText("Győzelem: " + String.valueOf(dob));
                gyozText.setText("Vereség: " + String.valueOf(gyoz));
                veszitText.setText("Dobások: " + String.valueOf(veszit));
            }


        });

    }

    private void ujJatek(){

        dob = 0;
        gyoz = 0;
        veszit = 0;
        dobText.setText("Győzelem: " + String.valueOf(dob));
        gyozText.setText("Vereség: " + String.valueOf(gyoz));
        veszitText.setText("Dobások: " + String.valueOf(veszit));
    }

    private void init(){
        fejKep = findViewById(R.id.fejKep);
        irasBtn = findViewById(R.id.irasBtn);
        fejBtn = findViewById(R.id.fejBtn);
        dobText = findViewById(R.id.dobText);
        gyozText = findViewById(R.id.gyozText);
        veszitText = findViewById(R.id.veszitText);
        fejViras = 0;
        dob = 0;
        gyoz = 0;
        veszit = 0;

        ab = new AlertDialog.Builder(MainActivity.this);
        ab.setCancelable(false)
                .setTitle("Jatek Vege")
                .setMessage("Uj Jatek?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                }).create();
    }
}