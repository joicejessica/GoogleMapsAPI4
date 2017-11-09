package a14.xiirpl3.joicejessica.googlemapsapi4;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition MALANG = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition COPENHAGEN = CameraPosition.builder()
            .target(new LatLng(55.676097, 12.568337))
            .zoom(17)
            .bearing(295)
            .tilt(90)
            .build();
    static final CameraPosition GOLDCOAST = CameraPosition.builder()
            .target(new LatLng(-28.016667, 153.400000))
            .zoom(16)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;

    MarkerOptions cpg, gcs;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpg = new MarkerOptions()
                .position(new LatLng(55.676097, 12.568337))
                .title("Copenhagen, Denmark")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        gcs = new MarkerOptions()
                .position(new LatLng(-28.016667, 153.400000))
                .title("Gold Coast, Australia")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(cpg);
        m_map.addMarker(gcs);
        flyTo(MALANG);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}