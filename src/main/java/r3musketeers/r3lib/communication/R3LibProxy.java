package r3musketeers.r3lib.communication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class R3LibProxy {

    private final ConsensusProxy delivery;

    public R3LibProxy(int paxosClientId) throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("config.properties");
        Properties props = new Properties();
        props.load(fis);
        String protocol = props.getProperty("agreement.protocol");
        this.delivery = ProxyFactory.createProxy(protocol, paxosClientId);
    }

}