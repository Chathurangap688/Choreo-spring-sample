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

    @Autowired
    private RestTemplate restTemplate;

    public HttpHeaders getHttpHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJ4NXQiOiJJV19MWld0SVpWSnRZdU5MQ0FZZjkzUW9fQnMiLCJraWQiOiJZVGt3TmpZNE1URXdZalZrT0RoaE1UQm1OREl6TVdaak5EUTFZV0V4TVRZeVlqUTFOamcxWlRZek5EQXlaakpqT0RrNU16aGtNamd3T0RnMlkyTmhOd19SUzI1NiIsInR5cCI6ImF0K2p3dCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJZRVJfTW93NnFUZnR3V2pTTnZSYU80QUpyaXdhIiwiYXV0IjoiQVBQTElDQVRJT04iLCJpc3MiOiJodHRwczpcL1wvYXBpLmFzZ2FyZGVvLmlvXC90XC9jaGF0aHVyYW5nYXBcL29hdXRoMlwvdG9rZW4iLCJjbGllbnRfaWQiOiJZRVJfTW93NnFUZnR3V2pTTnZSYU80QUpyaXdhIiwiYXVkIjoiWUVSX01vdzZxVGZ0d1dqU052UmFPNEFKcml3YSIsIm5iZiI6MTczMjk5MjYzMywiYXpwIjoiWUVSX01vdzZxVGZ0d1dqU052UmFPNEFKcml3YSIsIm9yZ19pZCI6ImU5ZTA2ZTRhLWQ4NjQtNGFhOS1hNDA0LWFmY2FkM2YyY2IzNCIsInNjb3BlIjoiaW50ZXJuYWxfdXNlcl9tZ3RfY3JlYXRlIGludGVybmFsX3VzZXJfbWd0X2RlbGV0ZSBpbnRlcm5hbF91c2VyX21ndF9saXN0IGludGVybmFsX3VzZXJfbWd0X3VwZGF0ZSBpbnRlcm5hbF91c2VyX21ndF92aWV3IiwiZXhwIjoxNzMyOTk2MjMzLCJvcmdfbmFtZSI6ImNoYXRodXJhbmdhcCIsImlhdCI6MTczMjk5MjYzMywianRpIjoiMTg2ZDcxZTktODY4Yi00NGUzLTkzN2EtNWM3ZTFkZDFiMzU5In0.Yo3DZVDa4YKWmHPPiivSp9bAcX3XWl2qewq5vZGLfPD3KGevnX41ykl71hRHx_hWILHwNxg_FmheCIySqhkAUU4WOA150wKByDC3SCaLx5XhANbDQjTDz5gAXYV2FLaiqwbLqY7yjJySVxVXN7BUzQa59MaM4biorRptoghYADZNr8F1r8GsOde4qLuXlVzLbo6dGA4_oumkNqIXAUXs5J89t_T5r-k02iSjhbzvJSUYR-wxoQVknfClzX9o9hKCO65ZQ7SSXgqSk5ZEnktgycum6sNd0XSsrnwA5iP9285CdPJQnXMsITL4bHsojfFnDUV7NHt-x8Odpp8iyUi1TA");
        headers.add("accept", "application/scim+json");
        return headers;
    }

    public String getUser() {

        String url = "https://api.asgardeo.io/t/chathurangap/scim2/Users/899c8ade-25fd-44ab-9f3a-6ac9d2e3df92";
        InvokeApi invokeApi = new InvokeApi();
        Object o = new Object();
        HttpEntity<String> request = new HttpEntity<String>(getHttpHeader());
        o =  restTemplate.exchange(url, HttpMethod.GET, request, Object.class).getBody();
        return o.toString();
    }

}
