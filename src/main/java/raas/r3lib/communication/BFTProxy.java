package raas.r3lib.communication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import bftsmart.tom.ServiceProxy;

public class BFTProxy extends ConsensusProxy {

    private final ServiceProxy keyvalueProxy;

    public BFTProxy(int paxosClientId) throws IOException, InterruptedException {
        super(paxosClientId);
        this.keyvalueProxy = new ServiceProxy(paxosClientId);
    }

    @Override
    public Response send(String namespace, Command cmd) {
        Response r = new Response(null, false, "Error");
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeUTF(namespace);
            oos.writeObject(cmd);
            byte[] reply = keyvalueProxy.invokeOrdered(out.toByteArray());
            ByteArrayInputStream in = new ByteArrayInputStream(reply);
            ObjectInput is = new ObjectInputStream(in);
            r = (Response) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(BFTProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return r;
    }

}