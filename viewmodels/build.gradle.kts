plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.abaferas.viewmodels"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(project(":usecase"))
    implementation(project(":exception"))

    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)
    implementation(Deps.lifecycleViewModelKts)
    implementation(Deps.lifecycleViewModelCompose)
    implementation(Deps.lifecycleRunTimeCompose)
    implementation(Deps.lifecycleSavedState)
    implementation(Deps.lifecycleCommon)
    implementation(Deps.lifecycleService)
    implementation(Deps.lifecycleProcess)
    testImplementation(Deps.lifecycleRuntimeTesting)
}
kapt {
    correctErrorTypes = true
}