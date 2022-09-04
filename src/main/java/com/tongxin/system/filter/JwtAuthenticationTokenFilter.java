package com.tongxin.system.filter;

import com.tongxin.common.enums.BusinessExceptionEnum;
import com.tongxin.common.utils.JwtUtil;
import com.tongxin.system.entity.dto.LoginUser;
import com.tongxin.system.exception.ServiceException;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Description: 配合springSecurity的拦截器
 * @Title: JwtAuthenticationTokenFilter
 * @ProjectName: demo1
 * @date: 2022/4/17 17:09
 * @author: Luo
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

//    @Resource
//    private RedisCache redisCache;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //拿到token
        String token = request.getHeader("token");
        //没有token，可能是进行登录注册操作
        //对token进行非空判断，如果没用token，直接放行，因为这块是对token进行解析，拿到user对象
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
        }
        //解析token
        Claims claims;
        String userId;
        try {
            claims = (Claims) JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new ServiceException(BusinessExceptionEnum.AUTH_EXCEPTION);
        }

        //从redis中获取用户信息
        String redisKey = "login" + userId;
        //temp
        LoginUser loginUser = new LoginUser();
//        LoginUser loginUser = (LoginUser) redisCache.getCacheObject(redisKey);

        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
//        将用户信息存入SecurityContextHolder中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        //每一次新的请求都会创建一个新的SercurityContextHolder对象，如果redis中没有查出来id对应的loginUser对象，此时SercurityContextHolder中为空的
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //全部处理完成之后，放行
        filterChain.doFilter(request, response);
    }
}
