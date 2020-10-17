package com.isa.audiolibros2020;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String ARG_ID_LIBRO = "id_libro";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetalleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleFragment newInstance(String param1, String param2) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate
                (R.layout.fragment_detalle, container, false);

        //
        Bundle args = getArguments();                                                // Método  que recupera parametros enviados al fragmento
        if(args != null){                                                           // Alguien manda valores
            int position = args.getInt(ARG_ID_LIBRO);                               // Id del libro seleccionado = posicin
            ponInfoLibro(position, vista);                                           // Dada la posición, cargar eso
        } else {
            ponInfoLibro(0, vista);                                                 //No hay argumentos, carga elemento por defecto, el 0
        }

        return vista;
    }

    public void ponInfoLibro(int id) {
        ponInfoLibro(id, getView());
    }

    private void ponInfoLibro(int id, View vista) {
        Libro libro =
                Libro.ejemploLibros().elementAt(id);                            // Obtener de la colección el libro especifico
        ((TextView) vista.findViewById(R.id.titulo)).setText(libro.titulo);     // Asignar valores de objeto a etiquetas
        ((TextView) vista.findViewById(R.id.autor)).setText(libro.autor);
        ((ImageView) vista.findViewById(R.id.portada))
                .setImageResource(libro.recursoImagen);
    }


}