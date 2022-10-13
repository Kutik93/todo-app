FROM openjdk:11
EXPOSE 8080
ADD target/todo-app-0.0.1-SNAPSHOT.jar todo-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","todo-app-0.0.1-SNAPSHOT.jar"]