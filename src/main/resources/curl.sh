curl -XGET 'http://localhost:8086/getAllUsers'| json_pp
curl -XGET 'http://localhost:8086/getById/2'| json_pp
curl -XGET 'http://localhost:8086/getByEmail/shaq@lakers.com'| json_pp
curl -X GET "http://localhost:8086/getByName?firstname=Shaq&lastname=Oneil"| json_pp
curl -XGET 'http://localhost:8086/getByUserName/lakers01'| json_pp
curl -XPOST -H "Content-type: application/json" -d '{"username": "lakers01"}' 'http://localhost:8086/getUser'| json_pp
curl -XPOST -H "Content-type: application/json" -d '{"email": "shaq@lakers.com"}' 'http://localhost:8086/getUser'| json_pp
curl -XPOST -H "Content-type: application/json" -d '{"username": "lakers01","email": "shaq@lakers.com"}' 'http://localhost:8086/getUser'| json_pp
curl -XPOST -H "Content-type: application/json" -d '{"street": "123 San Diego Lane"}' 'http://localhost:8086/getUserByStreet'| json_pp