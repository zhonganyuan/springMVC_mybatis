package com.wkb.core.data;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 数据源切面设置
 * @author huanglt
 *
 */
public class DataSourceAspect {
	
	
	/**
	 * 动态切换数据源，设置数据源
	 * @param point
	 */
	
    public void before(JoinPoint point) {
        String method = point.getSignature().getName();
        Class<?> tclass=point.getSignature().getDeclaringType();
        Class<?>[] classz = point.getTarget().getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
        	Method m=null;
        	if(classz != null && classz.length > 0){
        		m = classz[0].getMethod(method, parameterTypes);
        	}
            if (m != null && m.isAnnotationPresent(Datasource.class)) {
                Datasource data = m.getAnnotation(Datasource.class);
                DynamicDataSourceHolder.putDataSource(data.value());
            }else if(tclass.isAnnotationPresent(Datasource.class)){
            	Datasource data = (Datasource) tclass.getAnnotation(Datasource.class);
            	DynamicDataSourceHolder.putDataSource(data.value());
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    /**
	 * 动态切换数据源，移除数据源
	 * @param point
	 */
    public void after(JoinPoint point){
    	DynamicDataSourceHolder.clearDataSource();
    }
}
