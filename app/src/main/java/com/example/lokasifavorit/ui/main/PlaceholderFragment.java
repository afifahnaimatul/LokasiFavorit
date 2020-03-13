package com.example.lokasifavorit.ui.main;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.example.lokasifavorit.R;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements OnMapReadyCallback {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private GoogleMap mMap;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root;

        if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
            root = inflater.inflate(R.layout.activity_maps, container, false);
            SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } else{
            root = inflater.inflate(R.layout.fragment_tab, container, false);
        }


        //final TextView textView = root.findViewById(R.id.section_label);
//        pageViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // 47.016841, 7.778934
        LatLng germany = new LatLng(47.016841, 7.778934);
        mMap.addMarker(new MarkerOptions().position(germany).title("Marker in Germany"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(germany));

        // 21.422879, 39.825354
        LatLng mekka = new LatLng(21.422879, 39.825354);
        mMap.addMarker(new MarkerOptions().position(mekka).title("Marker in Mekka"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mekka));

        // 25.162125, 55.220830
        LatLng dubai = new LatLng(25.162125, 55.220830);
        mMap.addMarker(new MarkerOptions().position(dubai).title("Marker in Dubai"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dubai));

        mMap.setMyLocationEnabled(true);
    }
}