package my.hehe.web.weChat.entity.msg.response;


import my.hehe.web.weChat.entity.msg.request.Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class MsgBody {//http://blog.csdn.net/howingtian/article/details/49026907
	@XmlElement(name = "ToUserName")
	protected String toUserName;
	@XmlElement(name = "FromUserName")
	protected String fromUserName;
	@XmlElement(name = "CreateTime")
	protected Long createTime;
	@XmlElement(name = "MsgType")
	protected String msgType;

	
	public String getToUserName() {
		return toUserName;
	}

	
	public String getFromUserName() {
		return fromUserName;
	}

	
	public Long getCreateTime() {
		return createTime;
	}

	
	public String getMsgType() {
		return msgType;
	}

	public void setToUserName(String toUserName) {
		toUserName = toUserName;
	}

	public void setFromUserName(String fromUserName) {
		fromUserName = fromUserName;
	}

	public void setCreateTime(Long createTime) {
		createTime = createTime;
	}

	public void setMsgType(String msgType) {
		msgType = msgType;
	}

	public MsgBody() {
	}

	public MsgBody(String toUserName, String fromUserName, Long createTime,
				   String msgType) {
		toUserName = toUserName;
		fromUserName = fromUserName;
		createTime = createTime;
		msgType = msgType;
	}

	public MsgBody(String toUserName, String fromUserName, String msgType) {
		this(toUserName, fromUserName, new Date().getTime(), msgType);
	}

	public MsgBody(Msg msg, Long createTime, String msgType) {
		getMessageBaseInfo(msg);
		this.createTime = createTime;
		this.msgType = msgType;
	}

	public MsgBody(Msg msg, String msgType) {
		this(msg, new Date().getTime(), msgType);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fromUserName + "," + toUserName + "," + msgType + ","
				+ createTime;
	}

	public void getMessageBaseInfo(Msg msg) {
		this.fromUserName = msg.getToUserName();
		this.toUserName = msg.getFromUserName();
	}

}
