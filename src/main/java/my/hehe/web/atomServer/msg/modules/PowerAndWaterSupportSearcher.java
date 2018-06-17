package my.hehe.web.atomServer.msg.modules;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class PowerAndWaterSupportSearcher {
    private String URL;

    public PowerAndWaterSupportSearcher(String url) {
        this.URL = url;
    }

    public List<HtmlInfo> TD(String location, int count, long time) {
        List<HtmlInfo> infos = null;
        try {
            StringBuffer str = new StringBuffer(URL);
            int prefix = str.indexOf("{", 0);
            int suffix = str.indexOf("}", prefix) + 1;
            StringBuffer url = new StringBuffer();
            url.append(str.substring(0, prefix)).append(location).append(str.substring(suffix));
            int i = url.lastIndexOf("/");
            String encoder_str = URLEncoder.encode(url.substring(i + 1).toString(), "utf-8");
            url.replace(i + 1, encoder_str.length(), encoder_str);
            Document document = Jsoup.connect(url.toString()).get();
            infos = this.parse4Template(document, HtmlInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer("[");
        if (infos != null) {
            int i;
            while ((i = infos.size()) > count) {
                infos.remove(i - 1);
            }
        }
        return infos;
    }


    private List<Object> parse(Document doc) {
        List<Object> result = new ArrayList<Object>();
        Elements elements = doc.getElementsByClass("prolist");
        for (Element datas : elements) {
            try {
                long id = Long.parseLong(datas.getElementsByClass("post").get(0).attr("id"));
                String href = null;
                String date = null;
                String info = null;
                Elements body = datas.getElementsByClass("post-header");
                List<Node> values = body.get(0).childNodes();
                href = values.get(0).attr("href");
                date = values.get(2).childNode(0).childNode(0).outerHtml();
                info = values.get(5).childNode(0).childNode(0).outerHtml();
                result.add(new HtmlInfo(id, href, date, info));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return result;
    }

    private <T> List<T> parse4Template(Document doc, Class<T> t) {
        List<T> result = new ArrayList<T>();
        Elements elements = doc.getElementsByClass("prolist");
        for (Element datas : elements) {
            try {
                long id = Long.parseLong(datas.getElementsByClass("post").get(0).attr("id"));
                String href = null;
                String date = null;
                String info = null;
                Elements body = datas.getElementsByClass("post-header");
                List<Node> values = body.get(0).childNodes();
                href = values.get(0).attr("href");
                date = values.get(2).childNode(0).childNode(0).outerHtml();
                info = values.get(5).childNode(0).childNode(0).outerHtml();
                result.add(t.getConstructor(long.class, String.class, String.class, String.class).newInstance(id, href, date, info));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return result;
    }
}

class HtmlInfo {
    private long id;
    private String href;
    private String createDate;
    private String info;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public HtmlInfo(long id, String href, String createDate, String info) {
        super();
        this.id = id;
        this.href = href;
        this.createDate = createDate;
        this.info = info;
    }

    public HtmlInfo() {
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{\"id\":\"").append(id).append("\",\"href\":\"").append(href).append("\",\"date\":\"").append(createDate).append("\",\"info\":\"").append(info).append("\"}");
        return sb.toString();
    }
}