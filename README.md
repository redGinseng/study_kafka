# study_kafka
# Github
https://github.com/onlybooks/kafka2

# Use
cd docker/
docker compose up -d
docker-compose exec kafka kafka-topics --create --topic kafka-topic-01 --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
docker-compose exec kafka kafka-topics --describe --topic kafka-topic001 --bootstrap-server kafka:9092 


