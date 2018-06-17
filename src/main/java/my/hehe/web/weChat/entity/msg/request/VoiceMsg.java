package my.hehe.web.weChat.entity.msg.request;


public interface VoiceMsg  extends Msg {




	public String getMediaId() ;

	public String getFormat() ;

	public String getRecognition() ;

	public void setMediaId(String mediaId) ;

	public void setFormat(String format) ;

	public void setRecognition(String recognition);




}
