FROM anapsix/alpine-java:8_jdk

RUN apk update && \
    apk add maven

WORKDIR /usr/src/

CMD ["./verify.sh"]
