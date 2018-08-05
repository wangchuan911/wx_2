package my.hehe.web.weChat;

import my.hehe.web.weChat.entity.Token;
import my.hehe.web.weChat.entity.encrypt.AesException;
import my.hehe.web.weChat.entity.encrypt.WXBizMsgCrypt;
import my.hehe.web.weChat.filter.encrypt.MsgEncryptFilter;
import my.hehe.web.weChat.services.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@EnableScheduling

@Configuration
public class WeChatConfiguration {

    @Autowired
    MsgEncryptFilter msgEncryptFilter;

    @Autowired
    WeChatService weChatService;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Scheduled(initialDelay = 0, fixedDelayString = "${wechat.schedul.delay}")
    // cron = "0 0/5 * * * ? "
    // "1/5 * * * * ?"
    public void schedulSyncToken(@Value("${wechat.schedul.power}") boolean schedulOn) {
        if(schedulOn)
            this.freshToken(0);
    }

    @Value("${wechat.prop.appID}")
    private String appID;

    @Value("${wechat.prop.appsecret}")
    private String appsecret;

    @Value("${wechat.prop.token}")
    private String apptoken;

    @Bean
    public WXBizMsgCrypt getWXBizMsgCrypt(
            @Value("${wechat.prop.token}")String apptoken,
            @Value("${wechat.prop.key}")String  appsecret,
            @Value("${wechat.prop.appID}")String  appID)throws AesException {
        return new WXBizMsgCrypt( apptoken,  appsecret,  appID);
    }

    @Value("${wechat.url.getToken}")
    private String getToken_url;

    @Value("${wechat.url.sendToUser}")
    private String sendToUser_url;

    @Value("${wechat.url.getIPs}")
    private String getIPs_url;



    private Token accessToken=new Token();;
    @Bean
    public Token getToken(){
        return accessToken;
    }

    @Autowired
    private RestTemplate restTemplate;


    private void freshToken(int early) {
        Map<String, String> map=null;
        if (map == null) {
            map = new HashMap<String, String>(4);
            map.put("appid", this.appID);
            map.put("secret", this.appsecret);
        }
        if (early != 0
                && accessToken != null
                && (accessToken.getExpires_date().getTimeInMillis()
                - (Calendar.getInstance().getTimeInMillis()) > (early * 1000 * 60))) {
            return;
        }
        accessToken.setToken(restTemplate.getForObject(getToken_url, Token.class,
                map));
        System.out.println("new token:"+accessToken);
    }

    public void freshToken() {
        freshToken(0);
    }
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Bean
    public FilterRegistrationBean getMsgEncryptFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // Filter httpEncryptFilter = new HttpEncryptFilter();
        // characterEncodingFilter();

        beanFactory.autowireBean(msgEncryptFilter);
        registration.setFilter(msgEncryptFilter);
        registration.addUrlPatterns("/wx");
        registration.setOrder(-65534);
        return registration;
    }

    @Bean
    public FilterRegistrationBean getCharacterEncodingFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        Filter EncodingFilter = characterEncodingFilter();
        beanFactory.autowireBean(EncodingFilter);
        registration.setFilter(EncodingFilter);
        registration.setOrder(-65535);
        registration.addUrlPatterns("/*");
        return registration;
    }
    @Bean
    public Jaxb2RootElementHttpMessageConverter getJaxb2RootElementHttpMessageConverter() {
        return new Jaxb2RootElementHttpMessageConverter();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("**")// api.getIP()
                        .allowedMethods("POST");
            }
        };
    }


}
