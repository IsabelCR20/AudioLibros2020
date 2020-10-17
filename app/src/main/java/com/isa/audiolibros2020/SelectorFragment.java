package com.isa.audiolibros2020;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class SelectorFragment extends Fragment {
    private RecyclerView recyclerViewFragment;
    AdaptadorLibros adaptador;
    RecyclerView.LayoutManager layoutM;
    MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity)                 //Verificar si el contexto es instancia de MainActivity
            mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista =  inflater.inflate(R.layout.layout_lista_selector_fragment, null);              // Infla el diseño del layout_lista_selector_fragment (Tiene el recycler adentro)
        adaptador = new AdaptadorLibros(getActivity(),Libro.ejemploLibros());                           // Adaptador para el recycler. Su conetexto es la actividad que contiene el fragmento
        adaptador.setOnClickListener(                                                                       //Que se va a hacer cuando se de click
                v -> {
                    int posicion = recyclerViewFragment.getChildAdapterPosition(v);                             //Toast.makeText(getActivity(), "entero: " + posicion, Toast.LENGTH_LONG).show();
                    mainActivity.mostrarDetalle(posicion);
                }
        );
        layoutM = new GridLayoutManager(getActivity(), 2);                                          // Manejador que define como grilla al recycler. Su contexto es la actividad, con 2 columnas
                //
        recyclerViewFragment = vista.findViewById(R.id.recyclerVFragment);              //Instancia de recycler de la vista
        recyclerViewFragment.setLayoutManager(layoutM);                                 // Asignación del manejador al recicler
        recyclerViewFragment.setAdapter(adaptador);                                     // Asignación de adaptador al recycler
        Log.d("SelectorF", "onCreateV");
        return vista;                                                                       //return super.onCreateView(inflater, container, savedInstanceState);
    }
}

/*
adaptador.setOnItemLongClickListener( v -> {
                    AlertDialog.Builder cuadroDialogo = new AlertDialog.Builder(mainActivity);
                     cuadroDialogo.setTitle("Seleccionar la opción");
                     //cuadroDialogo.setMessage("Este es un cuadro de dialogo");
                    cuadroDialogo.setItems(new String[]{"Compartir", "Eliminar", "Agregar"},
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getActivity(), "entero: " + i, Toast.LENGTH_LONG).show();
                                }
                            });
                     /*cuadroDialogo.setPositiveButton("Ok", (dI, i) -> {
                         //Toast.makeText(mainActivity, "OK!", Toast.LENGTH_LONG).show();
                     });
                     cuadroDialogo.create().show();
                             return false;
                             }
                             );
 */