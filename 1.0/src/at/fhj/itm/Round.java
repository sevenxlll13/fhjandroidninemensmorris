package at.fhj.itm;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import at.fhj.itm.R.id;

public class Round extends Activity implements OnClickListener{

	
	private String name,result,endmsg;
	private TextView head, score_tv;
	private Button select_btn;
	private ImageView user1, user2, user3, pc1, pc2, pc3;
	private int round = 1;
	private int pnts_u = 0, pnts_pc = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.round);
		
		head = (TextView)findViewById(R.id.player_title);
		score_tv = (TextView)findViewById(R.id.score_lbl);
		
		select_btn = (Button)findViewById(R.id.btn_select);

		
		select_btn.setOnClickListener(this);

		
		user1 = (ImageView)findViewById(R.id.rnd1_upic);
		user2 = (ImageView)findViewById(R.id.rnd2_upic);
		user3 = (ImageView)findViewById(R.id.rnd3_upic);
		
		pc1 = (ImageView)findViewById(R.id.rnd1_cpic);
		pc2 = (ImageView)findViewById(R.id.rnd2_cpic);
		pc3 = (ImageView)findViewById(R.id.rnd3_cpic);
		
		
		// get name from Game.java
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			name = extras.getString("name");
		}
		
		head.setText(name + " vs. PC");
	}
	
	//@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btn_select:
			
			if(round>3)
				this.finish();
			else
				showDialog(0);
			break;

		default:
			break;
		}
		
	}


	@Override
	protected Dialog onCreateDialog(int id) {
		
		Dialog dialog;
		
		switch (id) {
		case 0:
			final CharSequence[] items = {"Scissor", "Stone", "Paper"};

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Choose for next round");
			builder.setItems(items, new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int item) {
			        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
			        startRound((String)items[item]);
			    }


			});
			
			dialog = builder.create();
			
			break;

		default:
			dialog=null;
			break;
		}
		
		return dialog;
		
	}
	
	private void startRound(String selection) {
		
		int id = 0, pc_id=0,j=0;
		int i = getRandomInt(1, 3);
		
		if(selection.equalsIgnoreCase("Scissor")){
				id = R.drawable.scissor_l;
				j = 1;}
		else if(selection.equalsIgnoreCase("Stone")){
				id = R.drawable.stone_l;
				j = 2;}
		else if(selection.equalsIgnoreCase("Paper")){
				id = R.drawable.paper_l;
				j=3;}
		
		if(i==1)
			pc_id = R.drawable.scissor_r;
	else if(i==2)
			pc_id = R.drawable.stone_r;
	else if(i==3)
			pc_id = R.drawable.paper_r;
				
		
		if(round==3){
			user3.setImageResource(id);
			pc3.setImageResource(pc_id);
			if(checkWhoGetPoint(i, j)){
				round++;
				select_btn.setText(checkWinner());
			}
		}else if (round==2){
			user2.setImageResource(id);
			pc2.setImageResource(pc_id);
			if(checkWhoGetPoint(i, j)){
				round++;
				findViewById(R.id.round3_lbl).setVisibility(1);
				findViewById(R.id.TableRow03).setVisibility(1);
			}
		}else if (round==1){
			user1.setImageResource(id);
			pc1.setImageResource(pc_id);
			if(checkWhoGetPoint(i, j)){
				round++;
				findViewById(R.id.round2_lbl).setVisibility(1);
				findViewById(R.id.TableRow02).setVisibility(1);
			}
		}
		
	}




	
 
	private String checkWinner() {
		if(pnts_u > pnts_pc){
			endmsg=name+ ", you win!";
			//select_btn.setBackgroundColor();
			select_btn.setTextColor(0xff00ff00);
		}
		else{
			endmsg=name+", you lose!";
			//select_btn.setBackgroundColor(0xffff0000);
			select_btn.setTextColor(0xffff0000);
		}
		return endmsg;
	}


	public static int getRandomInt(int min,int max)  
	 {  
	     try {  
	         //Give the currentTimeMillis some time for the seed  
	         Thread.sleep(5);  
	     } catch (InterruptedException ex) {  
	         ex.printStackTrace();  
	     }  
	     Random randomizer = new Random(System.currentTimeMillis());  
	     return randomizer.nextInt(max-min+1)+min;  
	 }  
		  
	
	
	public Boolean checkWhoGetPoint(int pc, int user){
		
		if(user == pc){
			return false;
		}
		else if (user==1){
			if(pc==2)
				pnts_pc++;
			else
				pnts_u++;
		}else if (user==2){
			if(pc==1)
				pnts_u++;
			else
				pnts_pc++;
		}else if (user==3){
			if(pc==1)
				pnts_pc++;
			else
				pnts_u++;
		}
		result=pnts_u + " : " + pnts_pc;
		score_tv.setText(result);
		return true;
		
		
	}


}
