package my.hehe.web.weChat.controller;

import my.hehe.web.weChat.entity.encrypt.AesException;
import my.hehe.web.weChat.entity.encrypt.WXBizMsgCrypt;
import my.hehe.web.weChat.entity.msg.request.MsgBody;
import my.hehe.web.weChat.services.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeChatController {
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private WXBizMsgCrypt wxBizMsgCrypt;

    @RequestMapping(path = "/wx", method = RequestMethod.GET)
    public String checkSignature(@RequestParam String signature,
                                 @RequestParam String timestamp, @RequestParam String nonce,
                                 @RequestParam String echostr) throws AesException {
        return wxBizMsgCrypt.verifyUrl2(signature, timestamp, nonce, echostr);
    }

    @RequestMapping(path = "/wx", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    // headers = "content-type=application/xml"
    public Object getMessage(
            @RequestBody(required = false) final MsgBody message) {
        Object object = "";
        try {
            object = weChatService.receive(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (object != null) ? object : "success";//
    }
}
