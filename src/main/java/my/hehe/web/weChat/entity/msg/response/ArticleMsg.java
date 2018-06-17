package my.hehe.web.weChat.entity.msg.response;


import my.hehe.web.weChat.entity.msg.request.Msg;
import my.hehe.web.weChat.entity.define.MsgType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArticleMsg extends MsgBody {

	@XmlElement(name = "ArticleCount")
	private int articleCount;

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	private final List<Article> articles = new ArrayList<Article>();

	public void setArticleInfo(String Title, String Description, String PicUrl,
			String Url) {
		Article article = new Article();
		article.setTitle(Title);
		article.setDescription(Description);
		article.setPicUrl(PicUrl);
		article.setUrl(Url);
		this.articles.add(article);
		this.articleCount = articles.size();

	}

	public ArticleMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleMsg(Msg msg, Long createTime) {
		super(msg, createTime,MsgType.MSG_TYPE_ARTICLE);

		// TODO Auto-generated constructor stub
	}

	public ArticleMsg(Msg msg) {
		super(msg, MsgType.MSG_TYPE_ARTICLE);
		// TODO Auto-generated constructor stub
	}

	public ArticleMsg(String toUserName, String fromUserName,
						  Long createTime) {
		super(toUserName, fromUserName, createTime, MsgType.MSG_TYPE_ARTICLE);
		// TODO Auto-generated constructor stub
	}

	public ArticleMsg(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, MsgType.MSG_TYPE_ARTICLE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ArticleMsg{" +
				"articleCount=" + articleCount +
				", articles=" + articles +
				", toUserName='" + toUserName + '\'' +
				", fromUserName='" + fromUserName + '\'' +
				", createTime=" + createTime +
				", msgType='" + msgType + '\'' +
				'}';
	}
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Article {

	@XmlElement(name = "Title")
	private String title;
	@XmlElement(name = "Description")
	private String description;
	@XmlElement(name = "PicUrl")
	private String picUrl;
	@XmlElement(name = "Url")
	private String url;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}