package com.tsm.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component //adding due to autowired usage in this class
public class AuthTokenFilter extends OncePerRequestFilter {

    private GrantedAuthoritiesMapper authoritiesMapper = new SimpleAuthorityMapper();
    @Autowired
    TokenUtil tokenUtil;
    @Value("${service.token.key}")
    String serviceTokenKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /*String authorizationHeader = request.getHeader( "Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwt = authorizationHeader.substring(7);
            if (StringUtils.hasText(jwt) && this.tokenUtil.validateToken(jwt)
                    && StringUtils.hasText(this.tokenUtil.getTokenKeyForThisService())
                    && serviceTokenKey.equals(this.tokenUtil.getTokenKeyForThisService())) { //allow only token having access to this service
                    //db / api call can be made to validate the user access
                    //cache or cookie can also be used to avoid calling db/api for every request
                String username = this.tokenUtil.getUsernameFromJWT(jwt);
                String roles = this.tokenUtil.getRolesFromJWT(jwt);
                List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList();
                Arrays.stream(roles.split(",")).forEach(role -> simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role)));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, (Object) null, this.authoritiesMapper.mapAuthorities(simpleGrantedAuthorityList));
                usernamePasswordAuthenticationToken.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }*/

        String username= "trishank";
        String roles= "Manager,Admin";

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        Arrays.stream(roles.split(",")).forEach(role -> simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(role)));
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, (Object) null, this.authoritiesMapper.mapAuthorities(simpleGrantedAuthorityList));
        usernamePasswordAuthenticationToken.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);

    }
}