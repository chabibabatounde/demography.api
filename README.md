# Demography
This API is used to record demographic events (Births and Deaths).
This API uses Elasticsearch to store data. We used a docker image. To configure the data source, you have to go to the file *"application.properties"* 

## Data structure ##
To store the data, we chose to create two entities. Here is their organization

*Demography.java*
```java
private String id;
private String personName;
private int value;
private String eventDate;
private Ville ville;
```

*Ville.java*
```java
private double lat;
private double lng;
private String nomVille;
```
## API Queries ##
### Create ###
To add data, we make PUT type queries. One or more data can be inserted from an array 

- Add an event : 
http://localhost:8080/Demography/save
```json
{
      "id": 1,
      "eventDate":"2019-09-25",
      "personName": "chabi rodolpho",
      "value": 1,
      "ville" :{
        "lat" : 0.02,
        "lng" : 3.005,
        "nomVille" : "Paris"
      }
  }
```

- Add multiple events : 
http://localhost:8080/Demography/saveAll


```json
[
      {
            "id": 1,
            "eventDate":"1994-05-22",
            "personName": "chabi rodolpho",
            "value": 1,
            "ville" :{
              "lat" : 0.02,
              "lng" : 3.005,
              "nomVille" : "Paris"
            }
        },
        {
            "id": 2,
            "eventDate":"2012-10-16",
            "personName": "babatounde rené",
            "value": 1,
            "ville" :{
              "lat" : 0.02,
              "lng" : 3.005,
              "nomVille" : "Paris"
            }
        }
  ]
```
### Read ###
To read the data, we have many GET request

- To count the number of registration : 
http://localhost:8080/Demography/count

- To  get record by event type: 
http://localhost:8080/Demography/findAll
```json
{
    "content": [
        {
            "id": "1",
            "personName": "chabi rodolpho",
            "value": 1,
            "eventDate": "2019-09-25",
            "ville": {
                "lat": 0.02,
                "lng": 3.005,
                "nomVille": "Paris"
            }
        },
        {
            "id": "2",
            "personName": "chabi rodolpho",
            "value": 1,
            "eventDate": "2019-09-24",
            "ville": {
                "lat": 0.02,
                "lng": 3.005,
                "nomVille": "Paris"
            }
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageSize": 3,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "facets": [],
    "aggregations": null,
    "scrollId": null,
    "maxScore": 1.0,
    "totalPages": 1,
    "totalElements": 3,
    "size": 3,
    "number": 0,
    "first": true,
    "numberOfElements": 3,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "last": true,
    "empty": false
}
```

- To  get record by event Id: 
http://localhost:8080/Demography/findById/{id}
({id} represente record identifier)
```json
{
    "id": "1",
    "personName": "chabi rodolpho",
    "value": 1,
    "eventDate": "2019-09-25",
    "ville": {
        "lat": 0.02,
        "lng": 3.005,
        "nomVille": "Paris"
    }
}
```

- To get record by name: 
http://localhost:8080/Demography/findByPersonName/{personName}

*e.g:* http://localhost:8080/Demography/findByPersonName/chabi_rodolpo
({personName} represente the person name)
```json
{
    "id": "1",
    "personName": "chabi rodolpho",
    "value": 1,
    "eventDate": "2019-09-25",
    "ville": {
        "lat": 0.02,
        "lng": 3.005,
        "nomVille": "Paris"
    }
}
```

- To get record between two dates filter by City : 
http://localhost:8080/Demography/findByVilleNomVilleAndEventDateBetween/{nomVille}/{fromDate}/{toDate}

*e.g:* http://localhost:8080/Demography/findByVilleNomVilleAndEventDateBetween/Paris/2019-09-22/2019-09-23
(
      {nomVille} represente the city name
      {fromDate} represente start date
      {toDate} represente end date
)
```json
[
    {
        "id": "3",
        "personName": "chabi rodolpho",
        "value": 1,
        "eventDate": "2019-09-22",
        "ville": {
            "lat": 0.02,
            "lng": 3.005,
            "nomVille": "Paris"
        }
    }
]```

You have also methods to : 
- get record between two dates for all cities
- get record by city
- get record by event Date for all cities

```
### Upadte ###



### Delete ###
To delete we have DELETE request like :
http://localhost:8080/Demography/delete/{Id}
