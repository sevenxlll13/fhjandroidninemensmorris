package at.fhj.itm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Round extends Activity implements OnClickListener{

	
	private String name;
	private int rounds;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.round);
		
		// get name & rounds from Game.java
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			name = extras.getString("name");
			rounds = extras.getInt("rounds");
		}
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
