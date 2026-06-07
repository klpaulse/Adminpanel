# Byggesteg:
# Vi bruker et ferdig Docker-image som har både Maven og Java 21.
# Dette brukes kun til å bygge Spring Boot-prosjektet til en .jar-fil.
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Setter arbeidsmappen inni Docker-containeren.
# Alt vi kopierer inn havner under /app.
WORKDIR /app

# Kopierer hele Spring Boot-prosjektet inn i containeren.
# Dette forutsetter at Dockerfile ligger i samme mappe som pom.xml.
COPY . .

# Bygger prosjektet med Maven.
# -DskipTests betyr at tester hoppes over under deploy, så builden går raskere.
RUN mvn clean package -DskipTests

# Kjøresteg:
# Vi bruker et mindre Java 21-image for å kjøre appen.
# Her trenger vi ikke Maven lenger, bare Java runtime.
FROM eclipse-temurin:21-jre

# Setter arbeidsmappen for selve appen.
WORKDIR /app

# Kopierer den ferdigbygde .jar-filen fra build-steget.
# Den får navnet app.jar inni containeren.
COPY --from=build /app/target/*.jar app.jar

# Dokumenterer at Spring Boot vanligvis bruker port 8080.
# Render setter faktisk port via environment variable PORT.
EXPOSE 8080

# Starter Spring Boot-applikasjonen.
CMD ["java", "-jar", "app.jar"]