[MVC]: https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
[JUnit]: https://junit.org/junit5/
[JavaServlet]:https://docs.oracle.com/javaee/7/api/javax/servlet/Servlet.html
[JDBC]:https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html
[Apache Derby]:https://db.apache.org/derby/
[Tomcat]:https://tomcat.apache.org/
[Apache Derby docs]:https://db.apache.org/derby/docs/10.15/getstart/getstartderby.pdf

# Web Application that implements the `Homophonic Cipher`

### `Prereqsites`: 
- add `JUnit` into the project to run tests
- install a `Tomcat` server to run the web app
- configure a valid connection between derby driver(connector) and jdbc

### `Configurations`:
1. After having `Tomcat` on your local machine, you need to add `servlet-api.jar` into project's lib to make servlet's packages usable inside the code
2. Be aware of several issues concerning to connecting to `Apache Derby`. You can run it either using terminal or inside the IDE. Important that only one process can have a connection with a particular `database`, otherwise you won't be allowed to connect. Use either `EmbeddedDriver` or `AutoloadedDriver` to make a connection with a `database` due to `ClientDriver` doesn't work properly. To simplify working with `Apache Derby` read the [Apache Derby docs]



#
* Architecture constructed using [MVC] pattern
* Tested using [JUnit] framework
* WebApp constructed via [JavaServlet] and [Tomcat] server
* Database support using [JDBC] and [Apache Derby]
* Cross-platform