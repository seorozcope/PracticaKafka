package devco.viajes.infraestructura.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void enviarMensaje(String topico, String mensaje){
        kafkaTemplate.send(topico,mensaje);
    }
    public void enviarMensajeClave(String topico, String clave, String mensaje){
        kafkaTemplate.send(topico,clave, mensaje);
    }
}
