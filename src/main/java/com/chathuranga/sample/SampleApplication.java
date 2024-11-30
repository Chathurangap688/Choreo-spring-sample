package com.chathuranga.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wso2.charon3.core.objects.User;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "*")
    @GetMapping("/hello")
    public Object hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return sayHello(name);
    }
    @Configuration
    public class WebConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods("*");
        }
    }
    @GetMapping
    public Map<String, String> sayHello(String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "text");
        map.put("name", name);
        map.put("aa", getUser());
        return map;
    }
    @Bean
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public String getUser() {

        String url = "https://api.asgardeo.io/t/chathurangap/scim2/Users/899c8ade-25fd-44ab-9f3a-6ac9d2e3df92";
        InvokeApi invokeApi = new InvokeApi();
        Object o = new Object();
        HttpEntity<String> request = new HttpEntity<String>(invokeApi.getHttpHeader());
        o =  restTemplate.exchange(url, HttpMethod.GET, request, Object.class).getBody();
        return o.toString();
    }

}
