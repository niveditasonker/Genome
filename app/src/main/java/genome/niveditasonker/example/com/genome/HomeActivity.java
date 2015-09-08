package genome.niveditasonker.example.com.genome;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

/**
 * Created by Nivedita Sonker on 9/7/2015.
 */
public class HomeActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);

        mTabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        mTabHost.setup(this,  getSupportFragmentManager(), R.id.current_location);

        mTabHost.addTab(
                mTabHost.newTabSpec("My Location").setIndicator("Tab 1", null),
                Tab1FragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Nearby Places").setIndicator("Tab 2", null),
                Tab2FragmentTab.class, null);


    }
}
