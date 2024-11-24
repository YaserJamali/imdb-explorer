package com.globox.ali.controller;


import com.globox.ali.config.FilterWrapper;
import com.globox.ali.dto.ErrorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/http-handler")
@Tag(name = "HttpRequestHandlerController",
        description = "APIs related to HTTP request handling and counting")
@RequiredArgsConstructor
public class HttpRequestHandlerController {

    private final FilterWrapper filter;

    @Operation(summary = "Get request count", description = "This API returns the count of HTTP requests handled by the application.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "404", description = "HTTP Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/request-count")
    public long getRequestCount() {
        return filter.getCounter();
    }
}
