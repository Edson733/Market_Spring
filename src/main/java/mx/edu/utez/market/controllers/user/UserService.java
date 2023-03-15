package mx.edu.utez.market.controllers.user;

import mx.edu.utez.market.models.category.Category;
import mx.edu.utez.market.models.person.PersonRepository;
import mx.edu.utez.market.models.user.User;
import mx.edu.utez.market.models.user.UserRepository;
import mx.edu.utez.market.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public CustomResponse<List<User>> findAll(){
        return new CustomResponse<>(this.userRepository.findAll(), false, 200, "Ok");
    }

    @Transactional(readOnly = true)
    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public CustomResponse<User> findOne(Long id){
        return new CustomResponse<>(this.userRepository.findById(id).get(), false, 200, "Ok");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User> insert(User user){
        if (this.userRepository.existsByUsername(user.getUsername())) {
            return new CustomResponse<>(null, true, 400, "El usuario ya existe");
        }else{
            return new CustomResponse<>(this.userRepository.saveAndFlush(user), false, 200, "Usuario Registrado Correctamente");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User> update(User user){
        if (!this.userRepository.existsById(user.getId())) {
            return new CustomResponse<>(null, true, 400, "El usuario No Existe");
        }else{
            return new CustomResponse<>(this.userRepository.saveAndFlush(user), false, 200, "Usuario Actualizado Correctamente");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Boolean> changeStatus(User user){
        if (!this.userRepository.existsById(user.getId())){
            return new CustomResponse<>(null, true, 400, "El usuario No Existe");
        }else{
            return new CustomResponse<>(this.userRepository.updateStatusById(user.getStatus(), user.getId()), false, 200, "Usuario Actualizado Correctamente");
        }
    }
}
