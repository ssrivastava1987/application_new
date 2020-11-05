# API Description

The Application contains multiple endpoints related to users and their personal details.<br/>
I have used the in-memory h2 db to add create tables and inserted data to it.<br/>
File used : data.sql<br/>

Commands which can be used to build it locally.<br/>
cd [local directory where the code is kept]<br/>
mvn clean install<br/>
mvn spring-boot:run<br/>

Added curl for all endpoints:<br/>
curl.sh<br/>

Endpoint details:<br/>

Get All Users:<br/>
Method : GET<br/>
URL : /getAllUsers<br/>

curl -XGET 'http://localhost:8086/getAllUsers'<br/>

Get User by id:<br/>
Method : GET<br/>
URL : /getById/{id}<br/>

curl -XGET 'http://localhost:8086/getById/2'<br/>

Get User by email:<br/>
Method : GET<br/>
URL : /getByEmail/{email}<br/>

curl -XGET 'http://localhost:8086/getByEmail/shaq@lakers.com'<br/>

Get Users by name:<br/>
Method : GET<br/>
URL : /getByName?name=<name><br/>

curl -X GET "http://localhost:8086/getByName?firstname=Shaq&lastname=Oneil"<br/>

Get Users by username:<br/>
Method : GET<br/>
URL : /getByUserName/{username}<br/>

curl -XGET 'http://localhost:8086/getByUserName/lakers01'<br/>

Get Specific User by username/email:<br/>
Method : POST<br/>
URL : /getUser<br/>
Request :<br/>
{<br/>
  "username": "lakers01"<br/>
}<br/>

curl -XPOST -H "Content-type: application/json" -d '{"username": "lakers01"}' 'http://localhost:8086/getUser'<br/>

OR<br/>
{<br/>
  "email": "shaq@lakers.com"<br/>
}<br/>

curl -XPOST -H "Content-type: application/json" -d '{"email": "shaq@lakers.com"}' 'http://localhost:8086/getUser'<br/>

OR<br/>

Preference will be given to username<br/>
{<br/>
  "username": "lakers01",<br/>
  "email": "shaq@lakers.com"<br/>
}<br/>

curl -XPOST -H "Content-type: application/json" -d '{"username": "lakers01","email": "shaq@lakers.com"}' 'http://localhost:8086/getUser'<br/>

Get Users living on specific street : commented the like query as specific word was given.<br/>
Method : POST<br/>
URL : /getUserByStreet<br/>
Request :<br/>
{<br/>
   "street": "123 San Diego Lane"<br/>
}<br/>

curl -XPOST -H "Content-type: application/json" -d '{"street": "123 San Diego Lane"}' 'http://localhost:8086/getUserByStreet'<br/>

