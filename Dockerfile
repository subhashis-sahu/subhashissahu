FROM openjdk:27-ea-oraclelinux9
ADD target/subhashis-sahu.jar /subhashis-sahu.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","subhashis-sahu.jar" ]
