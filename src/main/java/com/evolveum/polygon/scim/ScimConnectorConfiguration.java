package com.evolveum.polygon.scim;

import org.identityconnectors.common.StringUtil;
import org.identityconnectors.common.logging.Log;
import org.identityconnectors.framework.spi.AbstractConfiguration;
import org.identityconnectors.framework.spi.ConfigurationProperty;
import org.identityconnectors.framework.spi.StatefulConfiguration;

/**
 * Connector configuration class. It contains all the needed methods for
 * processing the connector configuration.
 */
public class ScimConnectorConfiguration extends AbstractConfiguration implements StatefulConfiguration {
	
	private String AUTHENTICATION = "token";
	private String SCIM_ENDPOINT = "/scim";
	private String SCIM_VERSION = "/v1";
	private String USERNAME = "**";
	private String PASSWORD = "**";
	private String LOGINURL = "";
	private String BASEURL = "https://api.slack.com";
	private String GRANT = "**";
	private String CLIENTID = "**";
	private String TOKEN = "";
	private String CLIENTSECRET = "**";

	private static final Log LOGGER = Log.getLog(ScimConnectorConfiguration.class);

	/**
	 * Getter method for the "AUTHENTICATION" attribute.
	 * 
	 * @return the authentication string.
	 */
	
	@ConfigurationProperty(order = 1, displayMessageKey = "Authentication", groupMessageKey = "basic.group", helpMessageKey = "Please provide the type of authentication.", required = true, confidential = false)
	public String getAuthentication() {
		return AUTHENTICATION;
	}

	/**
	 * Setter method for the "AUTHENTICATION" attribute.
	 * 
	 * @param username
	 *            the authentication string value.
	 */
	public void setAuthentication(String authentication) {
		this.AUTHENTICATION = authentication;
	}

	
	@ConfigurationProperty(order = 2, displayMessageKey = "Username", groupMessageKey = "basic.group", helpMessageKey = "Please provide the administrator user name for the scim enabled service you are logging into", required = true, confidential = false)

	public String getUserName() {
		return USERNAME;
	}

	/**
	 * Setter method for the "USERNAME" attribute.
	 * 
	 * @param username
	 *            the user name string value.
	 */
	public void setUserName(String username) {
		this.USERNAME = username;
	}

	/**
	 * Getter method for the "PASSWORD" attribute.
	 * 
	 * @return the password.
	 */
	@ConfigurationProperty(order = 3, displayMessageKey = "Password", groupMessageKey = "basic.group", helpMessageKey = "Please provide the administrator password used to connect to the scim enabled service", required = true, confidential = true)

	public String getPassword() {
		return PASSWORD;

	}

	/**
	 * Setter method for the "PASSWORD" attribute.
	 * 
	 * @param passwd
	 *            the password string value.
	 */
	public void setPassword(String passwd) {
		this.PASSWORD = passwd;
	}

	/**
	 * Getter method for the "CLIENTSECRET" attribute.
	 * 
	 * @return the client secret.
	 */
	@ConfigurationProperty(order = 4, displayMessageKey = "Clientsecret", groupMessageKey = "basic.group", helpMessageKey = "Please provide the client token generated by the service endpoint for application interconnection", required = true, confidential = true)

	public String getClientSecret() {
		return CLIENTSECRET;
	}

	/**
	 * Setter method for the "CLIENTSECRET" attribute.
	 * 
	 * @param clientSecret
	 *            the client secret string value.
	 */
	public void setClientSecret(String clientSecret) {
		this.CLIENTSECRET = clientSecret;
	}

	/**
	 * Getter method for the "CLIENTID" attribute.
	 * 
	 * @return the client id.
	 */
	@ConfigurationProperty(order = 5, displayMessageKey = "Client ID", groupMessageKey = "basic.group", helpMessageKey = "Please provide the client ID generated by the service endpoint", required = true, confidential = false)
	public String getClientID() {
		return CLIENTID;
	}

	/**
	 * Setter method for the "CLIENTID" attribute.
	 * 
	 * @param clientID
	 *            the client id string value.
	 */
	public void setClientID(String clientID) {
		this.CLIENTID = clientID;
	}

	/**
	 * Getter method for the "SCIM_ENDPOINT" attribute.
	 * 
	 * @return the scim endpoint.
	 */
	@ConfigurationProperty(order = 6, displayMessageKey = "Scim endpoint", groupMessageKey = "basic.group", helpMessageKey = "Please provide the scim endpoint of the service provider (eg. /services/scim)", required = true, confidential = false)

	public String getEndpoint() {
		return SCIM_ENDPOINT;
	}

	/**
	 * Setter method for the "SCIM_ENDPOINT" attribute.
	 * 
	 * @param endpoint
	 *            the scim endpoint string value.
	 */
	public void setEndpoint(String endpoint) {
		this.SCIM_ENDPOINT = endpoint;
	}

