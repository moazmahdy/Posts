plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = BuildConfig.APP_ID
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidxTestExtJunit)
    androidTestImplementation(Dependencies.espressoCore)

    implementation(Dependencies.fragment)
    implementation(Dependencies.activity)

    // hilt
    implementation(Dependencies.hiltAndroid)
    //implementation(Dependencies.hiltNavigation)
    kapt(Dependencies.hiltAndroidCompiler)

    // retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)
    implementation(Dependencies.converterFactory)
}

kapt {
    correctErrorTypes = true
}