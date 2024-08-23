package com.bootcamp.Stock.infraestructure.rest;

import com.bootcamp.Stock.application.dto.CategoryRequest;
import com.bootcamp.Stock.application.dto.CategoryResponse;
import com.bootcamp.Stock.application.handler.IHandlerCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final IHandlerCategory iHandlerCategory;

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content),
            @ApiResponse(responseCode = "410", description = "Description not found", content = @Content),
            @ApiResponse(responseCode = "411", description = "Invalid data", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveCategory(@RequestBody CategoryRequest categoryRequest) {
        iHandlerCategory.saveCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public  ResponseEntity<Page<CategoryResponse>> getAllCategories(@RequestParam(name = "order", defaultValue = "asc") String order, Pageable pageable){
        return new ResponseEntity<>(iHandlerCategory.getAllCategories(order,pageable),HttpStatus.OK);
    }


}
