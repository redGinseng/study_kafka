import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

//프로듀서의 전송방법 2. 동기 전송
public class ProducerAsync {

    public static void main(String[] args) {
        Properties props = new Properties(); //Properties 오브젝트를 시작합니다.
        props.put("bootstrap.servers",
            "localhost:29092"); //브로커 리스트를 정의합니다. 하나만 넣자
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        try {
            // 예제에서는 브로커가 여러개라서 비동기로 동작하는데, 내 로컬에서는 그저 동기일뿐..
            for (int i = 0; i < 3; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("kafka-basic01",
                    "Apahce Kafka is a distributed Streaming platform - " + i);
                 producer.send(record, new ProducerCallback(record));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }

    }

}
