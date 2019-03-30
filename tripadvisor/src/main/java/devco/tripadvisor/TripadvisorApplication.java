package devco.tripadvisor;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class TripadvisorApplication {


	public static void main(String[] args) {
		SpringApplication.run(TripadvisorApplication.class, args);
		Properties propiedades=new Properties();
		//documentación de propiedades de kafka: https://kafka.apache.org/documentation/#producerconfigs
		propiedades.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		propiedades.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		propiedades.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		propiedades.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true"); //Cuando recibe el mensaje siemore responde el commit
		propiedades.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
		propiedades.put(ConsumerConfig.GROUP_ID_CONFIG,"1");

		KafkaConsumer<String,String> kafkaConsumer=new KafkaConsumer<String, String>(propiedades);
		kafkaConsumer.subscribe(Arrays.asList("hoteles"));

		while (true){
			Duration duracion=Duration.ofSeconds(1);
			ConsumerRecords<String,String> consumerRecords = kafkaConsumer.poll(duracion);
			for(ConsumerRecord<String,String> consumerRecord:consumerRecords){
				System.out.println("Particion: "+consumerRecord.partition()+
						" Offset: " + consumerRecord.offset() +
						" Key: " + consumerRecord.key() +
						" Value: " + consumerRecord.value());
			}
		}
	}

}
