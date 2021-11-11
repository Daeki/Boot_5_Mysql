package com.iu.b5.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		//정적자원 요청 URL은 Security 거치지 않고 통과
		web.ignoring()
					.antMatchers("/css/**")
					.antMatchers("/js/**")
					.antMatchers("/images/**")
					.antMatchers("/vendor/**")
					.antMatchers("/favicon*/**")
					.antMatchers("/resources/**")
					.antMatchers("/front/**")
					;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
								.antMatchers("/").permitAll()
								.antMatchers("/notice/selectList", "/notice/selectOne").permitAll()
								.antMatchers("/notice/**").hasRole("ADMIN")
								//.antMatchers("/notice/insert", "/notice/update", "/notice/delete").hasRole("ADMIN")
								//ROLE_ 를 제외한 나머지 roleName
								//.antMatchers("/member/memberLogin").permitAll()
								.anyRequest().authenticated()
								//위의 antMathchers외에 그외 나머지는 인증(로그인)이 되어야 가능
								.and()
			//Security에서는 기본 로그인 폼을 제공
			//개발자가 만든 로그인 폼으로 사용
			.formLogin()
						.loginPage("/member/memberLogin")
						.permitAll()
						
								;
		
	}

}
