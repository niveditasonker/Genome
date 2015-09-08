package genome.niveditasonker.example.com.genome;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nivedita Sonker on 9/7/2015.
 */
public class Tab2FragmentTab extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.nearby_places, container, false);

        return V;
    }
}
