package my.hehe.web.weChat.entity.msg.request;

public interface Msg {
    public String getToUserName();

    public String getFromUserName();

    public Long getCreateTime();

    public String getMsgType();

    public String getMsgId();

    public void setToUserName(String toUserName);

    public void setFromUserName(String fromUserName);

    public void setCreateTime(Long createTime);

    public void setMsgType(String msgType);

    public void setMsgId(String msgId);
}
