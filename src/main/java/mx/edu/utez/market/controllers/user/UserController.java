package mx.edu.utez.market.controllers.user;

import mx.edu.utez.market.controllers.category.dtos.CategoryDto;
import mx.edu.utez.market.controllers.user.dtos.UserDto;
import mx.edu.utez.market.models.category.Category;
import mx.edu.utez.market.models.subcategory.Subcategory;
import mx.edu.utez.market.models.user.User;
import mx.edu.utez.market.models.user.UserRepository;
import mx.edu.utez.market.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-market/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<CustomResponse<List<User>>> getAll(){
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<User>> getOne(Long id){
        return new ResponseEntity<>(this.service.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<CustomResponse<User>> insert(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.service.insert(userDto.castToUser()), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<User>> update(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.service.update(userDto.castToUser()), HttpStatus.CREATED);
    }

    @PatchMapping("/enableordisable")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(@RequestBody UserDto userDto){
        return new ResponseEntity<>(this.service.changeStatus(userDto.castToUser()), HttpStatus.OK);
    }
}
