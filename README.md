## build:
    mvn install

run:
    mvn spring-boot:run

use:
   [//]: Obsolete below:
   [//]: curl -X GET -H "msg:Nanto" http://localhost:8086/rest/sayhello/
   [//]: curl -X GET -H  http://localhost:8086/rest/sayhello/Nanto

    add a member:

   curl -X POST -d "{ \"firstName\": \"Antony\", \"lastName\": \"Caprio\", \"occupation\": \"Marketing\", \"age\": 35}"
                    -H "msg:Nanto" -H "Content-Type:application/json" http://localhost:8086/rest/clubmembers/

    get all members:

     curl -X GET http://localhost:8086/rest/clubmembers/