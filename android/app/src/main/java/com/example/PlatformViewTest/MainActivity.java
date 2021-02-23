package com.example.PlatformViewTest;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;

public class MainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        PlatformViewPlugin.register(flutterEngine.getDartExecutor());
        flutterEngine.getPlatformViewsController().getRegistry().registerViewFactory("platform_text_view",new AndroidTestViewFactory(flutterEngine.getDartExecutor().getBinaryMessenger()));
    }


}
