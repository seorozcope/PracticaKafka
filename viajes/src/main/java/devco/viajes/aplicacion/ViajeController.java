package devco.viajes.aplicacion;

import devco.viajes.dominio.entidades.Viaje;
import devco.viajes.infraestructura.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="viaje")
public class ViajeController {
    @Autowired
    private KafkaSender publicador;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Viaje> crearViaje(@RequestBody Viaje viaje){
       // publicador.enviarMensaje(viaje.getTipo(),viaje.getDestino());
        publicador.enviarMensajeClave(viaje.getTipo(),"a",viaje.getDestino());
        return new ResponseEntity<Viaje>(viaje, null , HttpStatus.OK);
    }



}
