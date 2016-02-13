package sp.com.parkreminder;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class MainActivity extends AppCompatActivity implements AboutApp.OnFragmentInteractionListener {

    static int currFrag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                Fragment f1 = new AboutApp();
                fm.replace(R.id.fragment, f1);
                currFrag = 1;
                fm.commit();
            }
        });

        if(currFrag == 0) {
            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            Fragment f1 = new MainActivityFragment();
            fm.replace(R.id.fragment, f1);
            fm.commit();
        } else if(currFrag == 1) {
            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            Fragment f1 = new AboutApp();
            fm.replace(R.id.fragment, f1);
            fm.commit();
        }
        new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withBadge("2")
                                .withDescription("Test description")
                                .withName("My name!")
                )
                .withActionBarDrawerToggle(true)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFragmentInteraction(Uri uri) {

    }

    public void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        currFrag = state.getInt("frag");
    }

    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt("frag", currFrag);
    }
}
