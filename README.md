build:
    mvn install

run:
    mvn spring-boot:run

use:
    curl -X GET -H "msg:Nanto" http://localhost:8086/rest/sayhello/
    curl -X GET -H  http://localhost:8086/rest/sayhello/Nanto