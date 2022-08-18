# the first stage of build will extract the layers
FROM amazoncorretto:18 as builder
ARG ARTIFACT
WORKDIR application
COPY ${ARTIFACT} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# the second stage of build will copy the extracted layers
FROM amazoncorretto:18
# Copy from previous stage
WORKDIR /opt/docker/application
COPY --from=builder \
    application/dependencies/ application/spring-boot-loader/ \
    application/snapshot-dependencies/ application/application/ ./
# Copy entry point script
COPY ./entrypoint.sh /opt/docker/application/entrypoint.sh
# Create tmp and log directory
RUN mkdir -p /app/tmp /app/log \
    && chmod 700 /app/tmp /app/log \
    && chmod 700 /opt/docker/application/entrypoint.sh
ENTRYPOINT ["bash", "-c", "/opt/docker/application/entrypoint.sh java ${JAVA_OPTS} org.springframework.boot.loader.JarLauncher"]
