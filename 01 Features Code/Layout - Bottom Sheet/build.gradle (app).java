// Plus dependency configuration, I had ran into a few more touble so I to do the following:
// + [File] - [Project Structure] >> [Modules] - [Properties] - Set [Compile Sdk Version] to 28 (API 28: Android 9.0 (Pie))
// This worked for me.
// References https://stackoverflow.com/questions/49280632/error9-5-error-resource-androidattr-dialogcornerradius-not-found

plugins {
    id 'com.android.application'
}

android {
    compileSdk 26
    buildToolsVersion "26.0.1"

    defaultConfig {
        applicationId "com.example.bottomsheetex1"
        minSdk 19
        targetSdk 26
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    compileSdkVersion 28
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:26.1.0'
    implementation 'com.android.support:design:26.1.0'

    implementation "com.google.android.material:material:1.1.0-alpha04"

    implementation 'com.android.support.constraint:constraint-layout:1.0.2'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
}
