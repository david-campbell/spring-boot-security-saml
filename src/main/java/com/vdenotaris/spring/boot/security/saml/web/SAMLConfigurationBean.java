package com.vdenotaris.spring.boot.security.saml.web;

import org.opensaml.Configuration;
import org.opensaml.xml.security.BasicSecurityConfiguration;
import org.opensaml.xml.signature.SignatureConstants;

public class SAMLConfigurationBean {
	private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.SHA256;
	public final void setSignatureAlgorithm(String s) {
		try {
			signatureAlgorithm = SignatureAlgorithm.valueOf(s);
		} catch (RuntimeException ex) {
			signatureAlgorithm = SignatureAlgorithm.SHA256;
		}
	}
	
	public void configureAlgorithm() throws Exception {
		BasicSecurityConfiguration config = (BasicSecurityConfiguration) Configuration.getGlobalSecurityConfiguration();
		switch (signatureAlgorithm) {
	    	case SHA1:
	    		config.registerSignatureAlgorithmURI("RSA", SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA1);
	    		config.setSignatureReferenceDigestMethod(SignatureConstants.ALGO_ID_DIGEST_SHA1);
	    		break;
	    	case SHA256:
		        config.registerSignatureAlgorithmURI("RSA", SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA256);
		        config.setSignatureReferenceDigestMethod(SignatureConstants.ALGO_ID_DIGEST_SHA256);
		        break;
	    	case SHA512:
		        config.registerSignatureAlgorithmURI("RSA", SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA512);
		        config.setSignatureReferenceDigestMethod(SignatureConstants.ALGO_ID_DIGEST_SHA512);
		        break;
		    default:
		    	config.registerSignatureAlgorithmURI("RSA", SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA256);
		        config.setSignatureReferenceDigestMethod(SignatureConstants.ALGO_ID_DIGEST_SHA256);
		        break;
		}
	}
	
	public enum SignatureAlgorithm {
		SHA1,
		SHA256,
		SHA512
	}
}
