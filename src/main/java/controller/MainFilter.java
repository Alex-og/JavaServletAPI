package controller;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

/**
 * @author Oleksandr Haleta
 * 2021
 */
@WebFilter("/filter")
public class MainFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(MainFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String address = servletRequest.getServerName();
        String dateTime = LocalDate.now().toString();
        log.info("Date: {}", dateTime);
        log.info("Server: {}", address);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
