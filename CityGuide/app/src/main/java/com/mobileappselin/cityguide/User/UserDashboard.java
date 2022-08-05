package com.mobileappselin.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.mobileappselin.cityguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.mobileappselin.cityguide.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.mobileappselin.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.mobileappselin.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.mobileappselin.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.mobileappselin.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.mobileappselin.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Variables
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, categoriesRecycler, mostViewedRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5, gradient6;
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard2);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);



        navigationDrawer();



        featuredRecycler();
        categoriesRecycler();
        mostViewedRecycler();


    }
    //Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else  drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.lightpurple));

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                //Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case  R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCategories.class));
                break;
        }
        return true;
    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hotel_mostv, "Moda Hotel", "Seyahatlerinizde ailenizle birlikte ev konforu hissedeceğiniz huzurlu, güvenli ve hijyen dolu dinlenme alanız sizi karşılıyor olacak."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.historicalplace_mostv, "Kırklareli Müzesi", " Türkiye'de ki doğal tarih örneklerini, bölgenin kültürel yaşam tarihi ile ilgili etnografik öğeleri, kent içinde ve çevresinde bulunan arkeolojik eserleri sergileyen ulusal bir müzedir."));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.kutuphane_mostv, "Kırklareli İl Halk Kütüphanesi", "Ödünç Kitap Hizmeti ,Geçici Kütüphane Dermesi, İnternet Erişim Hizmeti,Kütüphaneler Arası Ödünç Verme Hizmeti"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);


    }

    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient6 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.carpark_categories, "Otoparklar"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hotel_categories, "Oteller"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.library, "Kütüphane"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.market_categories, "Marketler"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient5, R.drawable.park_img, "Parklar"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.historical_categories, "Tarihi Yerler"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.ucmmigros, "MMM MİGROS", "Hizmet seçenekleri: Mağaza içinde alışveriş · Mağazadan teslim alma · Evlere servis"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.ataturkeviimg, "Ataturk Evi", "Türkiye'nin kurucusu olarak bilinen asker ve lider Kemal Atatürk'ün çocukluk evi."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.yaylaparki_img, "Yayla Parkı", "Tarihle iç içe,muhteşem bir yer.Kısacası;Eski Kırklareli"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

}