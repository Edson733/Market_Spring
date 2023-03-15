package mx.edu.utez.market.controllers.subcategory;

import mx.edu.utez.market.controllers.subcategory.dtos.SubcategoryDto;
import mx.edu.utez.market.models.subcategory.Subcategory;
import mx.edu.utez.market.models.subcategory.SubcategoryRepository;
import mx.edu.utez.market.models.utils.CustomResponse;
import mx.edu.utez.market.services.subcategory.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-market/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    private SubcategoryService service;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @GetMapping("/all")
    public ResponseEntity<CustomResponse<List<Subcategory>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<CustomResponse<List<Subcategory>>> getAllByCategory(Long id){
        return new ResponseEntity<>(this.service.getAllByCategoryId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Subcategory>> getById(SubcategoryDto subcategoryDto){
        return new ResponseEntity<>(this.service.getOne(subcategoryDto.getId()), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<CustomResponse<Subcategory>> insert(@Valid @RequestBody SubcategoryDto subcategoryDto){
        return new ResponseEntity<>(this.service.insert(subcategoryDto.castToSubcategory()), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<Subcategory>> update(@Valid @RequestBody SubcategoryDto subcategoryDto){
        return new ResponseEntity<>(this.service.update(subcategoryDto.castToSubcategory()), HttpStatus.CREATED);
    }

    @PatchMapping("/enadis")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(@RequestBody SubcategoryDto subcategoryDto){
        return new ResponseEntity<>(this.service.changeStatus(subcategoryDto.castToSubcategory()), HttpStatus.OK);
    }
}
