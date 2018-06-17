package my.hehe.web.weChat.entity.define;

public class MsgType {
    static final public String MSG_TYPE_TEXT = "text";
    static final public String MSG_TYPE_IMAGE = "image";
    static final public String MSG_TYPE_VOICE = "voice";
    static final public String MSG_TYPE_VIDEO = "video";
    static final public String MSG_TYPE_SHORT_VIDEO = "shortvideo";
    static final public String MSG_TYPE_LOCATION = "location";
    static final public String MSG_TYPE_LINK = "link";
    static final public String MSG_TYPE_MUSIC = "music";
    static final public String MSG_TYPE_ARTICLE = "news";
    static final public String MSG_REPLY="success";
    static final public String MSG_PARM_TIMESTAMP="timestamp";
    static final public String MSG_PARM_MSG_SIGNATURE="msg_signature";
    static final public String MSG_PARM_NONCE ="nonce";
    static final public String MSG_PARM_SIGNATURE="signature";
}
enum MsgTypeEnum{
    MSG_TYPE_TEXT ( "text"),
    MSG_TYPE_IMAGE ( "image"),
    MSG_TYPE_VOICE ( "voice"),
    MSG_TYPE_VIDEO ( "video"),
    MSG_TYPE_SHORT_VIDEO ( "shortvideo"),
    MSG_TYPE_LOCATION ( "location"),
    MSG_TYPE_LINK ( "link"),
    MSG_TYPE_MUSIC ( "music"),
    MSG_TYPE_ARTICLE ( "news"),
    MSG_REPLY("success"),
    MSG_PARM_TIMESTAMP("timestamp"),
    MSG_PARM_MSG_SIGNATURE("msg_signature"),
    MSG_PARM_NONCE ("nonce"),
    MSG_PARM_SIGNATURE("signature");
    String value;
    MsgTypeEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}