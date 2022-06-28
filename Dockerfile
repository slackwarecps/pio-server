FROM alpine:3.14

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk11 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/*

ENV AMBIENTE="--server.port=8077"
ENV SPRING_BOOT_VM_OPTIONS="-server -d64 -Xms512m -Xmx1g -Xmn256m -XX:+UseParallelGC"
ENV APP_NAME="pio-server-0.0.1-SNAPSHOT"

WORKDIR /opt/aplicacao
#COPY target/*.jar app.jar
COPY build/libs/$APP_NAME.jar app.jar
COPY start.sh .
RUN chmod a+x start.sh

RUN echo AMBIENTE= $AMBIENTE

CMD [ "/bin/bash", "-c", "./start.sh"]

