cd \
cd C:\Users\CampbellD\git\spring-boot-security-saml
call mvn clean
call mvn package -U
cd target
call cf push ProdSSoPOC -p spring-boot-security-saml-sample-1.4.0.RELEASE.war
IF "%1"=="logs" (call bluemix app logs ProdSSoPOC) 
cd ..


