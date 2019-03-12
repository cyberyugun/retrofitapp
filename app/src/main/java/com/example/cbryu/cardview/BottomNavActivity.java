package com.example.cbryu.cardview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class BottomNavActivity extends AppCompatActivity {
BottomNavigationView bottomnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

   bottomnav=findViewById(R.id.bottom_nav);
 bottomnav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain,new HomeFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selFragment=null;
            switch (menuItem.getItemId()){
                case  R.id.nav_home:
                    selFragment=new HomeFragment();
                    break;
                case  R.id.nav_favorite:
                    selFragment=new FavoriteFragment();
                    break;
                case  R.id.nav_search:
                    selFragment=new SearchFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain,selFragment).commit();
            return true;
        }
    };

}
