package ru.orlov.test_rest_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.orlov.test_rest_service.model.Response;

@Service
public class ForwardInf implements ServiceForward {


    @Override
    public Response send(Response response) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/feedback";
        restTemplate.postForLocation(url,response);
        return response;
    }
}
