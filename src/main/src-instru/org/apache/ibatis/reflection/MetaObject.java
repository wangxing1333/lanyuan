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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;
import org.apache.ibatis.reflection.wrapper.CollectionWrapper;
import org.apache.ibatis.reflection.wrapper.MapWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class MetaObject {

	private Object originalObject;
	private ObjectWrapper objectWrapper;
	private ObjectFactory objectFactory;
	private ObjectWrapperFactory objectWrapperFactory;

	private MetaObject(
			Object object,
			ObjectFactory objectFactory,
			ObjectWrapperFactory objectWrapperFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 0 8135540"); 
		this.originalObject = object;
		this.objectFactory = objectFactory;
		this.objectWrapperFactory = objectWrapperFactory;

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 1 8135540")|| true) && (object instanceof ObjectWrapper? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 2 8135540"); {
			this.objectWrapper = (ObjectWrapper) object;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 3 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 4 8135540")|| true) && (objectWrapperFactory
				.hasWrapperFor(object)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 5 8135540"); {
			this.objectWrapper = objectWrapperFactory
					.getWrapperFor(
							this,
							object);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 6 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 7 8135540")|| true) && (object instanceof Map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 8 8135540"); {
			this.objectWrapper = new MapWrapper(
					this, (Map) object);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 9 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 10 8135540")|| true) && (object instanceof Collection? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 11 8135540"); {
			this.objectWrapper = new CollectionWrapper(
					this,
					(Collection) object);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 12 8135540");  {
			this.objectWrapper = new BeanWrapper(
					this, object);
		} } } } }
	}

	public static MetaObject forObject(
			Object object,
			ObjectFactory objectFactory,
			ObjectWrapperFactory objectWrapperFactory) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 17 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 18 8135540")|| true) && (object == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 19 8135540"); {
			return SystemMetaObject.NULL_META_OBJECT;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 20 8135540");  {
			return new MetaObject(
					object,
					objectFactory,
					objectWrapperFactory);
		} }
	}

	public ObjectFactory getObjectFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 22 8135540"); 
		return objectFactory;
	}

	public ObjectWrapperFactory getObjectWrapperFactory() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 23 8135540"); 
		return objectWrapperFactory;
	}

	public Object getOriginalObject() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 24 8135540"); 
		return originalObject;
	}

	public String findProperty(
			String propName,
			boolean useCamelCaseMapping) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 25 8135540"); 
		return objectWrapper
				.findProperty(propName,
						useCamelCaseMapping);
	}

	public String[] getGetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 26 8135540"); 
		return objectWrapper
				.getGetterNames();
	}

	public String[] getSetterNames() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 27 8135540"); 
		return objectWrapper
				.getSetterNames();
	}

	public Class<?> getSetterType(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 28 8135540"); 
		return objectWrapper
				.getSetterType(name);
	}

	public Class<?> getGetterType(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 29 8135540"); 
		return objectWrapper
				.getGetterType(name);
	}

	public boolean hasSetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 30 8135540"); 
		return objectWrapper
				.hasSetter(name);
	}

	public boolean hasGetter(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 31 8135540"); 
		return objectWrapper
				.hasGetter(name);
	}

	public Object getValue(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 32 8135540"); 
		PropertyTokenizer prop = new PropertyTokenizer(
				name);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 33 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 34 8135540"); {
			MetaObject metaValue = metaObjectForProperty(prop
					.getIndexedName());
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 35 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 36 8135540"); {
				return null;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 37 8135540");  {
				return metaValue
						.getValue(prop
								.getChildren());
			} }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 39 8135540");  {
			return objectWrapper
					.get(prop);
		} }
	}

	public void setValue(String name,
			Object value) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 41 8135540"); 
		PropertyTokenizer prop = new PropertyTokenizer(
				name);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 42 8135540")|| true) && (prop.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 43 8135540"); {
			MetaObject metaValue = metaObjectForProperty(prop
					.getIndexedName());
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 44 8135540")|| true) && (metaValue == SystemMetaObject.NULL_META_OBJECT? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 45 8135540"); {
				int zoa_cond_n46_0 = 2;
int zoa_cond_n46_1 = 2;
//zoa_cond_n46_0#value == null$zoa_cond_n46_1#prop.getChildren() != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 46 8135540")|| true) && ((value == null?(zoa_cond_n46_0 != (zoa_cond_n46_0 = 1)):(zoa_cond_n46_0 == (zoa_cond_n46_0 = 0)))
						&& (prop.getChildren() != null?(zoa_cond_n46_1 != (zoa_cond_n46_1 = 1)):(zoa_cond_n46_1 == (zoa_cond_n46_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 11 9 1 2 ","8135540",true,zoa_cond_n46_0,zoa_cond_n46_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 236 11 9 0 2 ","8135540",false,zoa_cond_n46_0,zoa_cond_n46_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 47 8135540"); {
					return; // don't instantiate child path if value is null
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 48 8135540");  {
					metaValue = objectWrapper
							.instantiatePropertyValue(
									name,
									prop,
									objectFactory);
				} }
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 50 8135540");
			metaValue.setValue(
					prop.getChildren(),
					value);
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 236 51 8135540");  {
			objectWrapper.set(prop,
					value);
		} }
	}

	public MetaObject metaObjectForProperty(
			String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 53 8135540"); 
		Object value = getValue(name);
		return MetaObject.forObject(
				value, objectFactory,
				objectWrapperFactory);
	}

	public ObjectWrapper getObjectWrapper() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 54 8135540"); 
		return objectWrapper;
	}

	public boolean isCollection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 55 8135540"); 
		return objectWrapper
				.isCollection();
	}

	public void add(Object element) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 56 8135540"); 
		objectWrapper.add(element);
	}

	public <E> void addAll(List<E> list) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 236 57 8135540"); 
		objectWrapper.addAll(list);
	}

}
