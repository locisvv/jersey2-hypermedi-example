# Simple hypermedia example with jersey2
This example demonstrates how to use the declarative hyperlink annotations.

Some examples:

<http://localhost:8080/rest/albums/1>   Accept:application/hal+json
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

<http://localhost:8080/rest/albums>   Accept:application/hal+json
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
# Running the Example

1. Open this project in Intellij.
2. Create new local tomcat Run/Debug confihuration.
3. Add new Build Artifacts in the "Before launch: Make, Build Artifacts"  and select "jersey-declarative-linking:war exploded".
5. Select available tomcat version.
6. Open deployment tab and also add "jersey-declarative-linking:war exploded".
7. Save, close and now you can run this project.
