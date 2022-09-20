package ru.orlov.test_rest_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.orlov.test_rest_service.model.Request;
import ru.orlov.test_rest_service.model.Response;
import ru.orlov.test_rest_service.service.MyService;
import ru.orlov.test_rest_service.service.ServiceForward;

@RestController
public class MyController {


    private final MyService myService;

    private final ServiceForward serviceForward;

    @Autowired
    public MyController(@Qualifier("ModifyErrorMessage") MyService myService, ServiceForward serviceForward) {
        this.myService = myService;

        this.serviceForward = serviceForward;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        Response forward = serviceForward.send(response);


        return new ResponseEntity<>(forward, HttpStatus.OK);

    }
}
