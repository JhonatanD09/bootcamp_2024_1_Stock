package com.bootcamp.Stock.infraestructure.rest;

import com.bootcamp.Stock.application.dto.article.ArticleRequest;
import com.bootcamp.Stock.application.dto.category.CategoryRequest;
import com.bootcamp.Stock.application.handler.article.IArticleHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final IArticleHandler iArticleHandler;

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Article created", content = @Content),
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveCategory(@RequestBody ArticleRequest articleRequest) {
        iArticleHandler.addArticle(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
