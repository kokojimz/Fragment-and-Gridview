package com.example.fragmentandgridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.fragmentandgridview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    GridView gridView; // Add this line

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        String[] wifeName = {"Aqua", "Lotus", "Lily", "Jasmine",
                "Tulip", "Orchid", "Lavender", "RoseMarry", "Sunflower", "Carnation"};
        int[] wifeImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g,
                R.drawable.h, R.drawable.i, R.drawable.j};

        // Find GridView by ID from FrameLayout
        gridView = binding.frameLayout.findViewById(R.id.gridview);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked on " + wifeName[position], Toast.LENGTH_SHORT).show();
            }
        });

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.Home) {
                replaceFragment(new HomeFragment());
                gridView.setAdapter(new GridAdapter(MainActivity.this, wifeName, wifeImages)); // Set adapter here
            } else if (itemId == R.id.profile) {
                replaceFragment(new ProfileFragment());
            } else if (itemId == R.id.settings) {
                replaceFragment(new SettingsFragment());
            }

            return true;
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}
