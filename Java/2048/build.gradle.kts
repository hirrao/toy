plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
}

java{
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("com.hirrao.game.main.Main")
    mainModule.set("com.hirrao.game")
}

javafx {
    version = "21.0.1"
    modules("javafx.controls", "javafx.fxml")
}