package com.example.PlatformViewTest;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

/**
 * Time: 2/23/21 4:02 PM
 * Author: leixun
 * Desc:
 */
public class AndroidTestView implements PlatformView , MethodChannel.MethodCallHandler {
    Context context;
    BinaryMessenger messenger;
    int id;
    Map<String,Object> params;
    TextView mAndroidTextView;

    public AndroidTestView(Context context, BinaryMessenger messenger, int id, Map<String,Object> params){
        this.context = context;
        this.id = id;
        this.messenger = messenger;
        this.params = params;
        initTextView();
    }

    private void initTextView(){
        mAndroidTextView = new TextView(context);
        if(params.get("text")!=null){
            mAndroidTextView.setText(params.get("text").toString());
        }else{
            mAndroidTextView.setText("未获取到文案");
        }
        mAndroidTextView.setTextSize(30f);
        mAndroidTextView.setTextColor(Color.parseColor("#000000"));
        mAndroidTextView.setGravity(Gravity.CENTER);

    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if ("setText".equals(call.method)) {
            String text = (String) call.arguments;
            mAndroidTextView.setText(text);
            result.success(null);
        }
    }

    @Override
    public View getView() {
        return mAndroidTextView;
    }

    @Override
    public void dispose() {

    }
}
