package com.chathuranga.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

    @CrossOrigin(origins = "*")
    @GetMapping("/getUser")
    public Object hello(@RequestParam(value = "userId", defaultValue = "") String userId) {
      return getScimUser(userId);
    }
    @Configuration
    public class WebConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods("*");
        }
    }
    @GetMapping
    public Map<String, String> getScimUser(String userId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "text");
        map.put("userId", userId);
        map.put("user", getUser(userId));
        return map;
    }

    @Autowired
    private RestTemplate restTemplate;

    public HttpHeaders getHttpHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer 1764cdc3-28d2-435f-84bc-d032deec245e");
        headers.add("accept", "application/scim+json");
        return headers;
    }

    public String getUser(String userId) {

        String url = "https://api.asgardeo.io/t/chathurangap/scim2/Users/" + userId;
        InvokeApi invokeApi = new InvokeApi();
        Object o = new Object();
        HttpEntity<String> request = new HttpEntity<String>(getHttpHeader());
        o =  restTemplate.exchange(url, HttpMethod.GET, request, Object.class).getBody();
        return o.toString();
    }

}
