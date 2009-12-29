package at.fhj.itm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class Game extends Activity implements OnClickListener{
	
	private String player01, player02;
	private GameView gameView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inputplayer);
		
		View startGamebtn = findViewById(R.id.start_button);
		startGamebtn.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		
		EditText player01name = (EditText)findViewById(R.id.player01_input);
		EditText player02name = (EditText)findViewById(R.id.player02_input);
		
		
		switch (v.getId()) {
		case R.id.start_button:
			player01 = player01name.getText().toString();
			player02 = player02name.getText().toString();
			Log.d("Mill", "player01 name:" + player01);
			Log.d("Mill", "player02 name:" + player02);
			gameView = new GameView(this);
			setContentView(gameView);
			break;

		default:
			break;
		}
		
	}

}
