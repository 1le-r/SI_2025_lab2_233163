
plugins {
    id 'java'
}

group 'mk.ukim.finki'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.7.0'
}

test {
    useJUnitPlatform()
}
