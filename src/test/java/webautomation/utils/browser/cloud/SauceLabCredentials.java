package webautomation.utils.browser.cloud;

import webautomation.utils.PropertyFileReader;

public class SauceLabCredentials {
    private static final String SAUCE_KEY = "sauce_lab_key";
    private static final String USER_NAME = "sauce_lab_username";

    public String getUserName() {
        return new PropertyFileReader().readPropertyFile().getProperties().getProperty(USER_NAME);
    }

    public String getSauceKey() {
        return new PropertyFileReader().readPropertyFile().getProperties().getProperty(SAUCE_KEY);
    }


}
