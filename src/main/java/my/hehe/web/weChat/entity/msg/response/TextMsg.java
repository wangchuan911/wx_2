package my.hehe.web.weChat.entity.msg.response;

import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.msg.request.Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextMsg extends MsgBody {
	@XmlElement(name = "Content")
	private String content;

	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TextMsg() {
		this.setMsgType(MsgType.MSG_TYPE_TEXT);
	}

	public TextMsg(String toUserName, String fromUserName,
				   Long createTime) {
		super(toUserName, fromUserName, createTime, MsgType.MSG_TYPE_TEXT);
	}

	public TextMsg(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MsgType.MSG_TYPE_TEXT);
	}

	public TextMsg(Msg msg, Long createTime) {
		super(msg, createTime, MsgType.MSG_TYPE_TEXT);
	}

	public TextMsg(Msg msg) {
		super(msg, MsgType.MSG_TYPE_TEXT);
	}


	@Override
	public String toString() {
		return "TextMsg{" +
				"content='" + content + '\'' +
				", toUserName='" + toUserName + '\'' +
				", fromUserName='" + fromUserName + '\'' +
				", createTime=" + createTime +
				", msgType='" + msgType + '\'' +
				'}';
	}
}
