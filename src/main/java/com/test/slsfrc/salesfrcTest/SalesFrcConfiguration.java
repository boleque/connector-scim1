package com.test.slsfrc.salesfrcTest;


import org.identityconnectors.common.StringUtil;
import org.identityconnectors.framework.spi.AbstractConfiguration;
import org.identityconnectors.framework.spi.ConfigurationProperty;
import org.identityconnectors.framework.spi.StatefulConfiguration;

public class SalesFrcConfiguration extends AbstractConfiguration implements StatefulConfiguration {

	private static String SCIM_ENDPOINT = "/services/scim";
    private static String SCIM_VERSION = "/v1";
    
    private  String USERNAME;
    private  String PASSWORD;
    private  String LOGINURL= "https://login.salesforce.com";
    private  String SERVICEGRANT = "/services/oauth2/token?grant_type=password";
    private  String CLIENTID;
    private  String CLIENTSECRET;

	@ConfigurationProperty(order = 1, displayMessageKey = "USERNAME.display",
            groupMessageKey = "basic.group", helpMessageKey = "USERNAME.help", required = true,
            confidential = false)
	
	public String getUserName() {
        return USERNAME;
    }

    public void setUserName(String username) {
        this.USERNAME = username;
    }
    
    @ConfigurationProperty(order = 2, displayMessageKey = "PASSWORD.display",
            groupMessageKey = "basic.group", helpMessageKey = "PASSWORD.help", required = true,
            confidential = false)
    
    public String getPassword(){
    	return PASSWORD;
    	
    }
    
    public void setPassword(String passwd) {
		this.PASSWORD = passwd;
	}
	
    @ConfigurationProperty(order = 3, displayMessageKey = "CLIENTSECRET.display",
            groupMessageKey = "basic.group", helpMessageKey = "CLIENTSECRET.help", required = true,
            confidential = false)
    
    public String getClientSecret() {
        return CLIENTSECRET;
    }
    
    public void setClientSecret(String clientSecret) {
        this.CLIENTSECRET = clientSecret;
    }
    
    @ConfigurationProperty(order = 4, displayMessageKey = "refreshtoken.display",
            groupMessageKey = "basic.group", helpMessageKey = "refreshtoken.help", required = true,
            confidential = false)
    public String getClientID() {
        return CLIENTID;
    }

    public void setClientID(String clientID) {
        this.CLIENTID = clientID;
    }
    
    public String getEndpoint() {
        return SCIM_ENDPOINT;
    }

    public void setEndpoint(String endpoint) {
        this.SCIM_ENDPOINT = endpoint;
    }
    
    public String getVersion() {
        return SCIM_VERSION;
    }
    
    public void setVersion(String version) {
        this.SCIM_VERSION = version;
    }
    
    public String getLoginURL() {
        return LOGINURL;
    }
    
    public void setLoginURL(String loginURL) {
        this.LOGINURL = loginURL;
    }
    
    public String getService() {
        return SERVICEGRANT;
    }
    
    public void setService(String service) {
        this.SERVICEGRANT = service;
    }
	
	@Override
	public void validate() {

		if (StringUtil.isBlank(USERNAME)){
			throw new IllegalArgumentException("Username cannot be null or empty");	
		}
		
		if (StringUtil.isBlank(PASSWORD)){
			throw new IllegalArgumentException("Password cannot be null or empty");
		}
		
		if ( StringUtil.isBlank(CLIENTSECRET)){
			throw new IllegalArgumentException("Client Secret cannot be null or empty.");
		}
		
		if  (StringUtil.isBlank(USERNAME)){
	            throw new IllegalArgumentException("Client id cannot be null or empty.");
	        }
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}
	
	

}
