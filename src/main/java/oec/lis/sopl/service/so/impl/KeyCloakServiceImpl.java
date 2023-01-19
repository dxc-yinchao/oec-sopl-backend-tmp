package oec.lis.sopl.service.so.impl;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import oec.lis.sopl.common.model.MasterCodeTableRequestBean;
import oec.lis.sopl.common.model.MasterCodeTableResponseBean;
import oec.lis.sopl.common.model.RestListResponse;
import oec.lis.sopl.common.model.RestRequest;
import oec.lis.sopl.model.domain.UserInfo;
import oec.lis.sopl.service.so.KeyCloakServie;

@Service
public class KeyCloakServiceImpl implements KeyCloakServie {

	@Value("http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/userinfo")
    private String keycloakUserInfoURL;
	
	@Value("http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/token")
    private String keycloakTokenURL;
	
	@Value("${keycloak.resource}")
    private String keycloakResource;

	@Override
	public UserInfo getUserInfo(String token) {
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "bearer " + token);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.postForObject(keycloakUserInfoURL, request, UserInfo.class);

	}

	@Override
	public UserInfo getUserInfo(String username, String password) {
		String token = getUserToken(username, password);
		return getUserInfo(token);
	}

	@Override
	public String getUserToken(String username, String password) {
		RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id",keycloakResource);
        map.add("username",username);
        map.add("password",password);
        map.add("grant_type","password");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, null);
        
        Map<String,String> resultMap = restTemplate.postForObject(keycloakTokenURL, request, Map.class);

        return resultMap.get("access_token");
	}


   
}
