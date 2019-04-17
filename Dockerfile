FROM springboot-test:v1

MAINTAINER by xuda

RUN mkdir -p /home/xuda/springboottest

WORKDIR /home/xuda/springboottest

COPY target/springboottest-0.0.1-SNAPSHOT.jar ./springboottest.jar

CMD java -jar springboottest.jar

