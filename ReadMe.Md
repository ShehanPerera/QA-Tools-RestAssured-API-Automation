##QA-Tool API Test Automation

* This is a API test automation tool based on Rest assured 
* This contain how to send get , post request and post data driven test 
* Sample mock server can use for testing 

##Pre-requires 

java : 1.8
allure 
maven  -v : 3.6.1 
node -v : v10.23.0
npm -v : 6.14.8

### Run mock server

1. Go to ``mock-server``
2. Run ``npm i json-server``
3. Run ``node runServer.js``
3. When send requests for mock-server , mock.logs will update for each requests

### Mock server sample requests

1. To get users 

``
curl --location --request GET 'http://127.0.0.1:3000/users' \
  --header 'Date: message/rfc822' \
  --data-raw '' 
``
2. To create user 

``
curl --location --request POST 'http://127.0.0.1:3000/users' \
  --header 'Date: message/rfc822' \
  --header 'Content-Type: application/json' \
  --data-raw '{
          "username": "RestUser",
          "password": "123",
          "name": "REST",
          "usertype": "restuser"
  }'
  ``
##Run Test 

1. Execute as maven test 

``mvn test ``

2. Generate Report

`` ./allure serve --port 3001 {location to prject}/allure-results``