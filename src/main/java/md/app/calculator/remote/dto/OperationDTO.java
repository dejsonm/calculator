package md.app.calculator.remote.dto;

public class OperationDTO {
    private String type;
    private String value;
    private OperationDTO left;
    private OperationDTO right;

    OperationDTO(String type,String value,OperationDTO left,OperationDTO right){
        this.type= type;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
