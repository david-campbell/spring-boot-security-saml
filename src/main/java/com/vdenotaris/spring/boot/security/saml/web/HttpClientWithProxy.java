package com.vdenotaris.spring.boot.security.saml.web;


import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.velocity.runtime.parser.node.SetPropertyExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientWithProxy extends org.apache.commons.httpclient.HttpClient {

	private final Logger log = LoggerFactory.getLogger(HttpClientWithProxy.class);
	
	private static final boolean useProxy = false;
	private static final String PROXY_IP = "204.40.130.129";
    private static final int PROXY_PORT = 3128;
	
    public HttpClientWithProxy() {
    	super();
    	setProxyConfiguration(this);
    }
    public HttpClientWithProxy(HttpClientParams params) {
    	super(params);
    	setProxyConfiguration(this);
    }
    public HttpClientWithProxy(HttpConnectionManager httpConnectionManager) {
    	super(httpConnectionManager);
    	setProxyConfiguration(this);
    }
    public HttpClientWithProxy(HttpClientParams params, HttpConnectionManager httpConnectionManager) {
    	super(params, httpConnectionManager);
    	setProxyConfiguration(this);
    }
    
    private void setProxyConfiguration(HttpClientWithProxy httpClientWithProxy) {
    	if ( useProxy )
    		httpClientWithProxy.getHostConfiguration().setProxy(PROXY_IP, PROXY_PORT);
    }
}
