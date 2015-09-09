package genome.niveditasonker.example.com.genome;

import android.content.Intent;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nivedita Sonker on 9/7/2015.
 */
public class Tab2FragmentTab extends Fragment {

    private final String TAG = "Tab2FragamentTab";

    private ListView listView;
    private ArrayList<String> listOfPlaces = new ArrayList<String>();
    private HashMap<String, JSONObject> hash = new HashMap<String, JSONObject>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.nearby_places, container, false);
        //listView = (ListView) V.findViewById(R.id.list_view);
        return V;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView l = (ListView) getView().findViewById(R.id.list_view);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listOfPlaces.get(position);
                Intent i = new Intent(getContext(), TrialActivity.class);
                i.putExtra("object", hash.get(str).toString());
                startActivity(i);
            }
        });
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = "https://maps.googleapis.com/maps/api/place/search/json?location=40.7431735,-73.9799391&radius=100&key=AIzaSyBqHs-GZetFszBKKdGiyT66ppRpVkHftRE";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, (String)null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("results");
                            for(int i = 0; i < array.length(); i++){
                                JSONObject j = array.getJSONObject(i);
                                Log.i(TAG, j.toString());
                                listOfPlaces.add(j.getString("name"));
                                hash.put(j.getString("name"), j);
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                                    android.R.layout.simple_list_item_1, listOfPlaces);
                            ListView v = (ListView) Tab2FragmentTab.this.getView().findViewById(R.id.list_view);
                            v.setAdapter(adapter);
                        }catch(JSONException e){

                        }
                            Log.i(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        Volley.newRequestQueue(getContext()).add(jsObjRequest);
    }
}
