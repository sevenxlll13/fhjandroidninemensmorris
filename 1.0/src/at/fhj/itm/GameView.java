package at.fhj.itm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

public class GameView extends View {

	private final Game game;
	private float width;    // width of one tile
	private float height;   // height of one tile
	private int selX;       // X index of selection
	private int selY;       // Y index of selection
	private final Rect selRect = new Rect();

	
	public GameView(Context context) {
		super(context);
		this.game = (Game) context;
		setFocusable(true);
		setFocusableInTouchMode(true);
	}

   protected void onSizeChanged(int w, int h, int oldw, int oldh) {
	      width = w / 7f;
	      height = width;
	      getRect(selX, selY, selRect);
	      Log.d("Mill", "onSizeChanged: width " + width + ", height "
	            + height);
	      super.onSizeChanged(w, h, oldw, oldh);
	   }

	private void getRect(int selX2, int selY2, Rect selRect2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint background = new Paint();
		background.setColor(getResources().getColor(R.color.background));
		canvas.drawRect(0, 0, getWidth(), getHeight(), background);
		
		Paint black = new Paint();
		black.setColor(getResources().getColor(R.color.text));
		
//		for (int i = 0; i < 8; i++) {
//			canvas.drawLine(0, i * height, getWidth(), i * height,black);
//			canvas.drawLine(0, i * height + 1, getWidth(), i * height + 1, black);
//			canvas.drawLine(i * width, 0, i * width, getHeight(),black);
//			canvas.drawLine(i * width + 1, 0, i * width + 1,getHeight(), black);
//		}
		
		canvas.drawLine(20,20,getWidth()-20,20,black);
		canvas.drawLine(20,20,20,getWidth()-20,black);
		canvas.drawLine(getWidth()-20,20,getWidth()-20,getWidth()-20,black);
		canvas.drawLine(20,getWidth()-20,getWidth()-20,getWidth()-20,black);
		
		canvas.drawLine(60,60,getWidth()-60,60,black);
		canvas.drawLine(60,60,60,getWidth()-60,black);
		canvas.drawLine(getWidth()-60,60,getWidth()-60,getWidth()-60,black);
		canvas.drawLine(60,getWidth()-60,getWidth()-60,getWidth()-60,black);
		
		canvas.drawLine(100,100,getWidth()-100,100,black);
		canvas.drawLine(100,100,100,getWidth()-100,black);
		canvas.drawLine(getWidth()-100,100,getWidth()-100,getWidth()-100,black);
		canvas.drawLine(100,getWidth()-100,getWidth()-100,getWidth()-100,black);
	}
	
	


}
