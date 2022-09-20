package ru.orlov.test_rest_service.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.orlov.test_rest_service.model.Response;

@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyService{
    @Override
    public Response exececute(Response response) {
        response.setUid("New Uid");
        return response;
    }
}
