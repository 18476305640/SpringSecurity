package com.itheima.geteway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {
    // no need
//    //以怎样的方式存储Token
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();//内存
//    }

    //jwt
    private String SIGNING_KEY = "zjazn";
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); //对称秘钥,资源服务器使用该秘钥来验证
        return converter;
    }

}
