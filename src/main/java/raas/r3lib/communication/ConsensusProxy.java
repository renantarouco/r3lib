package raas.r3lib.communication;

public abstract class ConsensusProxy {

    private final int paxosClientId;

    public ConsensusProxy(int id) {
        this.paxosClientId = id;
    }

    public abstract Response send(String namespace, Command cmd);
    
}
