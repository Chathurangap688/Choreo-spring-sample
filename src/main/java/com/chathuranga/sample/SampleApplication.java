package com.chathuranga.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        map.put("aa", "bb");
        return map;
    }

}
