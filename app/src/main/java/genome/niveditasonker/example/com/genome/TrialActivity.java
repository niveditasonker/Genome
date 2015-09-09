package genome.niveditasonker.example.com.genome;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nivedita Sonker on 9/7/2015.
 */
public class TrialActivity extends Activity {

    private final String TAG = "TrialActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trial_web_view);
        try {
            JSONObject obj = new JSONObject(getIntent().getExtras().getString("object"));
            final WebView v = (WebView) findViewById(R.id.webView);
            v.getSettings().setJavaScriptEnabled(true);
            v.getSettings().setDomStorageEnabled(true);
            v.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return (false);
                }
            });

            String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid="
                    + obj.getString("place_id") + "&key=AIzaSyBqHs-GZetFszBKKdGiyT66ppRpVkHftRE";

            Log.i(TAG, url);

            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, (String) null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i(TAG, response.toString());
                            try {
                                JSONObject j = response.getJSONObject("result");
                                Log.i(TAG, "website" + j.getString("website"));
                                v.loadUrl(j.getString("website"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i(TAG, error.toString());
                        }
                    });
            Volley.newRequestQueue(this).add(jsObjRequest);
        } catch (JSONException j) {
            j.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
