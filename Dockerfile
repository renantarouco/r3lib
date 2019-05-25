FROM maven:alpine

WORKDIR /home/r3lib
COPY lib lib
COPY scripts scripts
COPY src src
COPY * ./

RUN apk add apache-ant
RUN "./scripts/compile-ant-libs.sh"
RUN "./scripts/deploy-ant-libs.sh"
RUN mvn install

VOLUME [ "/root/.m2" ]

CMD ["/bin/sh"]