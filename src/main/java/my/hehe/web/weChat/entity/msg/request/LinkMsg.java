package my.hehe.web.weChat.entity.msg.request;


public interface LinkMsg  extends Msg{

    public String getTitle();

    public String getDescription();

    public String getUrl();

    public void setTitle(String title);

    public void setDescription(String description);

    public void setUrl(String url);


}
