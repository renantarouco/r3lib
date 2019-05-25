FROM maven:alpine

RUN apk add git

WORKDIR /home/r3lib
COPY * ./

RUN mkdir lib
RUN git submodule update --init --recursive --remote
RUN "./scripts/compile-ant-libs.sh"
RUN "./scripts/deploy-ant-libs.sh"
RUN mvn install

CMD ["/bin/sh"]