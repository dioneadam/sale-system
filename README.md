## Sales System  

A basic version of a sales system, with some CRUD operations

## How to use

- First, you will need start the Postgres database.
- the `docker-compose.yml` contains that, so you just need to run.
  
```
docker-compose up db
```

- With the database up, you can run the application with gradle

```
./gradlew clean run
```

## API Endpoints


## Products
##### @POST /product  ` create a product`
```
{
  "name":"arroz",
  "price":"21.90"
}
```
##### @PUT /product/{id}  ` update a product`
```
{
  "name":"arroz",
  "price":"15.90"
}
```
##### @DELETE /product/{id}  ` delete a product`

## Salesman
##### @GET /salesman/{id} ` find a salesman`
##### @DELETE /salesman/{id}  ` delete a salesman`
##### @POST /salesman  ` create a salesman`
```
{
  "name":"salesman name"
}
```

##### @PUT /salesman/{id}  ` update a salesman`
```
{
  "name":"name to update"
}
```

## Sales
##### @POST /sale  ` create a sale`
```
{
  "salesman": {
    "registration":"a4325cbc-ed12-4ef2-94ff-d5fb5f3fdf89"
  },
  "products":[
    {
      "id":"97182023-1790-46dd-95c9-896d461a8289" 
    },
    {
      "id":"97182023-1790-46dd-95c9-896d461a8289" 
    }
  ]
}
```

### statistics
##### @GET /statistic/products/sales ` return a list of products ordered by the highest number of sales`
##### @GET /statistic/salesmen/sales  ` return a list of salesmen ordered by the highest number of sales`
##### @GET /statistic/salesmen/amount ` return a list of salesmen ordered by the highest amount in sales`


## Technologies used
- Micronaut
- Hibernate/Jpa
- Gradle
- Junit/Mockito
- Flyway

