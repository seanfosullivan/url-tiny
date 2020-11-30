# url-tiny

## Deployment Steps
* Maven Install url-tiny. The simplest way is through [Eclipse](https://www.eclipse.org/downloads/) (Run > Run As > Maven Install)
* Install [Docker](https://docs.docker.com/docker-for-windows/install/)
* enter command line at project root 
* In command line run: docker build -f Dockerfile -t url-tiny .
* In command line run: docker run -p 3000:3000 url-tiny

## How to use url-tiny
* I would recommend downloading [Postman](https://www.postman.com/downloads/) for ease of use.
* To run url-tiny after deployment, in Postman POST to localhost:3000/run with the body text containing a valid in full http website such as https://www.google.com/
* A Short URL will then be generated and replied in the form of localhost:3000/s/{8 random characters}
* Entering the new short URL in a browser will redirect to long url 
entering a get request localhost:3000/urls will return the database of URLs

## Technologies used
* Java
* Docker
* Apache Derby Database
* Java Persistence API
* Spring Boot
