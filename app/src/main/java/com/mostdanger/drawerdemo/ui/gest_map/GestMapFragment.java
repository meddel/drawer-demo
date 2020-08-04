package com.mostdanger.drawerdemo.ui.gest_map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.ui.gest_map.map_dial.MapDial;

public class GestMapFragment extends Fragment {

    private GestMapViewModel gestMapViewModel;
    private ImageView imageView2;
    private ImageView imageView4;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_gest_map, null);
        imageView2=view.findViewById(R.id.imageV2);
        imageView4=view.findViewById(R.id.imageV4);
        gestMapViewModel =
                ViewModelProviders.of(this).get(GestMapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gest_map, container, false);
        //final TextView textView = root.findViewById(R.id.text_gest_map);
        gestMapViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast toast = Toast.makeText(getContext(),
                        "before",
                        Toast.LENGTH_SHORT);

                toast.show();*/
                Log.d("message", "work");
                openDialog();


            }
        });
        return root;
    }

    public void openDialog(){

        Log.d("message", "work open dialog");
        /*Toast toast = Toast.makeText(getContext(),
                "This is a message displayed in a Toast",
                Toast.LENGTH_SHORT);

        toast.show();*/
        MapDial mapDial=new MapDial();
        mapDial.showNow(getParentFragmentManager(),"add station");
    }
}
