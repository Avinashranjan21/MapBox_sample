package example.com.turn_by_turn;

import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerPlugin;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    private String accessToken = "pk.eyJ1Ijoibml0aWthMSIsImEiOiJjamcxc3RiYjUxaW84MnFueWdqZ29hNzI0In0.s_xoiYtxRmMcx0EKzXaIiQ";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Mapbox.getInstance(this,accessToken);
    
        Point origin = Point.fromLngLat(-77.03613, 38.90992);
        Point destination = Point.fromLngLat(-77.0365, 38.8977);
    
        boolean simulateRoute = true;

// Create a NavigationLauncherOptions object to package everything together
        NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                .origin(origin)
                .destination(destination)
                .shouldSimulateRoute(simulateRoute)
                .build();
    
// Call this method with Context from within an Activity
        NavigationLauncher.startNavigation(this, options);
    }
}
