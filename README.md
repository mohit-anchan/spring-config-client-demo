# spring-config-client-demo
Just a demo application on how to configure a Spring config client.

### Initial setup
##### 1. Assign application name
Application name is necessary for fetching app specific configs from server. Goto: ```bootstrap.properties```
```
spring.application.name=myclientapp
```
##### 2. Setup config server url
Again, goto: ```bootstrap.properties```
```
spring.cloud.config.uri=http://localhost:8888
```
##### 3. Create a config file
Goto your git directory referenced in config server 
Create a new file named : ```myclient-app-dev.yml```
Copy below properties in the file:
```
greeting: Welcome to spring client
encrypted:
    greeting: '{cipher}<your encrypted property>'
```
Note: Refer Config server on how to generate encrypted value for a property

### Operations
##### View properties
While running the client app, set the profile env to dev: ```-Dspring.profiles.active=dev```
Make sure both the server and client applications are up and running.
Make below rest calls to view properties:
```
http://localhost:8900/greeting/
http://localhost:8900/greeting/encrypted
```
##### Refresh properties
Call the actuator's refresh url to refresh any updates in server config on the fly:
```
curl --location --request POST 'http://localhost:8900/actuator/refresh'
```
