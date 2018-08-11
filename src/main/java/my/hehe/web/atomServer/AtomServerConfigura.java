package my.hehe.web.atomServer;

import my.hehe.web.atomServer.msg.modules.PowerAndWaterSupportSearcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("atomSrv")
public class AtomServerConfigura {
    @Bean
    public PowerAndWaterSupportSearcher getPowerAndWaterSupportSeacher(@Value("${modules.tstdtz.url.powerSearch}") String url) {
        return new PowerAndWaterSupportSearcher(url);
    }

}
