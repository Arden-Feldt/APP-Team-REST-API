# APP-Team-RESTaurant-API

My submission to UNC App Team's backend developer take home assignment.

The REST API is written in [Java](https://www.java.com/en/), and uses [Spring](https://spring.io/) as its framework. 
I also [scraped](https://chromewebstore.google.com/detail/yelp-scraper/cbmhmapejkobbbmhdlpjmiljbfgnfknc?hl=en)
Yelp review data to populate my API's database with the top 100 most popular restaurants in Chapel Hill, taking into
account their ratings and price range ("$"-"$$$").

Before this I had never made an API, I didn't know what REST API meant, and had never touched Spring.
I am thankful for all this opportunity has taught me: I can finally spell restuarant.

---

## Design Decisions & Choice of Tools

### [Spring](https://spring.io/)
After some research Spring was the clear choice for framework. Spring is the industry standard for
REST APIs and web services in Java. Java is my bread and butter and made this choice a simple one. It's ability to
autoconfigure application components, reducing boilerplate configuration was critical as I worked through this project 
with limited time. 

### [Maven](https://maven.apache.org/)
Maven provided easy dependency management and the ability to extend my work and add new 
features.

### [Yelp](https://www.yelp.com/) and [Yelp Scraper](https://chromewebstore.google.com/detail/yelp-scraper/cbmhmapejkobbbmhdlpjmiljbfgnfknc?hl=en)
As a Chapel Hill local, I have lots of opinions on the restaurants here. Additionally, as a Stats major I wanted to 
bring in some outside data. I decided having the API start up pre-populated with the top 100 restaurants in Chapel Hill
was a perfect bit of functional flair. It also pushed me to implement price ranges, which ended up being cool. I
scraped the data using Yelp Scraper, and 
limited my data to the top 100 food selling establishments within a short driving distance of my home according to
Yelp.

### [Postman](https://www.postman.com/)

Popular in industry, Postman was the clear choice for me to test and interact with my 
RESTful API endpoints, streamline API development, and ensure the functionality of HTTP requests and responses during 
development.

---

## Restaurant Endpoint API Documentation
Find all API endpoint documentation in [API.md](https://github.com/Arden-Feldt/APP-Team-REST-API/blob/95b8bb6c4287dc687d5d8bd258b0152620fd3b6e/API.md).

---
## Run and Test API
To start the API up you've got a few options. Working inside an IDE, you can just run RestaurantApplication. If that's 
not your speed take to the terminal and let Maven and Spring do the heavy lifting.

```
./mvnw clean spring-boot:run
```

I strongly recommend you use Postman to engage with this API. Below are the export of all my available requests from
Postman.

```json
{
	"info": {
		"_postman_id": "0beee220-262a-4134-96a1-0887fa919f29",
		"name": "New Collection",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "41547154"
	},
	"item": [
		{
			"name": "Add Rating",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/:id/rating/:rating",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						":id",
						"rating",
						":rating"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						},
						{
							"key": "rating",
							"value": "3"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Restaurants",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Single Restaurant",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/:id",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						":id"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Add Restaurant",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/name/Alfredos",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						"name",
						"Alfredos"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Single Restaurant Rating",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/:id/rating",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						":id",
						"rating"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Single Restaurant Ratings",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/:id/ratings",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						":id",
						"ratings"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Add Price",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/:id/price/:price",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						":id",
						"price",
						":price"
					],
					"variable": [
						{
							"key": "id",
							"value": "2"
						},
						{
							"key": "price",
							"value": "$$"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Get Price",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/1/price",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						"1",
						"price"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get All of a Price",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/price/:price",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"price",
						":price"
					],
					"variable": [
						{
							"key": "price",
							"value": "$$"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Delete Restaurant",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/restaurant/:id",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"restaurant",
						":id"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		}
	]
}
```
