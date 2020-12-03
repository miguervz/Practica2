package com.example.practica2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
    Configuration config= new Configuration();
Button btnIdiomas;
Locale traducir;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btnIdiomas= findViewById(R.id.buttonIdiomas);
btnIdiomas.setOnClickListener(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);




    }



    public void onClick(View v)
            {

                nombre1 = findViewById(R.id.editTextTextNombre);
                 apellido1 = findViewById(R.id.editTextapellidos);
                 edad1 = findViewById(R.id.editTextEdad);
                value= edad1.getText().toString();
                TextView etiqueta1 = findViewById(R.id.etiqueta);

                RadioButton maleRadioButton =  findViewById(R.id.Hombre);
                RadioButton femaleRadioButton =  findViewById(R.id.Mujer);
                spinner =  findViewById(R.id.desplegable);
                estadoCivilSpinner= (String) spinner.getSelectedItem();
                switchHijos =  findViewById(R.id.switch1);
                switch (v.getId()) {

                    case R.id.button:
                        if(switchHijos.isChecked()){
                            hijos=getString(R.string.conHijos);
                        }
                        else{
                            hijos=getString(R.string.sinHijos);
                        }




                        if (maleRadioButton.isChecked()) {
                            if (spinner.getSelectedItemPosition()==0) {
                                sexoEstado =getString(R.string.hombreSoltero);

                            }
                           else if (spinner.getSelectedItemPosition()==1) {
                                sexoEstado =getString(R.string.hombreCasado);

                            }
                       else   if (spinner.getSelectedItemPosition()==2) {
                                sexoEstado =getString(R.string.hombreSeparado);

                            }
                           else if (spinner.getSelectedItemPosition()==3) {
                                sexoEstado =getString(R.string.hombreViudo);

                            }
                            else if (spinner.getSelectedItemPosition()==4){
                                sexoEstado =getString(R.string.hombre);

                            }

                        }
                        else if(femaleRadioButton.isChecked()) {
                            if (spinner.getSelectedItemPosition()==0) {
                                sexoEstado =getString(R.string.mujerSoltera);

                            }
                            else if (spinner.getSelectedItemPosition()==1) {
                                sexoEstado =getString(R.string.mujerCasada);

                            }
                          else   if (spinner.getSelectedItemPosition()==2) {
                                sexoEstado =getString(R.string.mujerSeparada);

                            }
                            else if (spinner.getSelectedItemPosition()==3) {
                                sexoEstado =getString(R.string.mujerViuda);

                            }
                           else if (spinner.getSelectedItemPosition()==4) {
                                sexoEstado =getString(R.string.mujer);

                            }


                        }
                        else{

                              if (spinner.getSelectedItemPosition()==0) {
                               sexoEstado =getString(R.string.personaSoltera);

                                  }
                             else if (spinner.getSelectedItemPosition()==1) {
                              sexoEstado =getString(R.string.personaCasda);

                                }
                             else   if (spinner.getSelectedItemPosition()==2) {
                            sexoEstado =getString(R.string.personaDivorciada);

                                 }
                            else if (spinner.getSelectedItemPosition()==3) {
                                sexoEstado =getString(R.string.personaViuda);

                            }
                           else if (spinner.getSelectedItemPosition()==4) {
                            sexoEstado ="";

                        }                          }

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

                if (v.getId() == (R.id.buttonIdiomas))
                {
                    showDialog();
                }

        }

    private void showDialog()
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.buttonIdiomas));

        //obtiene los idiomas del array de string.xml
        String[] types = getResources().getStringArray(R.array.lenguajes);
        b.setItems(types, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                switch (which)
                {

                    case 0:
                        traducir = new Locale("es");
                        config.locale = traducir;
                        break;
                    case 1:
                        traducir = new Locale("en");
                        config.locale = traducir;

                        break;
                    case 2:
                        traducir = new Locale("pt");
                        config.locale = traducir;
                        break;

                }

                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                Locale.setDefault(traducir);
                startActivity(refresh);
                finish();
            }

        });

        b.show();

    }

}


