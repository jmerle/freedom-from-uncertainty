import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.40"
}

group = "com.jaspervanmerle.freedomfromuncertainty"
version = "1.0.0"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

var runArgs = listOf("src/main/resources/train.csv")

tasks {
    withType<Wrapper> {
        distributionType = Wrapper.DistributionType.ALL
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<JavaExec> {
        doFirst {
            main = "${project.group}.MainKt"
            args = runArgs
        }
    }
}

task("runProduction") {
    group = "application"
    dependsOn("compileKotlin")
    finalizedBy("run")

    doLast {
        runArgs = listOf("src/main/resources/test.csv", "submission/result.csv")
    }
}
