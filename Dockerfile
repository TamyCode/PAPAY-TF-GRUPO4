FROM amazoncorretto:17-alpine-jdk
MAINTAINER ESMERALDA
COPY target/demoPapayTF-0.0.1-SNAPSHOT.jar DemoPapayTF.jar

ENTRYPOINT ["java", "-jar","/DemoPapayTF.jar"]