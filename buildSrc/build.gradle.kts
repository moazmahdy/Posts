plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}
repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.44")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
}