package io.github.forezp.permission.whiteurl;

import io.github.forezp.permission.whiteurl.WhiteUrlFinder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by forezp on 2018/8/5.
 */
@Component
public class WhiteUrlFindlerImpl implements WhiteUrlFinder, InitializingBean {

    private static final String COMMA = ",";

    @Value("${permission.whiteurls:}")
    String whiteurls;

    List<String> whiteurlsList = new ArrayList<>();

    @Override
    public boolean isWhiteUrl(String url) {
        if (whiteurlsList.contains(url)) {
            return true;
        }
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isNoneBlank(whiteurls)) {
            whiteurlsList = Arrays.asList(whiteurls.split(COMMA));
        }
    }
}
