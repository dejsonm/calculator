package md.app.calculator.remote.api;

import md.app.calculator.domain.service.CalculatorService;
import md.app.calculator.remote.dto.OperationDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class CalculateController {

    private CalculatorService calculatorService;

public CalculateController(CalculatorService calculatorService){
    this.calculatorService = calculatorService;
}

    @PostMapping("/api/calculate")
    public String calculate(@RequestBody OperationDTO operationDTO){

        return calculatorService.calculate(operationDTO);
    }
}
