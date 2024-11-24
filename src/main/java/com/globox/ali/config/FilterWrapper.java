package com.globox.ali.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Getter
@Component
public class FilterWrapper implements Filter {
    private Long counter = 0L;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();
        List<String> allowedPaths = List.of("/best-movies-of-the-year", "/titles-of-casts", "/alive-director-writer", "/input-to-tables");
        if (!path.startsWith("/http-handler") && allowedPaths.stream().anyMatch(path::startsWith)) {
            counter++;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
