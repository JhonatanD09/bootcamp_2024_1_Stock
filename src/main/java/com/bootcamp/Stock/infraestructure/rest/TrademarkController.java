package com.bootcamp.Stock.infraestructure.rest;

import com.bootcamp.Stock.application.dto.category.CategoryRequest;
import com.bootcamp.Stock.application.dto.category.CategoryResponse;
import com.bootcamp.Stock.application.dto.trademark.TrademarkRequest;
import com.bootcamp.Stock.application.dto.trademark.TrademarkResponse;
import com.bootcamp.Stock.application.handler.trademark.IHandlerTrademark;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trademark")
@RequiredArgsConstructor
public class TrademarkController {

    private final IHandlerTrademark iHandlerTrademark;

    @Operation(summary = "Add a new trademark")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content),
            @ApiResponse(responseCode = "404", description = "Description not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data", content = @Content)
    })
    @PostMapping("/")

    public ResponseEntity<Void> saveTrademark(@RequestBody TrademarkRequest request) {
        iHandlerTrademark.createTrademark(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public  ResponseEntity<Page<TrademarkResponse>> getAllCategories(@RequestParam(name = "order", defaultValue = "asc") String order, Pageable pageable){
        return new ResponseEntity<>(iHandlerTrademark.getAllTrademarks(order,pageable),HttpStatus.OK);
    }
}
