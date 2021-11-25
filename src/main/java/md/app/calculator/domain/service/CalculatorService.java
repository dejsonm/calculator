package md.app.calculator.domain.service;

import md.app.calculator.remote.dto.OperationDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
private String result = "test";

    public String calculate(OperationDTO operationDTO){



        return result;
    }



}
