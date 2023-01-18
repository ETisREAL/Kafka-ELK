package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class IntProducer {
    public IntProducer() {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");

        ProducerRecord producerRecord = new ProducerRecord("data", 1, 255739);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
    }
}
