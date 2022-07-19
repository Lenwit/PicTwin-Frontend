package cl.ucn.disc.dsm.pictwin.frontend;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

/**
 * The Main Activity.
 *
 * @author Mack Díaz.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * UserViewModel
     */
    private UserViewModel userViewModel;

    /**
     * The onCreate instance.
     *
     * @param savedInstanceState instance.
     */
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the Recycler View from the layout
        RecyclerView recyclerView = findViewById(R.id.am_rv_twins);

        //The layout of the Recycler View
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //Build the adapter
        UserAdapter adapter = new UserAdapter();

        //Set the adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        //Build the UserViewModel
        this.userViewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(super.getApplication())
                .create(UserViewModel.class);

        //Menu in MaterialToolbar
        MaterialToolbar toolbar = findViewById(R.id.am_mt_toolbar);
        toolbar.setOnMenuItemClickListener(menuItem -> {
            //If we click over the change theme
            if (menuItem.getItemId() == R.id.menu_theme) {
                //Check the current theme
                if(AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                return true;
            }
            return false;
        });

        //Watch the view model
        userViewModel.getUserLiveData().observe(this, user -> {

            //Update the adapter
            adapter.setUser(user);

            //Refresh the GUI
            adapter.notifyDataSetChanged();

        });

    }
    /**
     * Show the App.
     */
    @Override
    protected void onStart() {
        super.onStart();
        //Load the data from backend
        userViewModel.update();
    }
}