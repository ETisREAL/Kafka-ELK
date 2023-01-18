package kafka;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;

import java.io.Serializable;
import java.util.Properties;

public class AvroSerializer {

    public <T extends Serializable> void serializeWithSchema(T data) {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        org.apache.kafka.common.serialization.StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put("schema.registry.url", "http://localhost:8081");
        KafkaProducer producer = new KafkaProducer(props);

        String key = "key1";
        String sampleSchema = "{\"type\":\"record\"," +
                "\"name\":\"myrecord\"," +
                "\"fields\":[{\"name\":\"f1\",\"type\":\"string\"}]}";
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(sampleSchema);
        GenericRecord avroRecord = new GenericData.Record(schema);

        avroRecord.put("name", data.toString());

        ProducerRecord<Object, Object> record = new ProducerRecord<>("topic1", key, avroRecord);
        try {
            producer.send(record);
        } catch(SerializationException e) {
            throw new SerializationException("Couldn't serialize. " + e);
        }
        finally {
            producer.flush();
            producer.close();
        }
    }
}

