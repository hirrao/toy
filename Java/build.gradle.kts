plugins {
  java
  application
}

allprojects{
  group = "com.hirrao"
  repositories {
    mavenCentral()
    gradlePluginPortal() 
  }
}

subprojects{
  apply{
    plugin("java")
    plugin("application")
  }
  
  tasks.withType <JavaCompile> {
    options.encoding = "UTF-8"
  }  
}
