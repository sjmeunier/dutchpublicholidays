package com.smeunier.dutchpublicholidays;

import java.util.ArrayList;

import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


public class DutchPublicHoliday extends Activity {
	
	private int orientation;
	private StartAppAd startAppAd = new StartAppAd(this);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "106210200", "206333775");
        this.orientation = getScreenOrientation();
        UpdateViews();

    }
 
	@Override
	public void onBackPressed() {
		startAppAd.onBackPressed();
	    super.onBackPressed();
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    startAppAd.onResume();
	}
	
    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener () {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    		TableLayout holidayTable = (TableLayout) findViewById(R.id.holiday_table);
    		holidayTable.removeAllViews();
        	
    		ArrayList<Holiday> holidayList = new ArrayList<Holiday>(); 
        	
        	if (parent.getSelectedItem().toString().equals("2013")){
        		holidayList.add(new Holiday("01 Jan", "Tue", "New Year's Day"));
        		holidayList.add(new Holiday("29 Mar", "Fri", "Good Friday (work day)"));
        		holidayList.add(new Holiday("01 Apr", "Mon", "Easter Monday"));
        		holidayList.add(new Holiday("30 Apr", "Tue", "Queen's Day"));
        		holidayList.add(new Holiday("04 May", "Sat", "Remembrance Day (work day)"));
        		holidayList.add(new Holiday("05 May", "Sun", "Liberation Day (work day)"));
        		holidayList.add(new Holiday("09 May", "Thu", "Ascension Day"));
        		holidayList.add(new Holiday("19 May", "Sun", "Whit Sunday"));
        		holidayList.add(new Holiday("20 May", "Mon", "Whit Monday"));
        		holidayList.add(new Holiday("06 Dec", "Fri", "Sinterklaas (work day)"));
        		holidayList.add(new Holiday("25 Dec", "Wed", "Christmas Day"));
        		holidayList.add(new Holiday("26 Dec", "Thu", "Boxing Day"));
        	} else if (parent.getSelectedItem().toString().equals("2014")){
        		holidayList.add(new Holiday("01 Jan", "Wed", "New Year's Day"));
        		holidayList.add(new Holiday("18 Apr", "Fri", "Good Friday (work day)"));
        		holidayList.add(new Holiday("21 Apr", "Mon", "Easter Monday"));
        		holidayList.add(new Holiday("27 Apr", "Sun", "King's Day"));
        		holidayList.add(new Holiday("04 May", "Sun", "Remembrance Day (work day)"));
        		holidayList.add(new Holiday("05 May", "Mon", "Liberation Day (work day)"));
        		holidayList.add(new Holiday("29 May", "Thu", "Ascension Day"));
        		holidayList.add(new Holiday("08 Jun", "Sun", "Whit Sunday"));
        		holidayList.add(new Holiday("09 Jun", "Mon", "Whit Monday"));
        		holidayList.add(new Holiday("06 Dec", "Sat", "Sinterklaas (work day)"));
        		holidayList.add(new Holiday("25 Dec", "Thu", "Christmas Day"));
        		holidayList.add(new Holiday("26 Dec", "Fri", "Boxing Day"));
        	} else if (parent.getSelectedItem().toString().equals("2015")){
        		holidayList.add(new Holiday("01 Jan", "Thu", "New Year's Day"));
        		holidayList.add(new Holiday("03 Apr", "Fri", "Good Friday (work day)"));
        		holidayList.add(new Holiday("06 Apr", "Mon", "Easter Monday"));
        		holidayList.add(new Holiday("27 Apr", "Mon", "King's Day"));
        		holidayList.add(new Holiday("04 May", "Mon", "Remembrance Day"));
        		holidayList.add(new Holiday("05 May", "Tue", "Liberation Day (work day)"));
        		holidayList.add(new Holiday("14 May", "Thu", "Ascension Day"));
        		holidayList.add(new Holiday("24 May", "Sun", "Whit Sunday"));
        		holidayList.add(new Holiday("25 May", "Mon", "Whit Monday"));
        		holidayList.add(new Holiday("06 Dec", "Sun", "Sinterklaas (work day)"));
        		holidayList.add(new Holiday("25 Dec", "Fri", "Christmas Day"));
        		holidayList.add(new Holiday("26 Dec", "Sat", "Boxing Day"));
        	}
        	
        	int size = holidayList.size();
        	
        	if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        		if ((size % 2) == 1)
        			size = (size + 1) / 2;
        		else
        			size = size / 2;
        	}
        	
        	for (int i = 0; i < size; i++){
        		Holiday item = holidayList.get(i);
        		
		        TableRow tableRow = new TableRow(getApplicationContext());
		        
		        final TextView dayView = new TextView(getApplicationContext());
		        dayView.setText(item.getDay()); 
		        dayView.setWidth(80);
		        dayView.setTextColor(Color.BLACK);
		        tableRow.addView(dayView);
 
		        final TextView dateView = new TextView(getApplicationContext());
		        dateView.setText(item.getDate()); 
		        dateView.setWidth(130);
		        dateView.setTextColor(Color.BLACK);
		        tableRow.addView(dateView);

		        final TextView nameView = new TextView(getApplicationContext());
		        nameView.setText(item.getName()); 
		        nameView.setTextColor(Color.BLACK);
		        tableRow.addView(nameView);

		        holidayTable.addView(tableRow);
        	}
        	
        	if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        		TableLayout holidayTable2 = (TableLayout) findViewById(R.id.holiday_table2);
        		holidayTable2.removeAllViews();
        		
            	for (int i = size; i < holidayList.size(); i++){
            		Holiday item = holidayList.get(i);
            		
    		        TableRow tableRow = new TableRow(getApplicationContext());
    		        
    		        final TextView dayView = new TextView(getApplicationContext());
    		        dayView.setText(item.getDay()); 
    		        dayView.setWidth(80);
    		        dayView.setTextColor(Color.BLACK);
    		        tableRow.addView(dayView);
     
    		        final TextView dateView = new TextView(getApplicationContext());
    		        dateView.setText(item.getDate()); 
    		        dateView.setWidth(130);
    		        dateView.setTextColor(Color.BLACK);
    		        tableRow.addView(dateView);

    		        final TextView nameView = new TextView(getApplicationContext());
    		        nameView.setText(item.getName()); 
    		        nameView.setTextColor(Color.BLACK);
    		        tableRow.addView(nameView);

    		        holidayTable2.addView(tableRow);
            	}
            	
        	}
        }

		public void onNothingSelected(AdapterView<?> parent) {
			
		}
    };
    
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    
	    this.orientation = newConfig.orientation;
	    UpdateViews();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return true;
	}
	 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu_about:
	        	AboutDialog about = new AboutDialog(this);
	        	about.setTitle("About this app");
	        	about.show();
	        	break;
        }
	 
        return true;
    }
	
	public void UpdateViews() {
	
		
		if (this.orientation == Configuration.ORIENTATION_LANDSCAPE)
			setContentView(R.layout.main_activity_landscape);
		else
			setContentView(R.layout.main_activity_portrait);
		
        Spinner yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.year_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapter);

        yearSpinner.setOnItemSelectedListener(listener);
	}
	
	public void UpdateDisplay(){
	}
	
	
	public int getScreenOrientation()
    {
        Display getOrient = getWindowManager().getDefaultDisplay();

        int orientation = getOrient.getOrientation();

        // Sometimes you may get undefined orientation Value is 0
        // simple logic solves the problem compare the screen
        // X,Y Co-ordinates and determine the Orientation in such cases
        if(orientation==Configuration.ORIENTATION_UNDEFINED){

            Configuration config = getResources().getConfiguration();
            orientation = config.orientation;

            if(orientation==Configuration.ORIENTATION_UNDEFINED){
                //if height and widht of screen are equal then
                // it is square orientation
                if(getOrient.getWidth()==getOrient.getHeight()){
                    orientation = Configuration.ORIENTATION_SQUARE;
                }else{ //if widht is less than height than it is portrait
                    if(getOrient.getWidth() < getOrient.getHeight()){
                        orientation = Configuration.ORIENTATION_PORTRAIT;
                    }else{ // if it is not any of the above it will defineitly be landscape
                        orientation = Configuration.ORIENTATION_LANDSCAPE;
                    }
                }
            }
        }
        return orientation; // return value 1 is portrait and 2 is Landscape Mode
    }

}
