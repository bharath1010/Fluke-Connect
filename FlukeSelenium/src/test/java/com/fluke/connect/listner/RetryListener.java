package com.fluke.connect.listner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.ITestAnnotation;

@SuppressWarnings("unused")
public class RetryListener implements IAnnotationTransformer {

	public String messageBody;

	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {

		IRetryAnalyzer retry = arg0.getRetryAnalyzer();

		if (retry == null) {
			arg0.setRetryAnalyzer(Retry.class);
		}

	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

}
