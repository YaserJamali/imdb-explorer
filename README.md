
# IMDB Explorer

This project was created for Globox's human resource demand.

### Dataset

(https://www.imdb.com/interfaces).

### API Endpoints

#### VWSameDirectorWriterController

•  [**Endpoint**]: `/same-director-writer`

•  [**Description**]: APIs related to directors and writers who are the same person and alive.

•  [**Method**]: `@GetMapping("/alive-director-writer")`


#### VWCastTitleController

•  [**Endpoint**]: `/titles-of-casts`

•  [**Description**]: APIs related to movies with two or more same actors.

•  [**Method**]: `@GetMapping("/movie-writer-director-alive")`


#### VWBestGenresOfMoviesController

•  [**Endpoint**]: `/best-movies-of-the-year`

•  [**Description**]: APIs related to the best movies of the year based on IMDb ranking.

•  [**Method**]: `@GetMapping("/genre/{genre}")`


### Swagger Documentation

You can access the Swagger documentation for this project at the following URL:

[Swagger UI](http://localhost:8585/swagger-ui.html)