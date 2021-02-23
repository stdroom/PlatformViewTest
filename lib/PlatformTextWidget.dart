import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class PlatformTextWidget extends StatefulWidget {

  PlatformTextWidget({this.text});

  final String text;

  @override
  _PlatformTextWidgetState createState() => _PlatformTextWidgetState();

}

class _PlatformTextWidgetState extends State<PlatformTextWidget> {
  String text;
  @override
  Widget build(BuildContext context) {
    if (Platform.isAndroid) {
      return AndroidView(
        // 在 native 中的唯一标识符，需要与 native 侧的值相同
        viewType: "platform_text_view",
        // 在创建 AndroidView 的同时，可以传递参数
        creationParams: <String, dynamic>{"text": text},
        // 用来编码 creationParams 的形式，可选 [StandardMessageCodec], [JSONMessageCodec], [StringCodec], or [BinaryCodec]
        // 如果存在 creationParams，则该值不能为null
        creationParamsCodec: const StandardMessageCodec(),
      );

    }else{
      return Container();
    }
  }

  @override
  void initState() {
    text = widget.text;
  }
}
