app-run: db-start
	mvn spring-boot:run

db-bash:
	docker exec -it trash-treasure-db psql --username mysql trash_treasure

db-build: setup-env-vars
	docker compose build && docker compose up --no-start

db-install: db-build db-start
	docker compose exec db bash /docker-entrypoint-initdb.d/install_database.sh

db-start: db-stop
	docker compose up -d --no-recreate

db-status:
	mvn liquibase:status
	
db-stop:
	docker compose stop

db-watch: db-stop
	docker compose up --no-recreate

install: install-external-dependencies db-install

setup-env-vars:
	cp .env.dev .env

test: db-start
	mvn test