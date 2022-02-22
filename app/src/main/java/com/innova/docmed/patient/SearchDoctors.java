package com.innova.docmed.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;

import com.innova.docmed.R;

public class SearchDoctors extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doctors);
        configureToolbar();

    }

    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        toolbar.setTitle("Available Doctors");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // to populate search and filter on toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_bar, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        Drawable r= getResources().getDrawable(R.drawable.ic_local_hospital_black_24dp);
        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" Specialist" );
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //menu.findItem(R.id.empty).setTitle(sb);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint(Html.fromHtml("<font color = #000000>" + "Search patient" + "</font>"));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
//                DoctorAdapterFiltred.specialiteSearch = false;
//                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.option_all:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("");
                return true;
            case R.id.option_general:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("General Medicine");
                return true;
            case R.id.option_Dentist:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("Dentist");
                return true;
            case R.id.option_Ophthalmologists:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("Ophthalmologists");
                return true;
            case R.id.option_ORL:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("ORL");
                return true;
            case R.id.option_Pediatrics:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("Pediatrics");
                return true;
            case R.id.option_Radiologist:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("Radiologist");
                return true;
            case R.id.option_Rheumatologists:
//                DoctorAdapterFiltred.specialiteSearch = true;
//                adapter.getFilter().filter("Rheumatologists");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}