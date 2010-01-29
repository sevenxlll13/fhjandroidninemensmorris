package at.fhj.itm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class SSP extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	@Override
	
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        
        // instantiate Buttons

        View newGameBtn = findViewById(R.id.new_button);
        View aboutBtn = findViewById(R.id.about_button);
        View exitBtn = findViewById(R.id.exit_button);
        
        // add OnClickListener to Buttons

        newGameBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Settings.class));
			break;
		default:
			break;
		}
		
		return false;
	}

	//@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.exit_button:
			finish();
			break;
		case R.id.about_button:
			Intent iAbout = new Intent(this, About.class);
			startActivity(iAbout);
			break;
		case R.id.new_button:
			Intent iNew = new Intent(this, Game.class);
			startActivity(iNew);
			break;
		default:
			break;
		}
	}
}