## QA-Tool API Test Automation

* This is a API test automation tool based on Rest assured 
* This contain how to send get , post request and post data driven test 
* Sample mock server can use for testing 

### Pre-requires 

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

1 . To get users 

``
curl --location --request GET 'http://127.0.0.1:3000/users' \
  --header 'Date: message/rfc822' \
  --data-raw '' 
``

2 . To create user 


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
  
## Run Test 

1 . Execute as maven test 

``mvn test ``

2 . Generate Report

`` ./allure serve --port 3001 {location to prject}/allure-results``

3. Results 

![Initial view](https://user-images.githubusercontent.com/29086284/186380755-eec1c057-574f-46c5-bae6-22fdac015730.png)

![Detailed view](https://user-images.githubusercontent.com/29086284/186380867-86cfcef0-c927-4aaa-9a43-0267a4cfa6dc.png)


## Tutorials 

https://www.youtube.com/playlist?list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx

https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/

## Certification

![Certficate](https://user-images.githubusercontent.com/29086284/186381189-4ce39bb4-c857-41f6-b6fa-3e6624c35819.png)


