import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.OnMessage;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/projectrwa/user/webSocket")
public class WebSocket {
    static int i = 0;

    @OnOpen
    public void onOpen(Session session){
        i++;
        try {
            session.getBasicRemote().sendText(Integer.toString(i));
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        msgAll(session);
    }

    @OnClose
    public void onClose(Session session){
        i--;
        msgAll(session);
    }

    private void msgAll(Session session){
        for(Session sess : session.getOpenSessions()){
            try {
                sess.getBasicRemote().sendText(Integer.toString(i));
            } 
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

