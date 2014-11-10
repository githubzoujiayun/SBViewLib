package com.cowthan.widget.utils;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * 处理界面的淡入淡出切换
 * 
 * @author Administrator
 * 
 */
public class AnimFadeUtil {
	// 第一界面渐渐的淡出出视野（执行时间）
	// 时间间隔
	// 第二个界面渐渐淡入进视野（执行时间）

	private static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			View view=(View) msg.obj;
			ViewGroup parent = (ViewGroup) view.getParent();
			parent.removeView(view);
			super.handleMessage(msg);
		}

	};

	/**
	 * 淡出
	 * 
	 * @param view
	 * @param duration
	 */
	public static void fadeOut(final View view, long duration) {
		Animation animation = new AlphaAnimation(1, 0);
		animation.setDuration(duration);

		animation.setFillAfter(true);// 第一个界面依然存在
		// 动画的执行效果进行监听
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// 删除View
				// ViewGroup parent = (ViewGroup) view.getParent();
				// parent.removeView(view);

				// 在2.3的模拟器上，抛异常，4.0无问题
				
				Message message=Message.obtain();
				message.obj=view;
				handler.sendMessage(message);
			}
		});

		view.startAnimation(animation);
	}

	/**
	 * 淡入
	 * 
	 * @param view
	 * @param duration
	 * @param delay
	 *            第一个界面执行淡出的时间
	 */
	public static void fadeIn(View view, long duration, long delay) {
		Animation animation = new AlphaAnimation(0, 1);
		animation.setDuration(duration);
		animation.setStartOffset(delay);

		view.startAnimation(animation);
	}

}
