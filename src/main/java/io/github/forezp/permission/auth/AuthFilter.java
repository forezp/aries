package io.github.forezp.permission.auth;


import io.github.forezp.common.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by forezp on 2018/8/6.
 */

@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter")
public class AuthFilter implements Filter {

    private static final String AUTH = "auth";
    private static final String ERROR_MSG="{\"code\":\"1\",\"msg\":\"you have no permission\"}";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println(httpServletRequest.getRequestURI());
        String token = HttpUtils.getHeaders(httpServletRequest).get(AUTH);
        token="forezp";
        if(!StringUtils.isEmpty(token)){
            AuthHolder.setCurrentUser(token);
            try {
                System.out.println(AuthHolder.getCurrentUser());
                filterChain.doFilter(servletRequest, servletResponse);
            }finally {
                AuthHolder.removeCurrentUser();
                System.out.println(AuthHolder.getCurrentUser());
            }
        }else {
            servletResponse.getWriter().write(ERROR_MSG);

        }
    }

    @Override
    public void destroy() {

    }
}
