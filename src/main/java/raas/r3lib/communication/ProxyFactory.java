package raas.r3lib.communication;

import java.io.IOException;

public final class ProxyFactory {

    public static ConsensusProxy createProxy(String protocol, int clientId)
        throws IOException, InterruptedException {
            switch (protocol) {
                case "bftsmart":
                    return new BFTProxy(clientId);
                case "spaxos":
                    return new SProxy(clientId);
            }
            return null;
    }
    
}
