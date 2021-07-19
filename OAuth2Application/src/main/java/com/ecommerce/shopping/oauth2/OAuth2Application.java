package com.ecommerce.shopping.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class OAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}
}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler("/");
//		// @formatter:off
//		http
//        .authorizeRequests(a -> a
//            .antMatchers("/**", "/error", "/webjars/**").permitAll().anyRequest().authenticated())
//        .exceptionHandling(e -> e
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//            )
//        .csrf(c -> c
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//			)
//			.logout(l -> l
//				.logoutSuccessUrl("/").permitAll()
//			)
//            .oauth2Login(o -> o
//    				.failureHandler((request, response, exception) -> {
//    					request.getSession().setAttribute("error.message", exception.getMessage());
//    					handler.onAuthenticationFailure(request, response, exception);
//    				}).userInfoEndpoint(userInfoEndpoint ->
//                    userInfoEndpoint
//                    .oidcUserService(this.oidcUserService())
//)
//    			).oauth2Login();
//
//
//		
//		// @formatter:on
//	}
//	
//	@Bean
//	public AuthorizationRequestRepository customAuthorizationRequestRepository() {
//		return new HttpSessionOAuth2AuthorizationRequestRepository();
//	}
//	
//	public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
//		final OidcUserService delegate = new OidcUserService();
//		return (userRequest) -> {
//            // Delegate to the default implementation for loading a user
//            OidcUser oidcUser = delegate.loadUser(userRequest);
//
//            OAuth2AccessToken accessToken = userRequest.getAccessToken();
//            Set mappedAuthorities = new HashSet<>();
//
//            // TODO
//            // 1) Fetch the authority information from the protected resource using accessToken
//            // 2) Map the authority information to one or more GrantedAuthority's and add it to mappedAuthorities
//
//            // 3) Create a copy of oidcUser but use the mappedAuthorities instead
//            oidcUser = new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
//
//            return oidcUser;
//        };
//	}
//}

/*
*/