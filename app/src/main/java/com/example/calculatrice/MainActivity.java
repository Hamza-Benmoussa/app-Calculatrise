package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int val1=0;
    private int val2=0;
    private String operation="";
    private boolean isop=true;
    private TextView ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch=findViewById(R.id.textView);
    }
    private void afficher(){
        if(!isop){
            ch.setText(String.valueOf(val1)+" "+operation+" "+String.valueOf(val2));
        }
        else {
            ch.setText(String.valueOf(val1));
        }
    }

    public void ajouterChifre(View v) {
        int val=Integer.parseInt(((Button)v).getText().toString());
        if(isop){
            val1=val1*10+val;
            afficher();
        }
        else {
            val2=val2*10+val;
            afficher();
        }
    }

    public void setOperator(View v) {
        switch (v.getId()){
            case R.id.bu_mo:operation = "-";break;
            case R.id.bu_div:operation = "/";break;
            case R.id.bu_plus:operation = "+";break;
            case R.id.bu_foi:operation = "*";break;
            default:return;
        }
        isop=false;
        afficher();

    }

    public void rest(View view) {
    val1=0;val2=0;operation="";
    isop=true;
    afficher();

    }

    public void Calculer(View view) {
        if(!isop){
            switch (operation){
                case "+":val1=val1+val2;break;
                case "-":val1=val1-val2;break;
                case "/":val1=val1/val2;break;
                case "*":val1=val1*val2;break;
                default:return;
            }
            isop=true;
            val2=0;
            afficher();
        }
    }
}