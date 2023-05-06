run: 
	mvn spring-boot:run	

run-debug: 
	mvn spring-boot:run -e

see-db:
	firefox http://localhost:8080/h2-console
	
test: 
	mvn test
	
