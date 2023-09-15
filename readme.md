qase.url = https://app.qase.io/
qase.email = shajtorova@mail.ru
qase.password = Dbrf_110585

//файл для gradle
t
t говорит:plugins {
id 'java-library'
}

repositories {
mavenCentral()
}

dependencies {
testImplementation (
"com.codeborne😒elenide:6.12.3",
"org.junit.jupiter:junit-jupiter:5.9.3"


    )

}

tasks.withType(JavaCompile) {
options.encoding = 'UTF-8'
}

test {
useJUnitPlatform()
} 