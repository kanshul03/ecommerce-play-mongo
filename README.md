## E-commerce Rest API using Java Play framework and Mongodb.

use following path to check out inventory/all the products - 

* GET             /product/
* GET             /product/:id
* POST            / product/
* PUT             /product/
* DELETE          /product/:id

---

use following paths for cart -
* POST            /cart/
* GET             /cart/:userId
* PUT             /cart/:userId/
* DELETE          /cart/:userId/



Json syntax for product API - 
```
{
  "id": "003",
  "title": "Oneplus 3 Mobile Phone",
  "quantity": 10,
  "price": 599.0,
  "categories": [
		"mobile/5G",
		"Oneplus"
	]
}
```

---

Json Syntax for Cart Api - 
```
{
	"user_id": "ansh",
  "products": [{
  "id": "002",
  "title": "Oneplus 2 Mobile Phone",
  "price": 599.0
		}],
	"quantity": {"002": 2}
}
```
