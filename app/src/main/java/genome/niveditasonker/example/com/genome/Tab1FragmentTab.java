package genome.niveditasonker.example.com.genome;

import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


/**
 * Created by Nivedita Sonker on 9/7/2015.
 */
public class Tab1FragmentTab extends Fragment implements OnMapReadyCallback {
    GoogleMap googleMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.current_location, container, false);

        return V;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapFragment supportMapFragment =
                (MapFragment)  getActivity().getFragmentManager().findFragmentById(R.id.googleMaps);
        supportMapFragment.getMapAsync(this);
       // googleMap = supportMapFragment.getMap();
        //

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (!isGooglePlayServicesAvailable()) {
            finish();
        }*/
    }


    /*private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
    }
}
