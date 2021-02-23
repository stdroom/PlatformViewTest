package com.example.PlatformViewTest;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/**
 * Time: 2/23/21 4:30 PM
 * Author: leixun
 * Desc:
 */
public class PlatformViewPlugin implements MethodChannel.MethodCallHandler {
    static String CHANNEL = "PlatformViewPlugin";

    public static void register(DartExecutor dartExecutor) {
        MethodChannel channel = new MethodChannel(dartExecutor, CHANNEL);
        channel.setMethodCallHandler(new PlatformViewPlugin());
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

    }
}
