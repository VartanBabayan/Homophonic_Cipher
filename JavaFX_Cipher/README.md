[MVC]: https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
[JUnit]: https://junit.org/junit5/
[JavaFX]:https://openjfx.io/
[SceneBuilder]:https://gluonhq.com/products/scene-builder/
[UIController]:src/main/java/pl/polsl/lab/vartan/babayan/controllercipher/UIController.java
[UIControllerFXML]:src/main/resources/pl/polsl/lab/vartan/babayan/UIController.fxml

# JavaFX Application that implements the `Homophonic Cipher`
### The UI has been constructed using [SceneBuilder] and connected via [UIController] inside the code
### Actually [UIController] is a backend while frontend is represented by [UIControllerFXML] and interprets by [JavaFX]

### `Prereqsites`: 
- add `JUnit` into the project to run tests
- add `JavaFX` support inside an IDEA you're working on

#
* Architecture constructed using [MVC] pattern
* Tested using [JUnit] framework
* Implemented UI with [JavaFX]
* Cross-platform