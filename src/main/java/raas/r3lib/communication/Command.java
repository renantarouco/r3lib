package raas.r3lib.communication;

import java.io.Serializable;

public class Command implements Serializable {

    public String smrCmd;
    public String str0;
    public String str1;
    public byte[] libSource;
    public Object[] params;

    public Command(String smrCmd, String str0, String str1, byte[] libSource, Object[] params) {
        this.smrCmd = smrCmd;
        this.str0 = str0;
        this.str1 = str1;
        this.libSource = libSource;
        this.params = params;
    }

    public Command(String url, Object[] params) {
        this.smrCmd = "invoke_method";
        this.str0 = url;
        this.params = params;
    }

    public Command(String str0, byte[] libSource) {
        this.smrCmd = "register_type";
        this.str0 = str0;
        this.libSource = libSource;
    }

    public Command(String str0, String str1) {
        this.smrCmd = "new_app_instance";
        this.str0 = str0;
        this.str1 = str1;
    }
    
}
