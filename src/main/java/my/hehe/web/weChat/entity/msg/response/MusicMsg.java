package my.hehe.web.weChat.entity.msg.response;


import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.msg.request.Msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicMsg extends MsgBody {
	@XmlElement(name = "Music")
	private final Music music = new Music();

	public String getTitle() {
		return music.getTitle();
	}

	public String getDescription() {
		return music.getDescription();
	}

	public String getMusicUrl() {
		return music.getMusicUrl();
	}

	public String getHQMusicUrl() {
		return music.getHQMusicUrl();
	}

	public String getThumbMediaId() {
		return music.getThumbMediaId();
	}

	public void setMusicUrl(String musicUrl) {
		music.setMusicUrl(musicUrl);
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		music.setHQMusicUrl(hQMusicUrl);
	}

	public void setThumbMediaId(String thumbMediaId) {
		music.setThumbMediaId(thumbMediaId);
	}

	public void setTitle(String title) {
		music.setTitle(title);
	}

	public void setDescription(String description) {
		music.setDescription(description);
	}

	public void setMusicInfo(String Title, String Description, String MusicUrl,
			String HQMusicUrl, String ThumbMediaId) {
		music.setTitle(Title);
		music.setDescription(Description);
		music.setHQMusicUrl(HQMusicUrl);
		music.setThumbMediaId(ThumbMediaId);
		music.setMusicUrl(MusicUrl);
	}

	public MusicMsg() {
		super();
		super.setMsgType(MsgType.MSG_TYPE_MUSIC);
		// TODO Auto-generated constructor stub
	}

	public MusicMsg(Msg msg, Long createTime) {
		super(msg, createTime,MsgType.MSG_TYPE_MUSIC);

		// TODO Auto-generated constructor stub
	}

	public MusicMsg(Msg msg) {
		super(msg, MsgType.MSG_TYPE_MUSIC);
		// TODO Auto-generated constructor stub
	}

	public MusicMsg(String toUserName, String fromUserName,
						Long createTime) {
		super(toUserName, fromUserName, createTime, MsgType.MSG_TYPE_MUSIC);
		// TODO Auto-generated constructor stub
	}

	public MusicMsg(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MsgType.MSG_TYPE_MUSIC);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Music {

	@XmlElement(name = "MediaId")
	private String title;
	@XmlElement(name = "Description")
	private String description;
	@XmlElement(name = "MusicUrl")
	private String musicUrl;
	@XmlElement(name = "HQMusicUrl")
	private String hqMusicUrl;
	@XmlElement(name = "ThumbMediaId")
	private String thumbMediaId;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public String getHQMusicUrl() {
		return hqMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		this.hqMusicUrl = hQMusicUrl;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}