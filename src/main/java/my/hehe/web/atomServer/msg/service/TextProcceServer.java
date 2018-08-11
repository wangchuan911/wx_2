package my.hehe.web.atomServer.msg.service;

import org.json.JSONObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Profile("atomSrv")
public class TextProcceServer {
    public JSONObject excute(JSONObject data){
        return  null;
    }
}
