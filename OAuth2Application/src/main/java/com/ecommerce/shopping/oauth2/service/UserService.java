package com.ecommerce.shopping.oauth2.service;

import java.util.Map;

import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.oauth2.dao.UserRepository;
import com.ecommerce.shopping.oauth2.model.User;

@Service
public class UserService extends OidcUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        Map attributes = oidcUser.getAttributes();
        User userInfo = new User();
        userInfo.setEmail((String) attributes.get("email"));
        userInfo.setId((String) attributes.get("sub"));
        userInfo.setImageUrl((String) attributes.get("picture"));
        userInfo.setName((String) attributes.get("name"));
        updateUser(userInfo);
        return oidcUser;
    }

    private void updateUser(User userInfo) {
        User user = userRepository.findByEmail(userInfo.getEmail());
        if(user == null) {
            user = new User();
        }
        user.setEmail(userInfo.getEmail());
        user.setImageUrl(userInfo.getImageUrl());
        user.setName(userInfo.getName());
       
		userRepository.save(user);
    }
}
