package md.app.calculator.remote.dto;

public class OperationDTO {
    private String type;
    private String value;
    private OperationDTO left;
    private OperationDTO right;

    OperationDTO(String type,String value){
        this.type= type;
        this.value = value;
        left = null;
        right = null;
    }
}
