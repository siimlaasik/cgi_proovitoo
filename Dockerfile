FROM adoptopenjdk/openjdk21
WORKDIR /app

COPY target/cgi_proovitoo.jar /app

EXPOSE 8080

CMD ["java", "-jar", "your-application.jar"]
