plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
dependencies{
    api(project(":entities"))
    implementation(project(":exception"))
    implementation(Deps.dagger)
    testImplementation(Deps.testng)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

}