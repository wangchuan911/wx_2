package my.hehe.web.weChat.entity.msg.response;


import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.msg.request.Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageMsg extends MsgBody {
	@XmlElement(name = "Image")
	private final Image image = new Image();

	public void setMediaId(String mediaId) {
		image.setMediaId(mediaId);
	}

	public String getMediaId() {
		return image.getMediaId();
	}

	public ImageMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageMsg(Msg msg, Long createTime) {
		super(msg, createTime, MsgType.MSG_TYPE_IMAGE);

		// TODO Auto-generated constructor stub
	}

	public ImageMsg(Msg msg) {
		super(msg, MsgType.MSG_TYPE_IMAGE);
		// TODO Auto-generated constructor stub
	}

	public ImageMsg(String toUserName, String fromUserName,
						Long createTime) {
		super(toUserName, fromUserName, createTime, MsgType.MSG_TYPE_IMAGE);
		// TODO Auto-generated constructor stub
	}

	public ImageMsg(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MsgType.MSG_TYPE_IMAGE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ImageMsg{" +
				"image=" + image +
				", toUserName='" + toUserName + '\'' +
				", fromUserName='" + fromUserName + '\'' +
				", createTime=" + createTime +
				", msgType='" + msgType + '\'' +
				'}';
	}
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Image {
	@XmlElement(name = "MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}