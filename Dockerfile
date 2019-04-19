FROM springcloudenv:v1

MAINTAINER "chuanqi"<chuanqi@outlook.com>

RUN mkdir -p /data/k8s/service

WORKDIR /data/k8s/service

COPY target/springboottest-0.0.1-SNAPSHOT.jar ./docker-boot-test.jar

CMD java -jar -Dfile.encoding=UTF-8 docker-boot-test.jar
