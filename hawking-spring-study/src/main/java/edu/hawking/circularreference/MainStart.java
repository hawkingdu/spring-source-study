package edu.hawking.circularreference;

import edu.hawking.postprocessor.JdkProxyBeanPostProcessor;
import edu.hawking.service.Aservice;
import edu.hawking.service.Bservice;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 杜皓君 created by 2021/4/23
 * MainStart
 **/
public class MainStart {

	private final static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

	/**单例池：一级缓存**/
	private final static Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
	/** 先期创建单例池： 二级缓存，为了将 完整的bean 和 纯净bean分离， 避免读取到不完整的bean*/
	private final static Map<String, Object> earlySingletonObjects = new HashMap<>(16);
	/**单例工厂池：三级缓存**/
	private final static Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);


	public static void loadBeanDefinition() {
		RootBeanDefinition rbdA = new RootBeanDefinition(Aservice.class);
		RootBeanDefinition rbdB = new RootBeanDefinition(Bservice.class);
		beanDefinitionMap.put("aservice", rbdA);
		beanDefinitionMap.put("bservice", rbdB);
	}

	public static void main(String[] args) throws Exception {
		loadBeanDefinition();
		// 注册

		for (String key : beanDefinitionMap.keySet()) {
			getBean(key);
		}

	}
	public static Object getBean(String key) throws IllegalAccessException, InstantiationException {

		Object singleton = getSingleton(key);
		if (singleton != null) {
			return singleton;
		}

		RootBeanDefinition rootBeanDefinition = (RootBeanDefinition) beanDefinitionMap.get(key);
		Class<?> beanClass = rootBeanDefinition.getBeanClass();
		// 实例化
		Object instanceBean = beanClass.newInstance();

		// 创建动态代理
		instanceBean = new JdkProxyBeanPostProcessor().getEarlyBeanReference(instanceBean, key);

		// 添加二级缓存
		earlySingletonObjects.put(key, instanceBean);

		for (Field field : beanClass.getDeclaredFields()) {
			Autowired annotation = field.getAnnotation(Autowired.class);
			//属性赋值
			if (annotation != null) {
				field.setAccessible(true);
				String name = field.getName();
				Object fieldObj = getBean(name);
				field.set(instanceBean, fieldObj);
			}
		}

		// 添加一级缓存
		singletonObjects.put(key, instanceBean);

		return instanceBean;
	}

	public static Object getSingleton(String beanName) {
		if (singletonObjects.containsKey(beanName)) {
			return singletonObjects.get(beanName);
		} else if (earlySingletonObjects.containsKey(beanName)){
			return earlySingletonObjects.get(beanName);
		}
		return null;
	}

	public static void addSingleton(String beanName, Object singletonObject) {

	}
}
