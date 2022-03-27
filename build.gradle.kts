import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	kotlin("plugin.jpa") version "1.4.21"
	jacoco
}

group = "com.hmv"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

jacoco{
	toolVersion = "0.8.7"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.apache.commons:commons-lang3:3.12.0")
	implementation("commons-io:commons-io:2.11.0")
	implementation("io.jsonwebtoken:jjwt:0.9.1")
	implementation("com.sun.xml.security:xml-security-impl:1.0")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("org.flywaydb:flyway-core:8.5.4")
	developmentOnly("org.springframework.boot:spring-boot-devtools")


	runtimeOnly("org.postgresql:postgresql")
	testImplementation ("org.junit.jupiter:junit-jupiter")
	testImplementation ("io.mockk:mockk:1.9.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test"){
		exclude(group= "org.junit.vintage", module ="junit-vintage-engine")
	}
	testImplementation("org.mock-server:mockserver-client-java:5.9.0")
	testImplementation("org.mock-server:mockserver-netty:5.9.0")
	testImplementation (group= "com.h2database", name= "h2", version= "1.4.200")
}

val excludesPath:Iterable<String> = listOf(

)
tasks.jacocoTestReport{
	reports{
		html.destination = file("$buildDir/jacocoHtml")
		xml.isEnabled = true
		csv.isEnabled = false
		html.isEnabled = true
	}

	classDirectories.setFrom(
			sourceSets.main.get().output.asFileTree.matching{
				exclude(excludesPath)
			}
	)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
