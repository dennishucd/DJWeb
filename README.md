# DJWeb
A J2EE reference project(springmvc+json+mybatis+mysql)

##version history
1. v0.1.0 a initial java web project based on maven;
2. v0.2.0 +supporting the spingmvc: test with GET http://localhost:8080/DJWeb/api/user
3. v0.3.0 +spring+mybatis+mysql: test with POST http://localhost:8011/DJWeb/api/user/login
   and POST body are "{"loginName":"admin", "passwd":"123456"}".
4. v0.4.0 +velocity
(1) add maven support velocity in pom.xml;
(2) add config to -servlet.xml;
(3) add resovler to -servlet.xml.
(4) add cost time logging interceptor support

