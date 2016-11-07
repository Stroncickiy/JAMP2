# Jamp2
# Prerequisites:

 1. MySQL  should listen on 3306 and database ‘mentorship’ should be  created as well
 2. external activeMQ broker should be started,  and tcp connector should listen on port 61616, 
 also you should add  -Dorg.apache.activemq.SERIALIZABLE_PACKAGES=* to ACTIVEMQ_OPTS  variable in   %ACTIVEMQ_HOME%\bin\activemq.bat 
 3. specify admin.mail in src\main\resources\app.properties  to be able to recieve warning mails
 4. mvn spring-boot:run
 5. localhost:8080  cradentials admin@epam.com/adminadmin 