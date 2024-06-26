package com.kream.chouxkream.common.filter;

import com.kream.chouxkream.common.util.CachingRequestBodyWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoggerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        String contentType = String.valueOf(request.getContentType());

        log.info("===============> [{}] {} ({})", method, requestUrl, contentType);
        if (contentType.startsWith("application/json")) {
            CachingRequestBodyWrapper wrappedRequest = new CachingRequestBodyWrapper(request);
            log.info("\n####### Request Body #######\n{}\n############################",
                    wrappedRequest.getRequestBody());
            filterChain.doFilter(wrappedRequest, response);
        } else {
            filterChain.doFilter(request, response);
        }

        contentType = response.getContentType();
        log.info("<=============== [{}] {} ({})", method, requestUrl, contentType);
    }

}
