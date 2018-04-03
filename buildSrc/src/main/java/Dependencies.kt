object Versions {
    const val compileSdk = 27
    const val minSdk = 17
    const val targetSdk = 27
    const val versionCode = 1
    const val versionName = "1.0"
    const val gradle = "3.0.1"
    const val kotlin = "1.2.30"
    const val support = "27.1.0"
    const val junit = "4.12"
    const val testRunner = "1.0.1"
    const val expresso = "3.0.1"
    const val fabric = "1.+"
    const val crashlytics = "2.9.1"
    const val timber = "4.6.1"
    const val leakCanary = "1.5.4"
    const val butterknife = "8.8.1"
    const val dagger2 = "2.14.1"
    const val mockito = "2.16.0"
    const val hawk = "2.0.1"
    const val rxAndroid = "2.0.2"
    const val rxJava = "2.1.11"
    const val parceler = "1.1.10"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabric = "io.fabric.tools:gradle:${Versions.fabric}"
}

object Libs {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    const val supportAppcompat = "com.android.support:appcompat-v7:${Versions.support}"
    const val supportRecycler = "com.android.support:recyclerview-v7:${Versions.support}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.expresso}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val butterknife = "com.jakewharton:butterknife:${Versions.butterknife}"
    const val butterknifeCompiler = "com.jakewharton:butterknife-compiler:${Versions.butterknife}"
    const val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    const val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    const val dagger2Android = "com.google.dagger:dagger-android:${Versions.dagger2}"
    const val dagger2AndroidCompiler = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val parceler = "org.parceler:parceler-api:${Versions.parceler}"
    const val parcelerCompiler = "org.parceler:parceler:${Versions.parceler}"
}