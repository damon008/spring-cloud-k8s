#FROM 10.10.8.100:5000/bitacube/order-service

FROM openjdk:8-jdk-alpine
RUN wget http://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz
RUN mkdir -p /var/local/
RUN tar -zxvf apache-maven-3.5.4-bin.tar.gz -C /var/local/
ENV MAVEN_HOME /var/local/apache-maven-3.5.4
RUN ls -l $MAVEN_HOME
ENV PATH $PATH:$MAVEN_HOME/bin
RUN echo $PATH
RUN echo "maven success"

COPY src src
COPY pom.xml pom.xml
RUN mvn clean package
RUN mv target/order-service.jar order-service.jar
RUN rm -rf src
RUN rm pom.xml
CMD ["sh", "-c", "nohup java $JAVA_OPTS -jar order-service.jar", "&"]