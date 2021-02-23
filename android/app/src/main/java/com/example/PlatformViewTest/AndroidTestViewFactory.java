package com.example.PlatformViewTest;

import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * Time: 2/23/21 4:47 PM
 * Author: leixun
 * Desc:
 */
public class AndroidTestViewFactory extends PlatformViewFactory {

    BinaryMessenger messenger;

    public AndroidTestViewFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }
    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Map<String, Object> params = (Map<String, Object>) args;
        return new AndroidTestView(context, messenger, viewId, params);
    }
}
