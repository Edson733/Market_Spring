package mx.edu.utez.market.controllers.category;

import mx.edu.utez.market.controllers.category.dtos.CategoryDto;
import mx.edu.utez.market.models.category.Category;
import mx.edu.utez.market.models.category.CategoryRepository;
import mx.edu.utez.market.services.category.CategoryService;
import mx.edu.utez.market.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-market/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Category>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Category>> insert(@Valid @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.service.insert(categoryDto.castToCategory()), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Category>> update(@Valid @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.service.update(categoryDto.castToCategory()), HttpStatus.CREATED);
    }

    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.service.changeStatus(categoryDto.castToCategory()), HttpStatus.OK);
    }
}
