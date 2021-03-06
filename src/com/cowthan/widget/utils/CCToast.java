
package com.cowthan.widget.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * 只会显示一个toast </br> 不会有延迟的toast
 * 
 * @author pengjun
 */
public class CCToast{

    /**
     * 唯一的toast
     */
    private static Toast mToast = null;

    private CCToast() {
    }

    public static void toastLong(final Activity ctx, final String tip){
    	showToast(ctx, tip, Toast.LENGTH_LONG);
    }
    
    public static void toastShort(final Activity ctx, final String tip){
    	showToast(ctx, tip, Toast.LENGTH_SHORT);
    }
    
    /**
     * 显示的可以及时清除
     * 
     * @param ctx
     * @param tips
     * @param lastTime
     * @return
     */
    public static void showToast(final Activity ctx, final int stringid, final int lastTime) {
        ctx.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (mToast != null) {
                    // mToast.cancel();
                } else {
                    mToast = Toast.makeText(ctx, stringid, lastTime);
                }
                mToast.setText(stringid);
                mToast.show();
            }
        });
//        return mToast;
    }

    /**
     * 显示的可以及时清除
     * 
     * @param ctx
     * @param tips
     * @param lastTime
     * @return
     */
    public static void showToast(final Activity ctx, final String tips, final int lastTime) {

        ctx.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (mToast != null) {
                    // mToast.cancel();
                } else {
                    mToast = Toast.makeText(ctx, tips, lastTime);
                }
                mToast.setText(tips);
                mToast.show();
            }
        });

//        return mToast;
    }

    public static void showToast(final Activity ctx, final int gravity, final int stringid, final int lastTime) {
        
        ctx.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (mToast != null) {
                    // mToast.cancel();
                } else {
                    mToast = Toast.makeText(ctx, stringid, lastTime);
                }
                mToast.setText(stringid);
                mToast.setGravity(gravity, 0, 0);
                mToast.show();
            }
        });
//        return mToast;
    }

    public static void showToast(final Activity ctx, final int gravity, final String text, final int lastTime) {
        
        ctx.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (mToast != null) {
                    // mToast.cancel();
                } else {
                    mToast = Toast.makeText(ctx, text, lastTime);
                }
                mToast.setText(text);
                mToast.setGravity(gravity, 0, 0);
                mToast.show();
            }
        });
//        return mToast;
    }

}
