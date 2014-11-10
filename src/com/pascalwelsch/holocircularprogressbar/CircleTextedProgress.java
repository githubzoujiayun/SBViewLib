package com.pascalwelsch.holocircularprogressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cowthan.widget.R;

public class CircleTextedProgress extends FrameLayout {

	private FrameLayout container;
	private TextView tv_1, tv_2;
	private HoloCircularProgressBarCustom bar;

	public CircleTextedProgress(final Context context) {
		super(context);
		init();
	}

	public CircleTextedProgress(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		container = (FrameLayout) View.inflate(this.getContext(),
				R.layout.view_circle_text_progress, null);
		this.addView(container);

		tv_1 = (TextView) container.findViewById(R.id.tv_progress1);
		tv_2 = (TextView) container.findViewById(R.id.tv_progress2);
		bar = (HoloCircularProgressBarCustom) container
				.findViewById(R.id.holoCircularProgressBar1);

	}

	public void setProgress(final int progress, final int max) {
		bar.setProgress((float) progress / (float) max);
	}

	public void setText1(final String str) {
		tv_1.setText(str);
	}

	public void setText2(final String str) {
		tv_2.setText(str);
	}

}
