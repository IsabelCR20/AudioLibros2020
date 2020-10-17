package com.isa.audiolibros2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecycler;
    RecyclerView.LayoutManager lmana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelectorFragment selectorFrag = new SelectorFragment();         //Validación. Buscar si dentro de la actividad hay un elemento llamado contenedor pequeno
        if (findViewById(R.id.frmContenedor_pequeno) != null &&                             //Si existe, está en la pantalla para smarthphone
            getSupportFragmentManager().findFragmentById
                    (R.id.frmContenedor_pequeno) == null){

                getSupportFragmentManager().beginTransaction()                  //Indica que se comenzará a usar fragmentos en la actividad
                        .add(R.id.frmContenedor_pequeno, selectorFrag)          //Agregar un fragmento en contenedor pequeño, indicando cual es. toma el mismo id de su padre
                        .commit();
        }
    }

    public void mostrarDetalle(int index){                                  // índic de elemento a mostrar
        FragmentManager fm = getSupportFragmentManager();                   //validar en que tamaño de pantalla se está
        if(fm.findFragmentById(R.id.detalle_fragment) != null){             // Si encuentra fragmento, está cargado en la pantalla grande
            DetalleFragment detalleFrag = (DetalleFragment)
                    fm.findFragmentById(R.id.detalle_fragment);
            detalleFrag.ponInfoLibro(index);

        } else {                                                            //Si no lo encuentra, está en pantalla chica
            DetalleFragment detalleFrag = new DetalleFragment();
            Bundle miBundle = new Bundle();                                 // Crea un colección de elementos clave-valor
            miBundle.putInt(DetalleFragment.ARG_ID_LIBRO, index);
            detalleFrag.setArguments(miBundle);

            fm.beginTransaction()                                           // iniciar transacción
                    .replace(R.id.frmContenedor_pequeno, detalleFrag)       // reempleaza el fragmento mostrado en la interfaz
                    .addToBackStack(null)                                   // se agrega a la pila de regreso
                    .commit();
        }
    }
}


/*Dentor del onCreate
            lmana = new GridLayoutManager(this,2); //Definición de LAyoutManager, indica el tipo de diseño (rejilla)
            myRecycler = findViewById(R.id.RecyclerV);  // Invocar al recyclerV del activity_main
            myRecycler.setLayoutManager(lmana);         // Asignar el manager al reciclador
            AdaptadorLibros adaptadorL = new AdaptadorLibros(this, Libro.ejemploLibros()); //Instancia de adaptadorLibros, inicializado con el vector de la clase Libro
            myRecycler.setAdapter(adaptadorL); // Asignar adaptador al reciclador
        */