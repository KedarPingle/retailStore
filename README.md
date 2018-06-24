# MO Retail Store

# Introduction:
RESTFULL services for a checkout counter of an online retail store
Final invoice details the Localized welcome message, all purchase items, costs, applicable tax and total payable amount

# Highlights
- Developed as a SpringBoot Microservice
- Uses in memory h2 database (non persistent)
- Secured with basic authentication
- Internationalization with LocalizationInterceptor and LocaleResolver (Only Invoice API)
- Unit tested with SpringBoot Repository test and SpringBoot Service test using Mockito
- Self sufficient project which can be built, deployed and tested

# REST endpoints
Following operations can be done on Products
## Product
*  GET /product/all             - List all products
*  GET /product/{resourceId}    - List a particular product
*  POST /product/add            - Add new product

## Purchase
*  POST /purchase/generate_new_bill         - Create a new entry for a new bill
*  POST /purchase/add_scanned_product       - Add a product to this bill
*  POST /purchase/remove_scanned_product    - Remove a product from this bill
*  GET /purchase/invoice/{billId}           - Calculate final bill and generate invoice

 Use basic authentication with username/password as kedar/password
 Optionally, The locale can be passed along with header e.g "Accept-Language" : "DE"

# Execution instructions

* Clone: https://github.com/KedarPingle/retailStore.git
* Application can be executed from project location using "mvn spring-boot:run" OR
  Create executable jar: mvn package
  Go to target folder
  Run : java -jar retailStore-0.0.1-SNAPSHOT.jar
* Swagger: http://localhost:8080/swagger-ui.html
* Authentication credential: kedar/password