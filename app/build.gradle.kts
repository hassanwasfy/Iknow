plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.abaferas.iknow"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.abaferas.iknow"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.junitExt)
    implementation(Deps.testMonitor)
    testImplementation(Deps.testng)
    androidTestImplementation(Deps.testng)
    // Hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltWork)
    //firebase
    implementation(platform(Deps.firebaseBom))
    implementation(Deps.firebaseAuth)
    implementation(Deps.firebaseFirestore)
    //retrofit
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConvertoer)
    implementation(Deps.okhttp3Logging)
    implementation(Deps.okhttp3)
    // Room
    implementation(Deps.roomRuntime)
    annotationProcessor(Deps.roomCompiler)
    //noinspection KaptUsageInsteadOfKsp
    kapt(Deps.roomCompilerKapt)
    implementation(Deps.roomKtx)
    testImplementation(Deps.roomTesting)
    implementation(Deps.roomPaging)
    //data store
    implementation(Deps.dataStore)
    //paging
    implementation(Deps.pagingRuntime)
    implementation(Deps.pagingCompose)
    //gson
    implementation(Deps.gson)
    //workManager
    implementation(Deps.workRuntimeKtx)
    implementation(Deps.workMultiprocess)

    api(project(":local"))
    api(project(":remote"))
    api(project(":repository"))
    api(project(":ui"))
    api(project(":exception"))

}
kapt {
    correctErrorTypes = true
}