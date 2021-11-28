package md.app.calculator.domain.service;

import md.app.calculator.remote.dto.OperationDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    String result = "";
    public String calculate(OperationDTO operationDTO) {

try {
    result = String.valueOf(calculateTree(operationDTO));
} catch (ArithmeticException e){
    return "Dzielenie przez 0";
}
return result;


    }

    private Double calculateTree(OperationDTO operationDTO) throws ArithmeticException {

        if(operationDTO == null){
            return null;
        }

        switch (operationDTO.getType()) {
            case "val":
                return Double.parseDouble(operationDTO.getValue());
            case "+":
                return calculateTree(operationDTO.getLeft()) + calculateTree(operationDTO.getRight());
            case "-":
                return calculateTree(operationDTO.getLeft()) - calculateTree(operationDTO.getRight());
            case "*":
                return calculateTree(operationDTO.getLeft()) * calculateTree(operationDTO.getRight());
            case "/":
                return calculateTree(operationDTO.getLeft()) / calculateTree(operationDTO.getRight());
            case "^":
                return Math.pow(calculateTree(operationDTO.getLeft()), calculateTree(operationDTO.getRight()));
            case "abs":
                return Math.abs(calculateTree(operationDTO.getLeft()));
        }

        return null;

    }

}
