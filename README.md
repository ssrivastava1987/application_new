# application_new

##The Application contains multiple endpoints related to users and their personal details.
I have used the in-memory h2 db to add create tables and inserted data to it.
File used : data.sql

Commands which can be used to build it locally.
cd <local directory where the code is kept>
mvn clean install
mvn spring-boot:run

Added curl for all endpoint in below files:
curl.sh

Endpoint details:

Get All Users:
Method : GET
URL : /getAllUsers

curl -XGET 'http://localhost:8086/getAllUsers'

Get User by id:
Method : GET
URL : /getById/{id}

curl -XGET 'http://localhost:8086/getById/2'

Get User by email:
Method : GET
URL : /getByEmail/{email}

curl -XGET 'http://localhost:8086/getByEmail/shaq@lakers.com'

Get Users by name:
Method : GET
URL : /getByName?name=<name>

curl -X GET "http://localhost:8086/getByName?firstname=Shaq&lastname=Oneil"

Get Users by username:
Method : GET
URL : /getByUserName/{username}

curl -XGET 'http://localhost:8086/getByUserName/lakers01'

Get Specific User by username/email:
Method : POST
URL : /getUser
Request :
{
  "username": "lakers01"
}

curl -XPOST -H "Content-type: application/json" -d '{"username": "lakers01"}' 'http://localhost:8086/getUser'

OR
{
  "email": "shaq@lakers.com"
}

curl -XPOST -H "Content-type: application/json" -d '{"email": "shaq@lakers.com"}' 'http://localhost:8086/getUser'

OR

Preference will be given to username
{
  "username": "lakers01",
  "email": "shaq@lakers.com"
}

curl -XPOST -H "Content-type: application/json" -d '{"username": "lakers01","email": "shaq@lakers.com"}' 'http://localhost:8086/getUser'

Get Users living on specific street : commented the like query as specific word was given.
Method : POST
URL : /getUserByStreet
Request :
{
   "street": "123 San Diego Lane"
}

curl -XPOST -H "Content-type: application/json" -d '{"street": "123 San Diego Lane"}' 'http://localhost:8086/getUserByStreet'

