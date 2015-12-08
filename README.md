# Simple hypermedia example with jersey2
This example demonstrates how to use the declarative hyperlink annotations.

Some examples:

<http://localhost:8080/rest/albums/1>
```json
{
    "id": "1",
    "title": "Heritage",
    "artistId": "1",
    "stockLevel": 2,
    "_links": {
        "self": {
            "href": "http://localhost:8080/rest/albums"
        },
        "artistId": {
            "href": "http://localhost:8080/rest/artist"
        }
    }
}
```

<http://localhost:8080/rest/albums>
```json
[
    {
        "id": "2",
        "title": "Deliverance",
        "artistId": "1",
        "stockLevel": 3,
        "_links": {
            "self": {
                "href": "http://localhost:8080/rest/albums"
            },
            "artistId": {
                "href": "http://localhost:8080/rest/artist"
            }
        }
    },
    {
        "id": "1",
        "title": "Heritage",
        "artistId": "1",
        "stockLevel": 2,
        "_links": {
            "self": {
                "href": "http://localhost:8080/rest/albums"
            },
            "artistId": {
                "href": "http://localhost:8080/rest/artist"
            }
        }
    }
]
```
