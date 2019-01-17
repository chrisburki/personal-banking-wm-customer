FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/wm-customer-service-0.1.0.jar
ADD ${JAR_FILE} wm-customer-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wm-customer-service.jar"]
#RUN mkdir /opt/application
#COPY .build/libs/wm-customer-service-0.1.0.jar /opt/application
#CMD ["java,"-jar","/opt/application/wm-customer-service-0.1.0.jar"]