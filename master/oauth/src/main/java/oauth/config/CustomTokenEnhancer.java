package oauth.config;

import oauth.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer extends JwtAccessTokenConverter implements TokenEnhancer
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication)
    {
        Map<String, Object> additionInfo = new HashMap<>();
        additionInfo.put("id", "2");

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionInfo);

        String encoded = super.encode(oAuth2AccessToken, oAuth2Authentication);

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setValue(encoded);

        return oAuth2AccessToken;
    }
}
