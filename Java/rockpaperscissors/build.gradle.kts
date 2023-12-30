plugins {
    id("org.openjfx.javafxplugin") version "0.1.0"
}

version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

application {
    mainModule.set("com.hirrao.rockpaperscissors")
    mainClass.set("com.hirrao.rockpaperscissors.Main")
}

javafx {
    version = "21.0.1"
    modules = listOf("javafx.controls", "javafx.fxml")
}

tasks.test {
    useJUnitPlatform()
}
