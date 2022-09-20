package ru.orlov.test_rest_service.service;

import ru.orlov.test_rest_service.model.Response;

public interface ServiceForward {
    Response send(Response response);
}
