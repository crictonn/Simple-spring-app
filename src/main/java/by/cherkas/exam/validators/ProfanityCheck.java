package by.cherkas.exam.validators;

import by.cherkas.exam.configuration.Config;
import by.cherkas.exam.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;


@Service
public class ProfanityCheck {
    private static RestTemplate restTemplate = new RestTemplate();
    private static final String url = "https://api.api-ninjas.com/v1/profanityfilter";

    public ProfanityCheck(RestTemplate restTemplate) {
        ProfanityCheck.restTemplate = restTemplate;
    }

    public static boolean checkProfanity(Product product){
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("text", product.toString())
                .build().toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/json");
        httpHeaders.set("X-Api-Key", getAPIkey());

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<ProfanityCheckResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, ProfanityCheckResponse.class);
            return response.getBody().isHas_profanity();

        } catch (Exception exception){
            throw new RuntimeException("Profanity API is down");
        }
    }

    public static String getAPIkey(){
        Properties properties = new Properties();
        String apiKey = null;
        try (FileInputStream input = new FileInputStream("src/main/resources/env.properties")) {
            properties.load(input);
            apiKey = properties.getProperty("PROFANITY_API");
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(ProfanityCheck.class);
            logger.error("Unable to retrieve API key");
        }
        return apiKey;
    }
}
