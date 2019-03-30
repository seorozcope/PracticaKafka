package devco.viajes.aplicacion;

import devco.viajes.dominio.entidades.Viaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="viaje")
public class ViajeController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Viaje> crearViaje(@RequestBody Viaje viaje){

        return new ResponseEntity<Viaje>(viaje, null , HttpStatus.OK);
    }



}