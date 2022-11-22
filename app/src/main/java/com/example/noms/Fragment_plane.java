package com.example.noms;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_plane#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_plane extends Fragment {

    private  ImageView imageViewPlano;
    private  View view;
    private int xInt;
    private int yInt;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public Fragment_plane() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_plane.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_plane newInstance(String param1, String param2) {
        Fragment_plane fragment = new Fragment_plane();
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

        view = inflater.inflate(R.layout.fragment_plane, container, false);
        imageViewPlano = view.findViewById(R.id.idPlano);


        imageViewPlano.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int[] values = new int[2];
                view.getLocationOnScreen(values);
                for (int i = 0; i < values.length ; i++) {
                    xInt = values[0];
                    yInt= values[1];
                }
                String puta = String.valueOf(yInt+xInt);
                Toast.makeText(getActivity(),puta,Toast.LENGTH_SHORT).show();
            }
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.plano);


        Bitmap cropbitmap = Bitmap.createBitmap(bitmap, xInt, yInt, 531, 381);






        //default android method createBitmap(Bitmap source, int x, int y, int width, int height)
        return  view;
    }


}