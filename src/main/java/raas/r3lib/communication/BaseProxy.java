package raas.r3lib.communication;

public abstract class BaseProxy {

    private final int paxosClientId;

    public BaseProxy(int id) {
        this.paxosClientId = id;
    }

    public abstract Response send(String namespace, Command cmd);
    
}
