# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep data binding classes
-keep class androidx.databinding.** { *; }

# AGP 9.1 以降、R8 は DEX 出力時に既定でクラスを無名パッケージへ再配置する。
# DataBinding は生成された DataBinderMapperImpl をリフレクションで解決するため、
# release ビルドで画面が表示されなくなる場合は次の行を有効化する。
#-dontrepackage