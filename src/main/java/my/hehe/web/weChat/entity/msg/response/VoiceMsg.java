package my.hehe.web.weChat.entity.msg.response;

import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.msg.request.Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceMsg extends MsgBody {
	@XmlElement(name = "Voice")
	private final Voice voice = new Voice();

	public void setMediaId(String mediaId) {
		voice.setMediaId(mediaId);
	}

	public String getMediaId() {
		return voice.getMediaId();
	}

	public VoiceMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoiceMsg(Msg msg, Long createTime) {
		super(msg, createTime, MsgType.MSG_TYPE_VOICE);

		// TODO Auto-generated constructor stub
	}

	public VoiceMsg(Msg msg) {
		super(msg, MsgType.MSG_TYPE_VOICE);
		// TODO Auto-generated constructor stub
	}

	public VoiceMsg(String toUserName, String fromUserName,
						Long createTime) {
		super(toUserName, fromUserName, createTime, MsgType.MSG_TYPE_VOICE);
		// TODO Auto-generated constructor stub
	}

	public VoiceMsg(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MsgType.MSG_TYPE_VOICE);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Voice {
	@XmlElement(name = "MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}