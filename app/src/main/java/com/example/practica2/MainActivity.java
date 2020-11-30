package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button button;
    EditText nombre1;
    EditText apellido1;
    EditText edad1;
    String value;
    int i;
Button button2;
    Spinner spinner;
String sexoEstado;
String mayordeEdad;
String estadoCivilSpinner;
String hijos;
Switch switchHijos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);




    }



    public void onClick(View v)
            {

                nombre1 = (EditText)findViewById(R.id.editTextTextNombre);
                 apellido1 = (EditText)findViewById(R.id.editTextapellidos);
                 edad1 = (EditText)findViewById(R.id.editTextEdad);
                value= edad1.getText().toString();
                TextView etiqueta1 = (TextView)findViewById(R.id.etiqueta);

                RadioButton maleRadioButton = (RadioButton) findViewById(R.id.Hombre);
                RadioButton femaleRadioButton = (RadioButton) findViewById(R.id.Mujer);
                spinner = (Spinner) findViewById(R.id.desplegable);
                estadoCivilSpinner= (String) spinner.getSelectedItem();
                switchHijos = (Switch) findViewById(R.id.switch1);
                switch (v.getId()) {

                    case R.id.button:
                        if(switchHijos.isChecked()){
                            hijos=getString(R.string.conHijos);
                        }
                        else{
                            hijos=getString(R.string.sinHijos);
                        }




                        if (maleRadioButton.isChecked()) {
                            if (estadoCivilSpinner.equals("Solter@")) {
                                sexoEstado =getString(R.string.hombreSoltero);

                            }
                            if (estadoCivilSpinner.equals("Casad@")) {
                                sexoEstado =getString(R.string.hombreCasado);

                            }
                            if (estadoCivilSpinner.equals("Separad@")) {
                                sexoEstado =getString(R.string.hombreSeparado);

                            }
                            if (estadoCivilSpinner.equals("Viud@")) {
                                sexoEstado =getString(R.string.hombreViudo);

                            }
                            if (estadoCivilSpinner.equals("Otro")) {
                                sexoEstado =getString(R.string.hombre);

                            }

                        }
                        else if(femaleRadioButton.isChecked()) {
                            if (estadoCivilSpinner.equals("Solter@")) {
                                sexoEstado =getString(R.string.mujerSoltera);

                            }
                            if (estadoCivilSpinner.equals("Casad@")) {
                                sexoEstado =getString(R.string.mujerCasada);

                            }
                            if (estadoCivilSpinner.equals("Separad@")) {
                                sexoEstado =getString(R.string.mujerSeparada);

                            }
                            if (estadoCivilSpinner.equals("Viud@")) {
                                sexoEstado =getString(R.string.mujerViuda);

                            }
                            if (estadoCivilSpinner.equals("Otro")) {
                                sexoEstado =getString(R.string.mujer);

                            }


                        }

                        if(!edad1.getText().toString().equals("")){
                            i=Integer.parseInt(value);
                            if(i>=18) {
                                mayordeEdad=getString(R.string.mayorEdad);

                            }
                            else {
                                mayordeEdad = getString(R.string.menorEdad);
                            }}




                        if(nombre1.getText().toString().equals("") && !apellido1.getText().toString().equals("") && (!value.equals("")||value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaNombre));

                        }
                        else if(nombre1.getText().toString().equals("") && apellido1.getText().toString().equals("") && (value.equals("")||value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaNombreApellidoEdad));

                        }
                        else if(nombre1.getText().toString().equals("") && apellido1.getText().toString().equals("") && (!value.equals("")||!value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaNombreApellido));

                        }
                        else if(nombre1.getText().toString().equals("") && !apellido1.getText().toString().equals("") && (value.equals("")||value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaNombreEdad));

                        }
                        else if(!nombre1.getText().toString().equals("") && apellido1.getText().toString().equals("") && (value.equals("")||value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaEdadApellido));

                        }
                        else  if(!nombre1.getText().toString().equals("") && !apellido1.getText().toString().equals("") && (value.equals("")||value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaEdad));
                        }
                        else if(!nombre1.getText().toString().equals("") && apellido1.getText().toString().equals("") && (!value.equals("")||!value.equals("0"))){
                            etiqueta1.setText(getString(R.string.faltaApellido));
                        }
                        else {
                            etiqueta1.setText("");
                            Toast.makeText(MainActivity.this, nombre1.getText().toString() + " " + apellido1.getText().toString() + " ," + sexoEstado + " " + mayordeEdad + " " + hijos, Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.button2:
                        nombre1.setText("");
                        apellido1.setText("");
                        edad1.setText("");
                        switchHijos.setChecked(false);
                        femaleRadioButton.setChecked(false);
                        maleRadioButton.setChecked(false);
                        spinner.setSelection(4);


                        break;



                    default:
                        break;
                }


        }}


