FROM openjdk:11
ADD ./target/coin_calculator-0.0.1-SNAPSHOT.jar /usr/src/coin_calculator-0.0.1-SNAPSHOT.jar
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=8080,server=y,suspend=n
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "coin_calculator-0.0.1-SNAPSHOT.jar"]

