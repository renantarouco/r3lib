package raas.r3lib.communication;

import java.io.Serializable;

public class Response implements Serializable {

    public Object returnObject;
    public boolean success;
    public String errorMessage;

    public Response(Object returnObject, boolean success, String errorMessage) {
        this.returnObject = returnObject;
        this.success = success;
        this.errorMessage = errorMessage;
    }
    
}
