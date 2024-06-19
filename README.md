This project is a Java application based on the Jakarta EE framework, using Hibernate as a persistence provider to interact with a MySQL database. The project is structured around the MVC (Model-View-Controller) model.

The data model includes several entities, such as `Film`, `Actor`, `Director`, and `Genre`, as indicated in the `persistence.xml` file.

There is a `FilmDAO` interface that defines CRUD (Create, Read, Update, Delete) operations on the `Film` entity, as well as methods to add and remove actors from a film. The implementation of this interface, `FilmDAOImpl`, uses JPA's `EntityManager` to perform these operations.

Finally, there is a `FilmResource` class that exposes a REST API to interact with films. This API allows you to retrieve all films, get a film by its ID, create a new film, update an existing film, and delete a film.