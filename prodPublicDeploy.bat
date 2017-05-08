Setlocal
SET HTTP_PROXY=204.40.194.129:3128
SET HTTPS_PROXY=204.40.194.129:3128
cd \
cd C:\_Projects\BlueMix\git\spring-boot-security-saml
call mvn clean
call mvn package -U
cf logout
cf login -u David.campbell@ontario.ca -p Meaghan1!!** -a https://api.ng.bluemix.net -o "Cluster A" -s "Cluster Test Apps"
cd target
call cf push SSoPOC -p spring-boot-security-saml-sample-1.4.0.RELEASE.war
IF "%1"=="logs" (call cf logs SSoPOC) 
cd ..
EndLocal