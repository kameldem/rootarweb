FROM tomcat:latest
EXPOSE 8080
COPY /target /usr/local/tomcat/webapps