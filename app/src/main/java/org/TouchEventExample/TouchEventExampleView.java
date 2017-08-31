package org.TouchEventExample;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


/**
 *
 */
public class TouchEventExampleView extends View {

	private int m_x; // タッチしたx座標
	private int m_y; // タッチしたy座標
	
	// 터치이벤트의 액션값을 표시할 문자열변수
	private String m_strAction = "없음"; 
	
	public TouchEventExampleView(Context context) {
		super(context);
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// アイコン表示
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon),m_x, m_y, null);
		
    	Paint p = new Paint(); 
    	p.setTextSize(20);     // テキストサイズを20に指定
    	p.setColor(Color.WHITE); // 文字色を白に指定
		canvas.drawText("イベント座標    X :" + m_x +" Y :" + m_y, 0, 20, p);
		canvas.drawText("イベントアクション :" + m_strAction , 0, 40, p);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// 座標取得
		m_x = (int) event.getX();
		m_y = (int) event.getY();

		
		// アクショントリガー.
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			// ACTION_DOWN
			m_strAction = "ACTION_DOWN";
		}
		if(event.getAction() == MotionEvent.ACTION_MOVE){
			// ACTION_MOVE
			m_strAction = "ACTION_MOVE";
		}
		if(event.getAction() == MotionEvent.ACTION_UP){
			// ACTION_UP
			m_strAction = "ACTION_UP";
			m_x = 0; // 原点に移動
			m_y = 0;
		}

		invalidate(); // 画面を更新する
		
		//return super.onTouchEvent(event);
		// ACTION_MOVE、ACTION_UPのアクショントリガーを取得するためにはTRUEを返却
		return true; 
	}

}
