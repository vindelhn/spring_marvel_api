# Sopring Boot MarvelAPI + MySQL + Docker

Documentación Marvel:
>  [https://developer.marvel.com/docs](https://developer.marvel.com/docs)


Documentación Swagger:
>  [http://localhost:8080/swagger-ui/index.html#](http://localhost:8080/swagger-ui/index.html#)


1) Ejecutar Docker:
> docker compose up

2) Utilizar autenticación basica en las llamadas a los endpoints
> usuario: admin  password: admin






### APIs endpoints
GET http://localhost:8080/marvel/api/v1/characters [lista los personajes]

GET http://localhost:8080/marvel/api/v1/characters/byname [lista los personajes por nombre]

GET http://localhost:8080/marvel/api/v1/characters/{characterId} [lista los personajes por id]

GET http://localhost:8080/marvel/api/v1/characters/{characterId}/description [descripcion de personajes por id]

GET http://localhost:8080/marvel/api/v1/characters/{characterId}/comics [listado de comics de personajes por id]

GET http://localhost:8080/marvel/api/v1/characters/{characterId}/fullcomics [listado de todos comics de persinaje por id]

GET http://localhost:8080/marvel/api/v1/comics/{comicId} [listado comics por id]

GET http://localhost:8080/marvel/api/v1/usersearchs [listado busquedas de usuario]

GET http://localhost:8080/marvel/api/v1/usersearchs/{username} [listado busquedas por usuario]

