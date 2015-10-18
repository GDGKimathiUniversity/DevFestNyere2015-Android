package com.app.devfest.nyeri.staterestoration;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.devfest.nyeri.staterestoration.fragment.ActivitiesListFragment;

/**
 * Created by Mac on 10/17/2015.
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private Fragment fragment;

    private final String FRAG_TAG="sports";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        mtoolbar.setTitle("Nearby Activities");
        setSupportActionBar(mtoolbar);

        fragment = getSupportFragmentManager().findFragmentByTag(FRAG_TAG);
        if(fragment==null){
            fragment = ActivitiesListFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,FRAG_TAG).commit();
    }
}
