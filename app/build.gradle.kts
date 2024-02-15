import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.libsDirectory

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.sergio.rodriguez.examplenavigation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sergio.rodriguez.examplenavigation"
        minSdk = 26
        targetSdk = 34
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation( project(":navigation"))

    //KOTLIN
    implementation(dependencyNotation= "androidx.core:core-ktx:1.12.0")

    //EXTENCIONES DE LIFECYCLE DE KOTLIN
    implementation(dependencyNotation= "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //ACTIVITY
    implementation(dependencyNotation= "androidx.activity:activity-compose:1.8.2")

    //JETPACK COMPOSE
    implementation(dependencyNotation= platform(notation= "androidx.compose:compose-bom:2024.01.00"))
    implementation(dependencyNotation= "androidx.compose.ui:ui")
    implementation(dependencyNotation= "androidx.compose.ui:ui-graphics")
    implementation(dependencyNotation= "androidx.compose.ui:ui-tooling-preview")
    //MATERIAL 3 COMPOSE
    implementation(dependencyNotation= "androidx.compose.material3:material3")

    //NAVIGATION COMPOSE
    implementation(dependencyNotation= "androidx.navigation:navigation-compose:2.7.6")

    //TEST UNIT
    testImplementation(dependencyNotation= "junit:junit:4.13.2")

    //TEST INSTRUMENTATION
    androidTestImplementation(dependencyNotation= "androidx.test.ext:junit:1.1.5")
    androidTestImplementation(dependencyNotation= "androidx.test.espresso:espresso-core:3.5.1")

    //COMPOSE TEST UI
    androidTestImplementation(platform(notation= "androidx.compose:compose-bom:2024.01.00"))
    androidTestImplementation(dependencyNotation= "androidx.compose.ui:ui-test-junit4")

    //BUILD TYPE DEBUG
    debugImplementation(dependencyNotation= "androidx.compose.ui:ui-tooling")
    debugImplementation(dependencyNotation= "androidx.compose.ui:ui-test-manifest")
}