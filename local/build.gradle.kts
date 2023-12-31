plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.abaferas.local"
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

    implementation(project(":repository"))
    implementation(project(":exception"))


    implementation(Deps.coreKtx)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    // Hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltWork)
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
    implementation(Deps.dataStoreCore)
    implementation(Deps.ds)
    //paging
    implementation(Deps.pagingRuntime)
    implementation(Deps.pagingCompose)
    //gson
    implementation(Deps.gson)
    //workManager
    implementation(Deps.workRuntimeKtx)
    implementation(Deps.workMultiprocess)

    implementation(Deps.kotlinxCourotines)
}
kapt {
    correctErrorTypes = true
}