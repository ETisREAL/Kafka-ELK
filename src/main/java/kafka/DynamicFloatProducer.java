package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.sql.Time;
import java.util.Properties;
import java.util.Timer;

public class DynamicFloatProducer {

    public DynamicFloatProducer(Float floatingN) {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.FloatSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.FloatSerializer");

        ProducerRecord producerRecord = new ProducerRecord("topic", floatingN, floatingN);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
    }
}
