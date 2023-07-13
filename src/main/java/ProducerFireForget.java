import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

//프로듀서의 전송방법 1. 메시지를 보내고 확인하지 않기
public class ProducerFireForget {

    // 1. Properties 객체 생성
    // 2. 브로커 리스트 정의
    // 3. 브로커 리스트 정의메시지 키와 밸류는 문자열 타입이므로 카프카의 기본 StringSerialize2.
    // 4. Properties 객체를 전달해 새 프로듀서 생성
    // 5. ProducerRecord 객체 생성
    // 6. Send() 메소드를 사용해 메시지를 전송한 후, 자바 Future 객체로 RecordMetadata를 리턴
    // 그러나, 리턴값을 무시하므로 메시지가 성공적을 발송했는지는 모름
    // 7. 카프카 브로커에게 메시지를 전송한 후의 에러는 무시하지만, 전송 전의 에러는 예외처리 가능
    // 8. 프로듀서 종료
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers",
            "localhost:29092");
        props.put("group.id", "kafka-consumer-01");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        try {
            for (int i = 0; i < 3; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("kafka-basic01",
                    "Apahce Kafka is a distributed Streaming platform - " + i);
                producer.send(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

}
