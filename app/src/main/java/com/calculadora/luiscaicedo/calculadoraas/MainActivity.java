package com.calculadora.luiscaicedo.calculadoraas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etPantalla;

    enum Operacion{
        Suma,
        Resta
    }

    String numeroDigitado = "0";
    String numeroA;
    String numeroB;
    String resultado;
    Operacion operacion;
    boolean estaOperando;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_constrain);
        etPantalla = (EditText)findViewById(R.id.etPantallaC);
        //setContentView(R.layout.activity_linear);
        //etPantalla = (EditText)findViewById(R.id.etPantallaL);

    }

    public void OnButton7Click(View view) {
        digitar("7");
    }

    public void OnButton8Click(View view) {
        digitar("8");
    }

    public void OnButton9Click(View view) {
        digitar("9");
    }

    public void OnButton4Click(View view) {
        digitar("4");
    }

    public void OnButton6Click(View view) {
        digitar("6");
    }

    public void OnButton5Click(View view) {
        digitar("5");
    }

    public void OnButton1Click(View view) {
        digitar("1");
    }

    public void OnButton2Click(View view) {
        digitar("2");
    }

    public void OnButton3Click(View view) {
        digitar("3");
    }

    public void OnButton0Click(View view) {
        digitar("0");
    }

    public void OnButtonMasClick(View view) {

        definirOperacion(Operacion.Suma);
    }

    public void OnButtonMenosClick(View view) {

        definirOperacion(Operacion.Resta);
    }

    public void OnButtonIgualClick(View view) {
        if(estaOperando){
            estaOperando=false;
            numeroB = numeroDigitado;
            resultado = operar();
            numeroDigitado=resultado;
            mostrarEnPantalla(numeroDigitado);
        }
    }

    private void digitar(String digito){

        if(numeroDigitado == "0"){
            numeroDigitado = digito;
        }
        else
        {
            numeroDigitado += digito;
        }

        mostrarEnPantalla(numeroDigitado);
    }

    private void mostrarEnPantalla(String textoAMostrar){

        etPantalla.setText(textoAMostrar);
    }

    private void definirOperacion(Operacion operacionARealizar){

        if(!estaOperando){
            estaOperando = true;
            operacion = operacionARealizar;
            numeroA= numeroDigitado;
            numeroDigitado="0";
            mostrarEnPantalla(numeroDigitado);
        }
        else {

            numeroB = numeroDigitado;
            resultado= operar();
            mostrarEnPantalla(resultado);
            numeroA= resultado;
            numeroDigitado= "0";
            estaOperando=true;
            operacion= operacionARealizar;
        }
    }

    private String operar(){
        int numA= Integer.parseInt(numeroA);
        int numB = Integer.parseInt(numeroB);
        int result = 0;

        if(operacion == Operacion.Suma){
            result= numA+numB;
        }
        else
            if(operacion == Operacion.Resta){
                result = numA-numB;
            }

        return String.valueOf(result);
    }
}
