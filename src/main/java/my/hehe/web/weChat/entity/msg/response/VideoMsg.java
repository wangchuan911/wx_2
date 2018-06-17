package my.hehe.web.weChat.entity.msg.response;


import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.msg.request.Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoMsg extends MsgBody {
	@XmlElement(name = "Video")
	private final Video Video = new Video();

	public void setMediaId(String mediaId) {
		Video.setMediaId(mediaId);
	}

	public String getMediaId() {
		return Video.getMediaId();
	}

	public String getTitle() {
		return Video.getTitle();
	}

	public String getDescription() {
		return Video.getDescription();
	}

	public void setTitle(String title) {
		Video.setTitle(title);
	}

	public void setDescription(String description) {
		Video.setDescription(description);
	}
	
	public void setVideoInfo(String MediaId,String Title,String Description){
		Video.setTitle(Title);
		Video.setDescription(Description);
		Video.setMediaId(MediaId);
	}

	public VideoMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoMsg(Msg msg, Long createTime) {
		super(msg, createTime, MsgType.MSG_TYPE_VIDEO);

		// TODO Auto-generated constructor stub
	}

	public VideoMsg(Msg msg) {
		super(msg, MsgType.MSG_TYPE_VIDEO);
		// TODO Auto-generated constructor stub
	}

	public VideoMsg(String toUserName, String fromUserName,
						Long createTime) {
		super(toUserName, fromUserName, createTime, MsgType.MSG_TYPE_VIDEO);
		// TODO Auto-generated constructor stub
	}

	public VideoMsg(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MsgType.MSG_TYPE_VIDEO);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Video {
	@XmlElement(name = "MediaId")
	private String MediaId;
	@XmlElement(name = "Title")
	private String Title;
	@XmlElement(name = "Description")
	private String Description;

	public String getMediaId() {
		return MediaId;
	}

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

}