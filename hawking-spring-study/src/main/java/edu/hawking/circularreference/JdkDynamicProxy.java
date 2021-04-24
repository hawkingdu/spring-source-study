package edu.hawking.circularreference;

/**
 * 杜皓君 created by 2021/4/23
 * JdkDynamicProxy
 **/
public class JdkDynamicProxy {
	Object proxy;

	public JdkDynamicProxy(Object proxy) {
		this.proxy = proxy;
	}

	public Object getProxy() {
		return proxy;
	}

	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
}
