// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2012 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ReflectPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.reflection.invoker.GetFieldInvoker;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.invoker.MethodInvoker;
import org.apache.ibatis.reflection.invoker.SetFieldInvoker;
import org.apache.ibatis.reflection.property.PropertyNamer;

/*
 * This class represents a cached set of class definition information that
 * allows for easy mapping between property names and getter/setter methods.
 */
/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Reflector {

	private static boolean classCacheEnabled = true;
	private static final String[] EMPTY_STRING_ARRAY = new String[0];
	private static final Map<Class<?>, Reflector> REFLECTOR_MAP = new ConcurrentHashMap<Class<?>, Reflector>();

	private Class<?> type;
	private String[] readablePropertyNames = EMPTY_STRING_ARRAY;
	private String[] writeablePropertyNames = EMPTY_STRING_ARRAY;
	private Map<String, Invoker> setMethods = new HashMap<String, Invoker>();
	private Map<String, Invoker> getMethods = new HashMap<String, Invoker>();
	private Map<String, Class<?>> setTypes = new HashMap<String, Class<?>>();
	private Map<String, Class<?>> getTypes = new HashMap<String, Class<?>>();
	private Constructor<?> defaultConstructor;

	private Map<String, String> caseInsensitivePropertyMap = new HashMap<String, String>();

	private Reflector(Class<?> clazz) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 0 8135540"); 
		type = clazz;
		addDefaultConstructor(clazz);
		addGetMethods(clazz);
		addSetMethods(clazz);
		addFields(clazz);
		readablePropertyNames = getMethods
				.keySet()
				.toArray(
						new String[getMethods
								.keySet()
								.size()]);
		writeablePropertyNames = setMethods
				.keySet()
				.toArray(
						new String[setMethods
								.keySet()
								.size()]);
		for (String propName : /* TRUE */readablePropertyNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 1 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 2 8135540"); {
			caseInsensitivePropertyMap
					.put(propName
							.toUpperCase(Locale.ENGLISH),
							propName);
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 3 8135540");
		for (String propName : /* TRUE */writeablePropertyNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 4 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 5 8135540"); {
			caseInsensitivePropertyMap
					.put(propName
							.toUpperCase(Locale.ENGLISH),
							propName);
		}}
	}

	private void addDefaultConstructor(
			Class<?> clazz) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 7 8135540"); 
		Constructor<?>[] consts = clazz
				.getDeclaredConstructors();
		for (Constructor<?> constructor : /* TRUE */consts){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 8 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 9 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 10 8135540")|| true) && (constructor
					.getParameterTypes().length == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 11 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 12 8135540")|| true) && (canAccessPrivateMethods()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 13 8135540"); {
					try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 14 8135540"); 
						constructor
								.setAccessible(true);
					} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 15 8135540"); 
						// Ignored. This is only a final precaution, nothing we
						// can do.
					}
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 17 8135540");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 18 8135540")|| true) && (constructor
						.isAccessible()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 19 8135540"); {
					this.defaultConstructor = constructor;
				} }
			} }
		}}
	}

	private void addGetMethods(
			Class<?> cls) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 23 8135540"); 
		Map<String, List<Method>> conflictingGetters = new HashMap<String, List<Method>>();
		Method[] methods = getClassMethods(cls);
		for (Method method : /* TRUE */methods){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 24 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 25 8135540"); {
			String name = method
					.getName();
			int zoa_cond_n26_0 = 2;
int zoa_cond_n26_1 = 2;
//zoa_cond_n26_0#name.startsWith("get")$zoa_cond_n26_1#name.length() > 3
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 26 8135540")|| true) && ((name.startsWith("get")?(zoa_cond_n26_0 != (zoa_cond_n26_0 = 1)):(zoa_cond_n26_0 == (zoa_cond_n26_0 = 0)))
					&& (name.length() > 3?(zoa_cond_n26_1 != (zoa_cond_n26_1 = 1)):(zoa_cond_n26_1 == (zoa_cond_n26_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 5 3 1 2 ","8135540",true,zoa_cond_n26_0,zoa_cond_n26_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 5 3 0 2 ","8135540",false,zoa_cond_n26_0,zoa_cond_n26_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 27 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 28 8135540")|| true) && (method
						.getParameterTypes().length == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 6 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 29 8135540"); {
					name = PropertyNamer
							.methodToProperty(name);
					addMethodConflict(
							conflictingGetters,
							name,
							method);
				} }
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 31 8135540");  int zoa_cond_n32_0 = 2;
int zoa_cond_n32_1 = 2;
//zoa_cond_n32_0#name.startsWith("is")$zoa_cond_n32_1#name.length() > 2
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 32 8135540")|| true) && ((name
					.startsWith("is")?(zoa_cond_n32_0 != (zoa_cond_n32_0 = 1)):(zoa_cond_n32_0 == (zoa_cond_n32_0 = 0)))
					&& (name.length() > 2?(zoa_cond_n32_1 != (zoa_cond_n32_1 = 1)):(zoa_cond_n32_1 == (zoa_cond_n32_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 9 5 1 2 ","8135540",true,zoa_cond_n32_0,zoa_cond_n32_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 9 5 0 2 ","8135540",false,zoa_cond_n32_0,zoa_cond_n32_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 33 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 34 8135540")|| true) && (method
						.getParameterTypes().length == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 10 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 10 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 35 8135540"); {
					name = PropertyNamer
							.methodToProperty(name);
					addMethodConflict(
							conflictingGetters,
							name,
							method);
				} }
			} } }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 39 8135540");
		resolveGetterConflicts(conflictingGetters);
	}

	private void resolveGetterConflicts(
			Map<String, List<Method>> conflictingGetters) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 40 8135540"); 
		for (String propName : /* TRUE */conflictingGetters
				.keySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 41 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 42 8135540"); {
			List<Method> getters = conflictingGetters
					.get(propName);
			Iterator<Method> iterator = getters
					.iterator();
			Method firstMethod = iterator
					.next();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 43 8135540")|| true) && (getters.size() == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 11 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 11 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 44 8135540"); {
				addGetMethod(propName,
						firstMethod);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 45 8135540");  {
				Method getter = firstMethod;
				Class<?> getterType = firstMethod
						.getReturnType();
				while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 46 8135540")|| true) && (iterator
						.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 12 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 12 8 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 47 8135540");  {
					Method method = iterator
							.next();
					Class<?> methodType = method
							.getReturnType();
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 48 8135540")|| true) && (methodType
							.equals(getterType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 13 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 13 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 49 8135540"); {
						throw new ReflectionException(
								"Illegal overloaded getter method with ambiguous type for property "
										+ propName
										+ " in class "
										+ firstMethod
												.getDeclaringClass()
										+ ".  This breaks the JavaBeans "
										+ "specification and can cause unpredicatble results.");
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 50 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 51 8135540")|| true) && (methodType
							.isAssignableFrom(getterType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 14 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 14 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 52 8135540"); {
						// OK getter type is descendant
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 53 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 54 8135540")|| true) && (getterType
							.isAssignableFrom(methodType)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 15 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 15 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 55 8135540"); {
						getter = method;
						getterType = methodType;
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 56 8135540");  {
						throw new ReflectionException(
								"Illegal overloaded getter method with ambiguous type for property "
										+ propName
										+ " in class "
										+ firstMethod
												.getDeclaringClass()
										+ ".  This breaks the JavaBeans "
										+ "specification and can cause unpredicatble results.");
					} } } }
				}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 60 8135540"); 
				addGetMethod(propName,
						getter);
			} }
		}}
	}

	private void addGetMethod(
			String name, Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 63 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 64 8135540")|| true) && (isValidPropertyName(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 16 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 16 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 65 8135540"); {
			getMethods.put(name,
					new MethodInvoker(
							method));
			getTypes.put(name, method
					.getReturnType());
		} }
	}

	private void addSetMethods(
			Class<?> cls) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 67 8135540"); 
		Map<String, List<Method>> conflictingSetters = new HashMap<String, List<Method>>();
		Method[] methods = getClassMethods(cls);
		for (Method method : /* TRUE */methods){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 68 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 69 8135540"); {
			String name = method
					.getName();
			int zoa_cond_n70_0 = 2;
int zoa_cond_n70_1 = 2;
//zoa_cond_n70_0#name.startsWith("set")$zoa_cond_n70_1#name.length() > 3
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 70 8135540")|| true) && ((name.startsWith("set")?(zoa_cond_n70_0 != (zoa_cond_n70_0 = 1)):(zoa_cond_n70_0 == (zoa_cond_n70_0 = 0)))
					&& (name.length() > 3?(zoa_cond_n70_1 != (zoa_cond_n70_1 = 1)):(zoa_cond_n70_1 == (zoa_cond_n70_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 19 13 1 2 ","8135540",true,zoa_cond_n70_0,zoa_cond_n70_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 19 13 0 2 ","8135540",false,zoa_cond_n70_0,zoa_cond_n70_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 71 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 72 8135540")|| true) && (method
						.getParameterTypes().length == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 20 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 20 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 73 8135540"); {
					name = PropertyNamer
							.methodToProperty(name);
					addMethodConflict(
							conflictingSetters,
							name,
							method);
				} }
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 76 8135540");
		resolveSetterConflicts(conflictingSetters);
	}

	private void addMethodConflict(
			Map<String, List<Method>> conflictingMethods,
			String name, Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 77 8135540"); 
		List<Method> list = conflictingMethods
				.get(name);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 78 8135540")|| true) && (list == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 21 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 21 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 79 8135540"); {
			list = new ArrayList<Method>();
			conflictingMethods.put(
					name, list);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 80 8135540");
		list.add(method);
	}

	private void resolveSetterConflicts(
			Map<String, List<Method>> conflictingSetters) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 81 8135540"); 
		for (String propName : /* TRUE */conflictingSetters
				.keySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 82 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 83 8135540"); {
			List<Method> setters = conflictingSetters
					.get(propName);
			Method firstMethod = setters
					.get(0);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 84 8135540")|| true) && (setters.size() == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 22 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 22 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 85 8135540"); {
				addSetMethod(propName,
						firstMethod);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 86 8135540");  {
				Class<?> expectedType = getTypes
						.get(propName);
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 87 8135540")|| true) && (expectedType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 23 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 23 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 88 8135540"); {
					throw new ReflectionException(
							"Illegal overloaded setter method with ambiguous type for property "
									+ propName
									+ " in class "
									+ firstMethod
											.getDeclaringClass()
									+ ".  This breaks the JavaBeans "
									+ "specification and can cause unpredicatble results.");
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 89 8135540");  {
					Iterator<Method> methods = setters
							.iterator();
					Method setter = null;
					while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 90 8135540")|| true) && (methods
							.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 24 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 24 18 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 91 8135540");  {
						Method method = methods
								.next();
						int zoa_cond_n92_0 = 2;
int zoa_cond_n92_1 = 2;
//zoa_cond_n92_0#method.getParameterTypes().length == 1$zoa_cond_n92_1#expectedType.equals(method.getParameterTypes()[0])
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 92 8135540")|| true) && ((method
								.getParameterTypes().length == 1?(zoa_cond_n92_0 != (zoa_cond_n92_0 = 1)):(zoa_cond_n92_0 == (zoa_cond_n92_0 = 0)))
								&& (expectedType
										.equals(method
												.getParameterTypes()[0])?(zoa_cond_n92_1 != (zoa_cond_n92_1 = 1)):(zoa_cond_n92_1 == (zoa_cond_n92_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 27 19 1 2 ","8135540",true,zoa_cond_n92_0,zoa_cond_n92_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 27 19 0 2 ","8135540",false,zoa_cond_n92_0,zoa_cond_n92_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 93 8135540"); {
							setter = method;
							 break;
						} }
					}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 95 8135540"); 
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 96 8135540")|| true) && (setter == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 28 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 28 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 97 8135540"); {
						throw new ReflectionException(
								"Illegal overloaded setter method with ambiguous type for property "
										+ propName
										+ " in class "
										+ firstMethod
												.getDeclaringClass()
										+ ".  This breaks the JavaBeans "
										+ "specification and can cause unpredicatble results.");
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 98 8135540");
					addSetMethod(
							propName,
							setter);
				} }
			} }
		}}
	}

	private void addSetMethod(
			String name, Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 102 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 103 8135540")|| true) && (isValidPropertyName(name)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 29 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 29 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 104 8135540"); {
			setMethods.put(name,
					new MethodInvoker(
							method));
			setTypes.put(
					name,
					method.getParameterTypes()[0]);
		} }
	}

	private void addFields(
			Class<?> clazz) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 106 8135540"); 
		Field[] fields = clazz
				.getDeclaredFields();
		for (Field field : /* TRUE */fields){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 107 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 108 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 109 8135540")|| true) && (canAccessPrivateMethods()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 30 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 30 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 110 8135540"); {
				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 111 8135540"); 
					field.setAccessible(true);
				} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 112 8135540"); 
					// Ignored. This is only a final precaution, nothing we can
					// do.
				}
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 114 8135540");
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 115 8135540")|| true) && (field.isAccessible()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 31 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 31 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 116 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 117 8135540")|| true) && (!setMethods
						.containsKey(field
								.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 32 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 32 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 118 8135540"); {
					// issue #379 - removed the check for final because JDK 1.5
					// allows
					// modification of final fields through reflection
					// (JSR-133). (JGB)
					// pr #16 - final static can only be set by the classloader
					int modifiers = field
							.getModifiers();
					int zoa_cond_n119_0 = 2;
int zoa_cond_n119_1 = 2;
//zoa_cond_n119_0#Modifier.isFinal(modifiers)$zoa_cond_n119_1#Modifier.isStatic(modifiers)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 119 8135540")|| true) && (!((Modifier
							.isFinal(modifiers)?(zoa_cond_n119_0 != (zoa_cond_n119_0 = 1)):(zoa_cond_n119_0 == (zoa_cond_n119_0 = 0))) && (Modifier
							.isStatic(modifiers)?(zoa_cond_n119_1 != (zoa_cond_n119_1 = 1)):(zoa_cond_n119_1 == (zoa_cond_n119_1 = 0))))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 35 25 1 2 ","8135540",true,zoa_cond_n119_0,zoa_cond_n119_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 35 25 0 2 ","8135540",false,zoa_cond_n119_0,zoa_cond_n119_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 120 8135540"); {
						addSetField(field);
					} }
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 122 8135540");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 123 8135540")|| true) && (!getMethods
						.containsKey(field
								.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 36 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 36 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 124 8135540"); {
					addGetField(field);
				} }
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 127 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 128 8135540")|| true) && (clazz.getSuperclass() != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 37 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 37 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 129 8135540"); {
			addFields(clazz
					.getSuperclass());
		} }
	}

	private void addSetField(Field field) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 131 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 132 8135540")|| true) && (isValidPropertyName(field
				.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 38 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 38 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 133 8135540"); {
			setMethods
					.put(field
							.getName(),
							new SetFieldInvoker(
									field));
			setTypes.put(
					field.getName(),
					field.getType());
		} }
	}

	private void addGetField(Field field) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 135 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 136 8135540")|| true) && (isValidPropertyName(field
				.getName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 39 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 39 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 137 8135540"); {
			getMethods
					.put(field
							.getName(),
							new GetFieldInvoker(
									field));
			getTypes.put(
					field.getName(),
					field.getType());
		} }
	}

	private boolean isValidPropertyName(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 139 8135540"); 
		return !(name.startsWith("$")
				|| "serialVersionUID"
						.equals(name) || "class"
					.equals(name));
	}

	/*
	 * This method returns an array containing all methods declared in this
	 * class and any superclass. We use this method, instead of the simpler
	 * Class.getMethods(), because we want to look for private methods as well.
	 * 
	 * @param cls The class
	 * 
	 * @return An array containing all methods in this class
	 */
	private Method[] getClassMethods(
			Class<?> cls) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 140 8135540"); 
		HashMap<String, Method> uniqueMethods = new HashMap<String, Method>();
		Class<?> currentClass = cls;
		while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 141 8135540")|| true) && (currentClass != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 40 30 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 40 30 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 142 8135540");  {
			addUniqueMethods(
					uniqueMethods,
					currentClass
							.getDeclaredMethods());

			// we also need to look for interface methods -
			// because the class may be abstract
			Class<?>[] interfaces = currentClass
					.getInterfaces();
			for (Class<?> anInterface : /* TRUE */interfaces){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 143 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 144 8135540"); {
				addUniqueMethods(
						uniqueMethods,
						anInterface
								.getMethods());
			}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 145 8135540");

			currentClass = currentClass
					.getSuperclass();
		}}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 146 8135540"); 

		Collection<Method> methods = uniqueMethods
				.values();

		return methods
				.toArray(new Method[methods
						.size()]);
	}

	private void addUniqueMethods(
			HashMap<String, Method> uniqueMethods,
			Method[] methods) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 147 8135540"); 
		for (Method currentMethod : /* TRUE */methods){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 148 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 149 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 150 8135540")|| true) && (!currentMethod
					.isBridge()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 41 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 41 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 151 8135540"); {
				String signature = getSignature(currentMethod);
				// check to see if the method is already known
				// if it is known, then an extended class must have
				// overridden a method
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 152 8135540")|| true) && (!uniqueMethods
						.containsKey(signature)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 42 32 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 42 32 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 153 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 154 8135540")|| true) && (canAccessPrivateMethods()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 43 33 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 43 33 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 155 8135540"); {
						try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 156 8135540"); 
							currentMethod
									.setAccessible(true);
						} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 157 8135540"); 
							// Ignored. This is only a final precaution, nothing
							// we can do.
						}
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 159 8135540");

					uniqueMethods
							.put(signature,
									currentMethod);
				} }
			} }
		}}
	}

	private String getSignature(
			Method method) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 163 8135540"); 
		StringBuilder sb = new StringBuilder();
		Class<?> returnType = method
				.getReturnType();
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 164 8135540")|| true) && (returnType != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 44 34 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 44 34 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 165 8135540"); {
			sb.append(
					returnType
							.getName())
					.append('#');
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 166 8135540");
		sb.append(method.getName());
		Class<?>[] parameters = method
				.getParameterTypes();
		for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 167 8135540")|| true) && (i < parameters.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 45 35 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 45 35 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 168 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 169 8135540")|| true) && (i == 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 46 36 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 46 36 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 170 8135540"); {
				sb.append(':');
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 171 8135540");  {
				sb.append(',');
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 172 8135540");
			sb.append(parameters[i]
					.getName());
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 173 8135540");
		return sb.toString();
	}

	private static boolean canAccessPrivateMethods() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 174 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 175 8135540"); 
			SecurityManager securityManager = System
					.getSecurityManager();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 176 8135540")|| true) && (null != securityManager? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 47 37 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 47 37 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 177 8135540"); {
				securityManager
						.checkPermission(new ReflectPermission(
								"suppressAccessChecks"));
			} }
		} catch (SecurityException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 179 8135540"); 
			return false;
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 180 8135540");
		return true;
	}

	/*
	 * Gets the name of the class the instance provides information for
	 * 
	 * @return The class name
	 */
	public Class<?> getType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 181 8135540"); 
		return type;
	}

	public Constructor<?> getDefaultConstructor() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 182 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 183 8135540")|| true) && (defaultConstructor != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 48 38 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 48 38 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 184 8135540"); {
			return defaultConstructor;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 185 8135540");  {
			throw new ReflectionException(
					"There is no default constructor for "
							+ type);
		} }
	}

	public Invoker getSetInvoker(
			String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 187 8135540"); 
		Invoker method = setMethods
				.get(propertyName);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 188 8135540")|| true) && (method == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 49 39 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 49 39 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 189 8135540"); {
			throw new ReflectionException(
					"There is no setter for property named '"
							+ propertyName
							+ "' in '"
							+ type
							+ "'");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 190 8135540");
		return method;
	}

	public Invoker getGetInvoker(
			String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 191 8135540"); 
		Invoker method = getMethods
				.get(propertyName);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 192 8135540")|| true) && (method == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 50 40 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 50 40 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 193 8135540"); {
			throw new ReflectionException(
					"There is no getter for property named '"
							+ propertyName
							+ "' in '"
							+ type
							+ "'");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 194 8135540");
		return method;
	}

	/*
	 * Gets the type for a property setter
	 * 
	 * @param propertyName - the name of the property
	 * 
	 * @return The Class of the propery setter
	 */
	public Class<?> getSetterType(
			String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 195 8135540"); 
		Class<?> clazz = setTypes
				.get(propertyName);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 196 8135540")|| true) && (clazz == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 51 41 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 51 41 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 197 8135540"); {
			throw new ReflectionException(
					"There is no setter for property named '"
							+ propertyName
							+ "' in '"
							+ type
							+ "'");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 198 8135540");
		return clazz;
	}

	/*
	 * Gets the type for a property getter
	 * 
	 * @param propertyName - the name of the property
	 * 
	 * @return The Class of the propery getter
	 */
	public Class<?> getGetterType(
			String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 199 8135540"); 
		Class<?> clazz = getTypes
				.get(propertyName);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 200 8135540")|| true) && (clazz == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 52 42 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 52 42 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 201 8135540"); {
			throw new ReflectionException(
					"There is no getter for property named '"
							+ propertyName
							+ "' in '"
							+ type
							+ "'");
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 202 8135540");
		return clazz;
	}

	/*
	 * Gets an array of the readable properties for an object
	 * 
	 * @return The array
	 */
	public String[] getGetablePropertyNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 203 8135540"); 
		return readablePropertyNames;
	}

	/*
	 * Gets an array of the writeable properties for an object
	 * 
	 * @return The array
	 */
	public String[] getSetablePropertyNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 204 8135540"); 
		return writeablePropertyNames;
	}

	/*
	 * Check to see if a class has a writeable property by name
	 * 
	 * @param propertyName - the name of the property to check
	 * 
	 * @return True if the object has a writeable property by the name
	 */
	public boolean hasSetter(
			String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 205 8135540"); 
		return setMethods.keySet()
				.contains(propertyName);
	}

	/*
	 * Check to see if a class has a readable property by name
	 * 
	 * @param propertyName - the name of the property to check
	 * 
	 * @return True if the object has a readable property by the name
	 */
	public boolean hasGetter(
			String propertyName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 206 8135540"); 
		return getMethods.keySet()
				.contains(propertyName);
	}

	public String findPropertyName(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 207 8135540"); 
		return caseInsensitivePropertyMap
				.get(name
						.toUpperCase(Locale.ENGLISH));
	}

	/*
	 * Gets an instance of ClassInfo for the specified class.
	 * 
	 * @param clazz The class for which to lookup the method cache.
	 * 
	 * @return The method cache for the class
	 */
	public static Reflector forClass(
			Class<?> clazz) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 208 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 209 8135540")|| true) && (classCacheEnabled? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 53 43 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 53 43 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 210 8135540"); {
			// synchronized (clazz) removed see issue #461
			Reflector cached = REFLECTOR_MAP
					.get(clazz);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 211 8135540")|| true) && (cached == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 54 44 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 302 54 44 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 212 8135540"); {
				cached = new Reflector(
						clazz);
				REFLECTOR_MAP.put(
						clazz, cached);
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 213 8135540");
			return cached;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 302 214 8135540");  {
			return new Reflector(clazz);
		} }
	}

	public static void setClassCacheEnabled(
			boolean classCacheEnabled) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 216 8135540"); 
		Reflector.classCacheEnabled = classCacheEnabled;
	}

	public static boolean isClassCacheEnabled() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 302 217 8135540"); 
		return classCacheEnabled;
	}
}
