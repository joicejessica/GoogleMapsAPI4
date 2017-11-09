package a14.xiirpl3.joicejessica.googlemapsapi4;

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
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition COPENHAGEN = CameraPosition.builder()
            .target(new LatLng(55.676097, 12.568337))
            .zoom(5)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;

    LatLng IND = new LatLng(-0.789275, 113.921327);
    LatLng DNM = new LatLng(56.263920, 9.501785);
    LatLng AUS = new LatLng(-25.274398, 133.775136);
    LatLng USA = new LatLng(37.090240, -95.712891);
    MarkerOptions Indonesia, Denmark, Australia, America;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Indonesia = new MarkerOptions()
                .position(new LatLng(-0.789275, 113.921327))
                .title("Indonesia")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        Denmark = new MarkerOptions()
                .position(new LatLng(56.263920, 9.501785))
                .title("Denmark")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        Australia = new MarkerOptions()
                .position(new LatLng(-25.274398, 133.775136))
                .title("Australia")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        America = new MarkerOptions()
                .position(new LatLng(37.090240, -95.712891))
                .title("USA")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        map.moveCamera(CameraUpdateFactory.newCameraPosition(COPENHAGEN));
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(IND)
                .add(DNM)
                .add(USA)
                .add(AUS));
        m_map.addMarker(Indonesia);
        m_map.addMarker(Denmark);
        m_map.addMarker(America);
        m_map.addMarker(Australia);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}