package example.com.turn_by_turn;

import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.services.android.navigation.ui.v5.NavigationView;
import com.mapbox.services.android.navigation.ui.v5.NavigationViewOptions;
import com.mapbox.services.android.navigation.ui.v5.OnNavigationReadyCallback;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements OnNavigationReadyCallback {
    
    private NavigationView navigationView;
    private String accessToken = "pk.eyJ1Ijoibml0aWthMSIsImEiOiJjamcxc3RiYjUxaW84MnFueWdqZ29hNzI0In0.s_xoiYtxRmMcx0EKzXaIiQ";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_NoActionBar);
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,accessToken);
        setContentView(R.layout.activity_navigation);
        navigationView = findViewById(R.id.navigationView);
        navigationView.onCreate(savedInstanceState);
        navigationView.initialize(this);
    }
    
    @Override
    public void onStart() {
        super.onStart();
        navigationView.onStart();
    }
    
    @Override
    public void onResume() {
        super.onResume();
        navigationView.onResume();
    }
    
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        navigationView.onLowMemory();
    }
    
    @Override
    public void onBackPressed() {
        // If the navigation view didn't need to do anything, call super
        if (!navigationView.onBackPressed()) {
            super.onBackPressed();
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        navigationView.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        navigationView.onRestoreInstanceState(savedInstanceState);
    }
    
    @Override
    public void onPause() {
        super.onPause();
        navigationView.onPause();
    }
    
    @Override
    public void onStop() {
        super.onStop();
        navigationView.onStop();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigationView.onDestroy();
    }
    
    @Override
    public void onNavigationReady() {
    
        Point origin = Point.fromLngLat(-77.03613, 38.90992);
        Point destination = Point.fromLngLat(-77.0365, 38.8977);
    
        boolean simulateRoute = true;
        
        NavigationViewOptions options = NavigationViewOptions.builder()
                .origin(origin)
                .destination(destination)
//                .awsPoolId(awsPoolId)
                .shouldSimulateRoute(simulateRoute)
                .build();
    
        navigationView.startNavigation(options);
    
    }
    
}
