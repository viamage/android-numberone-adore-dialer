package com.numberonecall.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class AccountLayout extends LinearLayout {

	public AccountLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public AccountLayout(Context context ,AttributeSet attrs) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
      return true; // With this i tell my layout to consume all the touch events from its childs
   }
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
