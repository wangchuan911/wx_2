package my.hehe.web.weChat.services;

import my.hehe.web.weChat.entity.Token;
import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.encrypt.AesException;
import my.hehe.web.weChat.entity.encrypt.SHA1;
import my.hehe.web.weChat.entity.encrypt.WXBizMsgCrypt;
import my.hehe.web.weChat.entity.msg.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("weChatService")
@Profile("wechat")
public class WeChatService {

    @Autowired
    WXBizMsgCrypt wXBizMsgCrypt;



    public MsgBody receive(my.hehe.web.weChat.entity.msg.request.MsgBody message) {
        MsgBody msgBody=null;
        try {
            String type=message.getMsgType();
            switch (type){
                case MsgType.MSG_TYPE_TEXT:
                    msgBody= this.textProcess((my.hehe.web.weChat.entity.msg.request.TextMsg) message);
                    break;
                case MsgType.MSG_TYPE_IMAGE:
                    msgBody= this.imageProcess((my.hehe.web.weChat.entity.msg.request.ImageMsg) message);
                    break;
                case MsgType.MSG_TYPE_VIDEO:
                    msgBody= this.videoProcess((my.hehe.web.weChat.entity.msg.request.VideoMsg)message);
                    break;
                case MsgType.MSG_TYPE_VOICE:
                    msgBody= this.voiceProcess((my.hehe.web.weChat.entity.msg.request.VoiceMsg)message);
                    break;
                case MsgType.MSG_TYPE_LINK:
                    msgBody= this.linkProcess((my.hehe.web.weChat.entity.msg.request.LinkMsg)message);
                    break;
                case MsgType.MSG_TYPE_LOCATION:
                    msgBody= this.locationProcess(((my.hehe.web.weChat.entity.msg.request.LocationMsg)message));
                    break;
                case MsgType.MSG_TYPE_SHORT_VIDEO:
                    msgBody= this.shortVideoProcess(((my.hehe.web.weChat.entity.msg.request.ShortVideoMsg)message));
                    break;

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return msgBody;
    }

    private MsgBody textProcess(my.hehe.web.weChat.entity.msg.request.TextMsg msg) {
        // TODO Auto-generated method stub
        MsgBody to=null;
        to = new TextMsg(msg);
        ((TextMsg )to).setContent("you say:" + msg.getContent());
        return to;
    }

    private MsgBody imageProcess(my.hehe.web.weChat.entity.msg.request.ImageMsg msg) {
        ImageMsg to = new ImageMsg(msg);
        to.setMediaId(msg.getMediaId());
        return to;
    }

    private MsgBody linkProcess(my.hehe.web.weChat.entity.msg.request.LinkMsg msg) {
        ArticleMsg to=new ArticleMsg(msg);
        to.setArticleInfo(msg.getTitle(), msg.getDescription(), "", msg.getUrl());
        return to;
    }

    private MsgBody locationProcess(my.hehe.web.weChat.entity.msg.request.LocationMsg msg) {
        // TODO Auto-generated method stub
        TextMsg to = new TextMsg(msg);
        to.setContent(msg.getLocation_X()+":"+msg.getLocation_Y());
        return to;
    }

    private MsgBody shortVideoProcess(my.hehe.web.weChat.entity.msg.request.ShortVideoMsg msg) {
        // TODO Auto-generated method stub
        return null;
    }

    private MsgBody videoProcess(my.hehe.web.weChat.entity.msg.request.VideoMsg msg) {
        VideoMsg to = new VideoMsg(msg);
        to.setVideoInfo(msg.getMsgId(), "AA", "SS");
//        System.out.println(to.toString());

        return to;
    }

    private MsgBody voiceProcess(my.hehe.web.weChat.entity.msg.request.VoiceMsg msg) {
        VoiceMsg to = new VoiceMsg(msg);
        to.setMediaId(msg.getMediaId());
        return to;
    }



}

