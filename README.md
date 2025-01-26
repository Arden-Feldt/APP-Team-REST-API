# APP-Team-REST-API


## Restaurant Endpoint API Documentation


---



### 1. **Get All Restaurants**
**Method:** `GET`  
**Path:** `/restaurant`  
**Description:** Retrieves a list of all restaurants.  
**Response:**
- **200 OK:** Array of Restaurant objects.

---

### 2. **Create New Restaurant**
**Method:** `POST`  
**Path:** `/restaurant`  
**Description:** Adds a new restaurant to the system.  
**Request Body:**
```json
{
  "name": "string",
  "ratings": "array",
  "price": "string"
}
```  
**Response:**
- **201 Created:** Created Restaurant object.

---

### 3. **Get Restaurant by ID**
**Method:** `GET`  
**Path:** `/restaurant/{id}`  
**Description:** Retrieves a restaurant by its ID.  
**Path Variables:**
- **id:** Long (Restaurant ID)  
  **Response:**
- **200 OK:** Restaurant object.
- **404 Not Found:** Restaurant not found.

---

### 4. **Update Restaurant by ID**
**Method:** `PUT`  
**Path:** `/restaurant/{id}`  
**Description:** Updates an existing restaurant or creates a new one if it doesn't exist.  
**Path Variables:**
- **id:** Long (Restaurant ID)  
  **Request Body:**
```json
{
  "name": "string",
  "ratings": "array",
  "price": "string"
}
```  
**Response:**
- **200 OK:** Updated Restaurant object.
- **201 Created:** New Restaurant object.

---

### 5. **Delete Restaurant by ID**
**Method:** `DELETE`  
**Path:** `/restaurant/{id}`  
**Description:** Deletes a restaurant by its ID.  
**Path Variables:**
- **id:** Long (Restaurant ID)  
  **Response:**
- **204 No Content**

---

### 6. **Add Rating to a Restaurant**
**Method:** `POST`  
**Path:** `/restaurant/{id}/rating/{rating}`  
**Description:** Adds a rating to a restaurant.  
**Path Variables:**
- **id:** Long (Restaurant ID)
- **rating:** Integer (Rating value)  
  **Response:**
- **200 OK:** Rating added.

---

### 7. **Add Restaurant by Name**
**Method:** `POST`  
**Path:** `/restaurant/name/{name}`  
**Description:** Adds a new restaurant by name if it doesn't already exist.  
**Path Variables:**
- **name:** String (Restaurant name)  
  **Response:**
- **200 OK:** Restaurant added.
- **400 Bad Request:** Restaurant already exists.

---

### 8. **Get Average Rating of a Restaurant**
**Method:** `GET`  
**Path:** `/restaurant/{id}/rating`  
**Description:** Retrieves the average rating of a restaurant.  
**Path Variables:**
- **id:** Long (Restaurant ID)  
  **Response:**
- **200 OK:** Average rating (Double).

---

### 9. **Get All Ratings of a Restaurant**
**Method:** `GET`  
**Path:** `/restaurant/{id}/ratings`  
**Description:** Retrieves all ratings for a restaurant.  
**Path Variables:**
- **id:** Long (Restaurant ID)  
  **Response:**
- **200 OK:** Array of Rating objects.

---

### 10. **Add Price to a Restaurant**
**Method:** `POST`  
**Path:** `/restaurant/{id}/price/{price}`  
**Description:** Adds or updates the price for a restaurant.  
**Path Variables:**
- **id:** Long (Restaurant ID)
- **price:** String (Price value)  
  **Response:**
- **200 OK:** Price updated.

---

### 11. **Get Restaurant Price**
**Method:** `GET`  
**Path:** `/restaurant/{id}/price`  
**Description:** Retrieves the price of a restaurant.  
**Path Variables:**
- **id:** Long (Restaurant ID)  
  **Response:**
- **200 OK:** Price (String).

---

### 12. **Get Restaurants by Price**
**Method:** `GET`  
**Path:** `/price/{price}`  
**Description:** Retrieves restaurants matching the specified price.  
**Path Variables:**
- **price:** String (Price value)  
  **Response:**
- **200 OK:** Array of Restaurant objects.
