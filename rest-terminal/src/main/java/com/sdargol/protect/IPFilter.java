package com.sdargol.protect;

import com.sdargol.protect.IPData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IPFilter extends GenericFilterBean {
    public static final String IP_HEADER = "X-FORWARDED-FOR";
    private final ConcurrentHashMap<String, IPData> ipStrangeStorage;

    @Autowired
    public IPFilter(ConcurrentHashMap<String, IPData> ipStrangeStorage) {
        this.ipStrangeStorage = ipStrangeStorage;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if(ipStrangeStorage.containsKey(getIp(servletRequest))){
            if(ipStrangeStorage.get(getIp(servletRequest)).getIpStatusBlocked()){
                ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        System.out.println("IPFilter run " + getIp(servletRequest));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public static String getIp(ServletRequest servletRequest){
        String ipAddress = ((HttpServletRequest)servletRequest).getHeader(IP_HEADER);
        if(ipAddress == null){
            ipAddress = servletRequest.getRemoteAddr();
        }
        return ipAddress;
    }
}
