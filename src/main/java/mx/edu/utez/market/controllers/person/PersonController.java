package mx.edu.utez.market.controllers.person;

import mx.edu.utez.market.controllers.person.dtos.PersonDto;
import mx.edu.utez.market.models.person.Person;
import mx.edu.utez.market.models.utils.CustomResponse;
import mx.edu.utez.market.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-market/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Person>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Person>> insert(@Valid @RequestBody PersonDto personDto){
        return new ResponseEntity<>(this.service.insert(personDto.getPerson()), HttpStatus.CREATED);
    }
}
