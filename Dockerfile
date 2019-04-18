FROM springcloudenv:v1

MAINTAINER by xuda

RUN mkdir -p /data/k8s/springboottest

WORKDIR /data/k8s/springboottest

COPY target/springboottest-0.0.1-SNAPSHOT.jar ./springboottest.jar

CMD java -jar springboottest.jar

