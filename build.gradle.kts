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
    implementation(kotlin("reflect"))
}

application {
    mainClassName = "${project.group}.MainKt"
}

var runArgs = listOf("data/train.csv")

tasks {
    withType<Wrapper> {
        distributionType = Wrapper.DistributionType.ALL
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<JavaExec> {
        doFirst {
            args = runArgs
        }
    }
}

task("runProduction") {
    group = "application"
    dependsOn("compileKotlin")
    finalizedBy("run")

    doLast {
        runArgs = listOf("data/test.csv", "submission/result.csv")
    }
}
