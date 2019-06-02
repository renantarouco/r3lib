package r3musketeers.r3lib.communication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import lsr.paxos.client.Client;

public class SProxy extends ConsensusProxy {

    private final Client sClient;

    public SProxy(int paxosClientId) throws IOException {
        super(paxosClientId);
        this.sClient = new Client();
        this.sClient.connect();
    }

    @Override
    public Response send(String namespace, Command cmd) {
        Response r = new Response(null, false, "Error");
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeUTF(namespace);
            oos.writeObject(cmd);
            byte[] reply = this.sClient.execute(out.toByteArray());
            ByteArrayInputStream in = new ByteArrayInputStream(reply);
            ObjectInputStream is = new ObjectInputStream(in);
            r = (Response) is.readObject();
        } catch (Exception e) {
            Logger.getLogger(SProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return r;
    }
    
}