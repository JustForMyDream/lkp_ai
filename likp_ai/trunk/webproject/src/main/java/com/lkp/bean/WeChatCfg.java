package com.lkp.bean;

/**微信配置bean
 *
 */
public class WeChatCfg {
    private String appId;
    private String eventToken;
    private String appSecret;
    private String key;
    private String user;
    private String domain;
    private String mic_id;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getEventToken() {
        return eventToken;
    }

    public void setEventToken(String eventToken) {
        this.eventToken = eventToken;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getMic_id() {
        return mic_id;
    }

    public void setMic_id(String mic_id) {
        this.mic_id = mic_id;
    }
}
