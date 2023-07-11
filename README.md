# study_kafka
cd docker/
docker compose up -d
docker-compose exec kafka kafka-topics --create --topic my-topic --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
docker-compose exec kafka kafka-topics --describe --topic my-topic --bootstrap-server kafka:9092 


