package my.hehe.web.weChat.entity.msg.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class MsgBody implements ImageMsg, LinkMsg, LocationMsg,ShortVideoMsg,TextMsg ,VideoMsg,VoiceMsg{

    private String URL;

    private String toUserName;

    private String fromUserName;

    private Long createTime;

    private String msgType;

    private String msgId;

    private String mediaId;

    private String picUrl;

    private String Format;

    private String thumbMediaId;

    private String  location_X;

    private String  location_Y;

    private String  scale;

    private String  label;

    private String  title;

    private String  description;

    private String  url;

    private String content;

    private String  recognition;


    @XmlElement(name = "ToUserName")
    @Override
    public String getToUserName() {
        return toUserName;
    }

    @XmlElement(name = "FromUserName")
    @Override
    public String getFromUserName() {
        return fromUserName;
    }

    @XmlElement(name = "CreateTime")
    @Override
    public Long getCreateTime() {
        return createTime;
    }

    @XmlElement(name = "MsgType")
    @Override
    public String getMsgType() {
        return msgType;
    }

    @XmlElement(name = "MsgId")
    @Override
    public String getMsgId() {
        return msgId;
    }

    @XmlElement(name = "MediaId")
    @Override
    public String getMediaId() {
        return mediaId;
    }

    @XmlElement(name = "PicUrl")
    @Override
    public String getPicUrl() {
        return picUrl;
    }

    @XmlElement(name = "Format")
    @Override
    public String getFormat() {
        return Format;
    }

    @XmlElement(name = "ThumbMediaId")
    @Override
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    @XmlElement(name = "Location_X")
    @Override
    public String getLocation_X() {
        return  location_X;
    }

    @XmlElement(name = "Location_Y")
    @Override
    public String getLocation_Y() {
        return  location_Y;
    }

    @XmlElement(name = "Scale")
    @Override
    public String getScale() {
        return  scale;
    }

    @XmlElement(name = "Label")
    @Override
    public String getLabel() {
        return  label;
    }

    @XmlElement(name = "Title")
    @Override
    public String getTitle() {
        return  title;
    }

    @XmlElement(name = "Description")
    @Override
    public String getDescription() {
        return  description;
    }

    @XmlElement(name = "Url")
    @Override
    public String getUrl() {
        return  url;
    }

    @XmlElement(name = "Content")
    @Override
    public String getContent() {
        return content;
    }

    @XmlElement(name = "Recognition")
    @Override
    public String getRecognition() {
        return  recognition;
    }

    @XmlElement(name = "URL")
    public String getURL() {
        return  URL;
    }


//    @XmlElement(name = "Encrypt")
//    @Override
//    public String getEncrypt() {
//        return Encrypt;
//    }
//
//    @Override
//    public void setEncrypt(String encrypt) {
//        Encrypt = encrypt;
//    }

    @Override
    public void setRecognition(String  recognition) {  this.recognition =  recognition;
    }

    @Override
    public void setToUserName(String toUserName) { this.toUserName = toUserName;
    }

    @Override
    public void setFromUserName(String fromUserName) { this.fromUserName = fromUserName;
    }

    @Override
    public void setCreateTime(Long createTime) { this.createTime = createTime;
    }

    @Override
    public void setMsgType(String msgType) { this.msgType = msgType;
    }

    @Override
    public void setMsgId(String msgId) { this.msgId = msgId;
    }

    @Override
    public void setMediaId(String mediaId) { this.mediaId = mediaId;
    }

    @Override
    public void setPicUrl(String picUrl) { this.picUrl = picUrl;
    }

    @Override
    public void setFormat(String format) {
        Format = format;
    }

    @Override
    public void setThumbMediaId(String thumbMediaId) { this.thumbMediaId = thumbMediaId;
    }

    @Override
    public void setLocation_X(String  location_X) {  this.location_X =  location_X;
    }

    @Override
    public void setLocation_Y(String  location_Y) {  this.location_Y =  location_Y;
    }

    @Override
    public void setScale(String  scale) {  this.scale =  scale;
    }

    @Override
    public void setLabel(String  label) {  this.label =  label;
    }

    @Override
    public void setTitle(String  title) {  this.title =  title;
    }

    @Override
    public void setDescription(String  description) {  this.description =  description;
    }

    @Override
    public void setUrl(String  url) {  this.url =  url;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public void setURL(String  url) {  this.URL =  url;
    }

    @Override
    public String toString() {
        return "MsgBody{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", msgId='" + msgId + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", Format='" + Format + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", location_X='" + location_X + '\'' +
                ", location_Y='" + location_Y + '\'' +
                ", scale='" + scale + '\'' +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", recognition='" + recognition + '\'' +
                '}';
    }
}
