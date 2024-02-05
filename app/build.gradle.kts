@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.posts"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.posts"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // New
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintlayout)
    implementation(project(":posts:ui"))
    implementation(project(":posts:domain"))
    implementation(project(":posts:data"))
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidxTestExtJunit)
    androidTestImplementation(Dependencies.espressoCore)

    // Navigation
    implementation(Dependencies.navigation)
    implementation(Dependencies.navigationUi)

    // Hilt
    implementation(Dependencies.hiltAndroid)
    //implementation(Dependencies.hiltNavigation)
    kapt(Dependencies.hiltAndroidCompiler)

    implementation(project(":posts:ui"))
    implementation(project(":posts:domain"))
    implementation(project(":posts:data"))

    // Old
//    implementation(libs.core.ktx)
//    implementation(libs.appcompat)
//    implementation(libs.material)
//    implementation(libs.constraintlayout)
//    implementation(project(":posts:ui"))
//    implementation(project(":posts:domain"))
//    implementation(project(":posts:data"))
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.test.ext.junit)
//    androidTestImplementation(libs.espresso.core)
//    implementation(libs.navigation)
//    implementation(libs.navigation.ui)
//    implementation(libs.hilt.android)
//    implementation(libs.hilt.navigation)
//    kapt(libs.hilt.android.compiler)
}

kapt {
    correctErrorTypes = true
}