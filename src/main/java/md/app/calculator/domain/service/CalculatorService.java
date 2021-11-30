package md.app.calculator.domain.service;

import md.app.calculator.remote.dto.OperationDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    String result = "";

    public String calculate(OperationDTO operationDTO) {

        try {
            result = String.valueOf(calculateTree(operationDTO));
        } catch (CalculateTreeException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return "wartość value gdy type jest val nie jest liczbą";
        }
        if (result.equals("Infinity") || result.equals("-Infinity")) {
            return "W obliczeniach występuje dzielenie przez 0";
        }
        return result;


    }

    private Double calculateTree(OperationDTO operationDTO) throws ArithmeticException, CalculateTreeException, NumberFormatException {

        if (operationDTO == null) {
            throw new CalculateTreeException("Nie poprawne dane wejściowe, sprawdź dane");
        }

        if (operationDTO.getType() == null) {
            throw new CalculateTreeException("Pusta wartość w type");
        }


        switch (operationDTO.getType()) {
            case "val":
                if (operationDTO.getValue() == null) {
                    throw new CalculateTreeException("Pusta wartosć liczby gdy type jest wartości val");
                }
                return Double.parseDouble(operationDTO.getValue().replace(",", "."));
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
            default:
                throw new CalculateTreeException("Nie poprawna type, musi być o wartości: val,+,-,*,/,^,bas");
        }

    }

}
