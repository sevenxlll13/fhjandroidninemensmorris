package at.fhj.itm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;

public class Game extends Activity implements OnClickListener{
	
	private String name;
	private EditText name_etxt;
	private RadioButton three_rad, five_rad;
	private int rounds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input);
		
		View startGamebtn = findViewById(R.id.start_button);
		name_etxt = (EditText)findViewById(R.id.name_input);

		
		
		startGamebtn.setOnClickListener(this);
	}

	//@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.start_button:
			name = name_etxt.getText().toString();
						
			Log.d("SSP", "name:" + name);

			
			Intent iStart = new Intent(this, Round.class);
			iStart.putExtra("name", name);

			startActivity(iStart);
			this.finish();
			break;

		default:
			break;
		}
		
	}

}
