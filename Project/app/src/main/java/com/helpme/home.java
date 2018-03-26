package com.helpme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.helpme.Authentication.SignIn;
import com.helpme.Fragments.CarpenterFragment;
import com.helpme.Fragments.CookingFragment;
import com.helpme.Fragments.DoctorFragment;
import com.helpme.Fragments.EngineerFragment;
import com.helpme.Fragments.MechanicFragment;
import com.helpme.Fragments.PlumberFragment;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView userName;
    RecyclerView recycleMenu;
    RecyclerView.LayoutManager layoutManager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Posts");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Here is the power
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutId);
        viewPager = (ViewPager) findViewById(R.id.viewPagerId);

        // adding fragments;
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragments(new DoctorFragment(), "Doctor");
        adapter.addFragments(new EngineerFragment(), "Engineer");
        adapter.addFragments(new CarpenterFragment(), "Carpenter");
        adapter.addFragments(new CookingFragment(), "Cooking");
        adapter.addFragments(new PlumberFragment(), "Plumber");
        adapter.addFragments(new MechanicFragment(), "Mechanic");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
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
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.MyProfile) {
            Intent intent = new Intent(this, MyProfile.class);
            startActivity(intent);
        } else if (id == R.id.EditMyInfo) {

            Intent intent = new Intent(this, EditProfile.class);
            startActivity(intent);

        } else if (id == R.id.MyPosts) {

        } else if (id == R.id.AddProfession) {
            Intent intent = new Intent(this, AddProfession.class);
            startActivity(intent);

        } else if (id == R.id.Logout) {

            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
