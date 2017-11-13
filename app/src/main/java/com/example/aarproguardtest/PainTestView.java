package com.example.aarproguardtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.DashPathEffect;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bumptech.glide.Glide;

/**
 * TODO: document your custom view class.
 */
public class PainTestView extends View {
    private Paint mPaint;
    private Bitmap mRectBitmap;
    private Bitmap mCircleBitmap;

    public PainTestView(Context context) {
        super(context);
    }

    public PainTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PainTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColorFilter(new LightingColorFilter())
        BitmapShader shaderA = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.bb_empty), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        BitmapShader shaderB = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        ComposeShader shader = new ComposeShader(shaderA, shaderB, PorterDuff.Mode.SRC_IN);
//        mPaint.setShader(shader);
//        mPaint.setColorFilter(new LightingColorFilter(0x223344, 0xffffff));
//        Bitmap rectBitmap = Bitmap.createBitmap(0, 0, Bitmap.Config.RGB_565);

        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mRectBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rect);
        mCircleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle);

        mPaint.setPathEffect(new DashPathEffect(new float[]{30, 10}, 3.0f));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        int i = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
//
//        mPaint.setColor(Color.BLUE);
//        canvas.drawBitmap(mRectBitmap, 0, 0, mPaint);
//        mPaint.setColor(Color.RED);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
//        canvas.drawBitmap(mCircleBitmap, 0, 0, mPaint);
//        mPaint.setXfermode(null);
//
//        canvas.restoreToCount(i);
        canvas.drawCircle(300, 300, 200, mPaint);

    }
}
