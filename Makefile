db-bash:
	docker exec -it trash-treasure-db psql --username mysql trash_treasure

db-build: setup-env-vars
	docker compose build && docker compose up --no-start

db-drop:
	docker exec trash-treasure-db psql --username mysql trash_treasure -c "DROP SCHEMA public CASCADE; CREATE SCHEMA public;"

db-install: db-build db-start
	docker compose exec db bash /docker-entrypoint-initdb.d/install_database.sh

db-start: db-stop
	docker compose up -d --no-recreate
	
db-stop:
	docker compose stop

db-watch: db-stop
	docker compose up --no-recreate

run: db-start
	mvn spring-boot:run

run-debug: db-start
	mvn spring-boot:run -e

setup-env-vars:
	cp .env.dev .env

test: db-start
	mvn test