	/**
	 * Getter method for the "SCIM_VERSION" attribute.
	 * 
	 * @return the scim version.
	 */
	@ConfigurationProperty(order = 7, displayMessageKey = "Scim version", groupMessageKey = "basic.group", helpMessageKey = "Please provide the scim version which is supported by the service provider (eq. /v1)", required = true, confidential = false)

	public String getVersion() {
		return SCIM_VERSION;
	}

	/**
	 * Setter method for the "SCIM_VERSION" attribute.
	 * 
	 * @param version
	 *            the scim version string value.
	 */
	public void setVersion(String version) {
		this.SCIM_VERSION = version;
	}

	/**
	 * Getter method for the "LOGINURL" attribute.
	 * 
	 * @return the login url.
	 */
	@ConfigurationProperty(order = 8, displayMessageKey = "Login url", groupMessageKey = "basic.group", helpMessageKey = "Please provide the Url address for log in", required = true, confidential = false)

	public String getLoginURL() {
		return LOGINURL;
	}

	/**
	 * Setter method for the "LOGINURL" attribute.
	 * 
	 * @param loginURL
	 *            the login url string value.
	 */
	public void setLoginURL(String loginURL) {
		this.LOGINURL = loginURL;
	}

	/**
	 * Getter method for the "SERVICEGRANT" attribute.
	 * 
	 * @return the service grant.
	 */
	@ConfigurationProperty(order = 9, displayMessageKey = "Grant type", groupMessageKey = "basic.group", helpMessageKey = "Please provide the ulr snippet defining the service and grand type to log into the service (eg. /services/oauth2/token?grant_type=password)", required = true, confidential = false)

	public String getService() {
		return GRANT;
	}

	/**
	 * Setter method for the "SERVICEGRANT" attribute.
	 * 
	 * @param service
	 *            the grant type string value.
	 */
	public void setService(String service) {
		this.GRANT = service;
	}
	
	
	@ConfigurationProperty(order = 10, displayMessageKey = "Base URL", groupMessageKey = "advanced.group", helpMessageKey = "Please provide the base url for a token type of authentication.", required = true, confidential = false)
	public String getBaseUrl() {
		return BASEURL;
	}

	/**
	 * Setter method for the "BASEURL" attribute.
	 * 
	 * @param username
	 *            the user name string value.
	 */
	public void setBaseUrl(String baseUrl) {
		this.BASEURL = baseUrl;
	}
	
	@ConfigurationProperty(order = 11, displayMessageKey = "Token", groupMessageKey = "advanced.group", helpMessageKey = "Please provide the token for a token type of authentication.", required = true, confidential = false)
	public String getToken() {
		return TOKEN;
	}

	/**
	 * Setter method for the "TOKEN" attribute.
	 * 
	 * @param username
	 *            the user name string value.
	 */
	public void setToken(String token) {
		this.TOKEN = token;
	}

	@Override
	public void validate() {
		
		if (StringUtil.isBlank(AUTHENTICATION)) {
			throw new IllegalArgumentException("Authentication cannot be empty.");
		}
		
		if (!"token".equals(AUTHENTICATION)){

		if (StringUtil.isBlank(USERNAME)) {
			throw new IllegalArgumentException("Username cannot be empty");
		}

		if (StringUtil.isBlank(PASSWORD)) {
			throw new IllegalArgumentException("Password cannot be empty");
		}

		if (StringUtil.isBlank(CLIENTSECRET)) {
			throw new IllegalArgumentException("Client Secret cannot be empty.");
		}

		if (StringUtil.isBlank(LOGINURL)) {
			throw new IllegalArgumentException("Login url cannot be empty.");
		}
		if (StringUtil.isBlank(GRANT)) {
			throw new IllegalArgumentException("Grant type cannot be empty.");
		}
		if (StringUtil.isBlank(CLIENTID)) {
			throw new IllegalArgumentException("Client id cannot be empty.");
		}
		
		}else {
			
			if (StringUtil.isBlank(TOKEN)) {
				throw new IllegalArgumentException("Token cannot be empty.");
			}
			if (StringUtil.isBlank(BASEURL)) {
				throw new IllegalArgumentException("Base URL cannot be empty.");
			}
			
		}
		
		if (StringUtil.isBlank(SCIM_ENDPOINT)) {
			throw new IllegalArgumentException("Scim endpoint cannot be empty.");
		}
		if (StringUtil.isBlank(SCIM_VERSION)) {
			throw new IllegalArgumentException("Scim version cannot be empty.");
		}
		LOGGER.info("Configuration valid");
	}

	@Override
	public void release() {
		this.LOGINURL = null;
		this.SCIM_VERSION = null;
		this.SCIM_ENDPOINT = null;
		this.CLIENTID = null;
		this.CLIENTSECRET = null;
		this.PASSWORD = null;
		this.USERNAME = null;
		this.GRANT = null;
	}

}
