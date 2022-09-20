package ru.orlov.test_rest_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.orlov.test_rest_service.model.Response;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyService{

    @Override
    public Response exececute(Response response) {
        response.setErrorMessage("Все плохо");
        return response;
    }
}
