import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.satyajitbiswal.crypto"
    compileSdk = 34

    buildFeatures{
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.satyajitbiswal.crypto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.satyajitbiswal.crypto.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        val properties = Properties()

        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField ("String","API_KEY","\"${properties.getProperty("API_KEY")}\"")
    }

    buildTypes {
        debug {
            buildConfigField ("String", "API_URL", "\"http://api.coinlayer.com/\"")
        }
        release {
            buildConfigField ("String", "API_URL", "\"http://api.coinlayer.com/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:4.13.2")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    //Mockito
    testImplementation ("org.mockito:mockito-core:4.0.0")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    //navigation testing
    androidTestImplementation ("androidx.navigation:navigation-testing:2.7.6")
    //hilt testing
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.44")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Splash Api
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //live data
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.4")

    //Compose Navigation
    implementation ("androidx.navigation:navigation-compose:2.7.6")

    //Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-compiler:2.48")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    //Coil
    implementation("io.coil-kt:coil-compose:1.3.2")

    // material icons
    implementation ("androidx.compose.material:material-icons-extended")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")

    //Paging 3
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation ("androidx.paging:paging-compose:3.3.0-alpha02")

    //Accompanist
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.27.0")
}