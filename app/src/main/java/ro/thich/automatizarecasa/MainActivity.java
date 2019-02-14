package ro.thich.automatizarecasa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String urlSet;
    Boolean devSet;
    Boolean stare1 = false;
    Boolean stare2 = false;
    Boolean stare3 = false;
    Boolean stare4 = false;
    Boolean stare5 = false;
    Boolean stare6 = false;
    Boolean stare7 = false;
    Boolean stare8 = false;
    Boolean stare9 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        urlSet = myPrefs.getString("address", null);
        devSet = myPrefs.getBoolean("toasts", false);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Switch drawerSwitch = (Switch) navigationView.getMenu().findItem(R.id.switch_item).getActionView();
        drawerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // do
                    if (devSet)
                        Toast.makeText(MainActivity.this, "Pompa Pornita", Toast.LENGTH_LONG).show();
                } else {
                    // do other stuff
                    if (devSet)
                        Toast.makeText(MainActivity.this, "Pompa Oprita", Toast.LENGTH_LONG).show();
                }
            }
        });


        final RelativeLayoutButton button1 = new RelativeLayoutButton(this, R.id.button1);
        button1.setText(R.id.test_button_text1, getString(R.string.apasa));
        button1.setText(R.id.test_button_text2, "Baie Mare");
        button1.setImageResource(R.id.test_button_image, R.drawable.iconfinder_bathtub);

        final RelativeLayoutButton button2 = new RelativeLayoutButton(this, R.id.button2);
        button2.setText(R.id.test_button_text1, getString(R.string.apasa));
        button2.setText(R.id.test_button_text2, "Dressing");
        button2.setImageResource(R.id.test_button_image, R.drawable.iconfinder_furniture_living_room_home_house_offie);

        final RelativeLayoutButton button3 = new RelativeLayoutButton(this, R.id.button3);
        button3.setText(R.id.test_button_text1, getString(R.string.apasa));
        button3.setText(R.id.test_button_text2, "Dormitor Mare");
        button3.setImageResource(R.id.test_button_image, R.drawable.iconfinder_bed);

        final RelativeLayoutButton button4 = new RelativeLayoutButton(this, R.id.button4);
        button4.setText(R.id.test_button_text1, getString(R.string.apasa));
        button4.setText(R.id.test_button_text2, "Hol Mare");
        button4.setImageResource(R.id.test_button_image, R.drawable.iconfinder_couple);

        final RelativeLayoutButton button5 = new RelativeLayoutButton(this, R.id.button5);
        button5.setText(R.id.test_button_text1, getString(R.string.apasa));
        button5.setText(R.id.test_button_text2, "Hol Mic");
        button5.setImageResource(R.id.test_button_image, R.drawable.iconfinder_couple);

        final RelativeLayoutButton button6 = new RelativeLayoutButton(this, R.id.button6);
        button6.setText(R.id.test_button_text1, getString(R.string.apasa));
        button6.setText(R.id.test_button_text2, "Living");
        button6.setImageResource(R.id.test_button_image, R.drawable.iconfinder_triple_seat_sofa);

        final RelativeLayoutButton button7 = new RelativeLayoutButton(this, R.id.button7);
        button7.setText(R.id.test_button_text1, getString(R.string.apasa));
        button7.setText(R.id.test_button_text2, "Bucatarie");
        button7.setImageResource(R.id.test_button_image, R.drawable.iconfinder_coffee_cup);

        final RelativeLayoutButton button8 = new RelativeLayoutButton(this, R.id.button8);
        button8.setText(R.id.test_button_text1, getString(R.string.apasa));
        button8.setText(R.id.test_button_text2, "Dormitor Christina");
        button8.setImageResource(R.id.test_button_image, R.drawable.iconfinder_bed);

        final RelativeLayoutButton button9 = new RelativeLayoutButton(this, R.id.button9);
        button9.setText(R.id.test_button_text1, getString(R.string.apasa));
        button9.setText(R.id.test_button_text2, "Baie Christina");
        button9.setImageResource(R.id.test_button_image, R.drawable.iconfinder_bathtub);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare1 = !stare1;
                if (stare1) {
                    button1.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button1.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led0";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Baia Mare - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare2 = !stare2;
                if (stare2) {
                    button2.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button2.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led2";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Dressing - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare3 = !stare3;
                if (stare3) {
                    button3.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button3.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led3";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Dormitor Mare - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare4 = !stare4;
                if (stare4) {
                    button4.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button4.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led13&led14";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Hol Mare - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare5 = !stare5;
                if (stare5) {
                    button5.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button5.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led4";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Hol Mic - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare6 = !stare6;
                if (stare6) {
                    button6.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button6.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led8";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Living - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare7 = !stare7;
                if (stare7) {
                    button7.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button7.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led9";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Bucatarie - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare8 = !stare8;
                if (stare8) {
                    button8.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button8.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led10";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Camera Christina - " + urlSet + urlAttr, Toast.LENGTH_SHORT).show();

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stare9 = !stare9;
                if (stare9) {
                    button9.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun_glow);
                } else {
                    button9.setImageResource(R.id.test_button_image2, R.drawable.iconfinder_sun);
                }
                String urlAttr = "/?led11";
                new RequestTask().execute(urlSet + urlAttr);
                if (devSet)
                    Toast.makeText(MainActivity.this, "Baie Christina - ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else*/
        if (id == R.id.nav_manage) {
            startActivity(new Intent(MainActivity.this, MyPreferencesActivity.class));
            //if (devSet) Toast.makeText(MainActivity.this, "Meniu setari inexistent", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.switch_item) {

        }/*else if (id == R.id.checkable_menu) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
