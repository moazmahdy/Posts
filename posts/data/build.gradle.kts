@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id(Plugins.COMMON)
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(project(":posts:domain"))
}
kapt {
    correctErrorTypes = true
}