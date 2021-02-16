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
package org.apache.ibatis.io;

import java.io.InputStream;
import java.net.URL;

/**
 * A class to wrap access to multiple class loaders making them work as one
 * 
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ClassLoaderWrapper {

	ClassLoader defaultClassLoader;
	ClassLoader systemClassLoader;

	ClassLoaderWrapper() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 0 8135540"); 
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 1 8135540"); 
			systemClassLoader = ClassLoader
					.getSystemClassLoader();
		} catch (SecurityException ignored) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 2 8135540"); 
			// AccessControlException on Google App Engine
		}
	}

	/*
	 * Get a resource as a URL using the current class path
	 * 
	 * @param resource - the resource to locate
	 * 
	 * @return the resource or null
	 */
	public URL getResourceAsURL(
			String resource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 4 8135540"); 
		return getResourceAsURL(
				resource,
				getClassLoaders(null));
	}

	/*
	 * Get a resource from the classpath, starting with a specific class loader
	 * 
	 * @param resource - the resource to find
	 * 
	 * @param classLoader - the first classloader to try
	 * 
	 * @return the stream or null
	 */
	public URL getResourceAsURL(
			String resource,
			ClassLoader classLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 5 8135540"); 
		return getResourceAsURL(
				resource,
				getClassLoaders(classLoader));
	}

	/*
	 * Get a resource from the classpath
	 * 
	 * @param resource - the resource to find
	 * 
	 * @return the stream or null
	 */
	public InputStream getResourceAsStream(
			String resource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 6 8135540"); 
		return getResourceAsStream(
				resource,
				getClassLoaders(null));
	}

	/*
	 * Get a resource from the classpath, starting with a specific class loader
	 * 
	 * @param resource - the resource to find
	 * 
	 * @param classLoader - the first class loader to try
	 * 
	 * @return the stream or null
	 */
	public InputStream getResourceAsStream(
			String resource,
			ClassLoader classLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 7 8135540"); 
		return getResourceAsStream(
				resource,
				getClassLoaders(classLoader));
	}

	/*
	 * Find a class on the classpath (or die trying)
	 * 
	 * @param name - the class to look for
	 * 
	 * @return - the class
	 * 
	 * @throws ClassNotFoundException Duh.
	 */
	public Class<?> classForName(
			String name)
			throws ClassNotFoundException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 8 8135540"); 
		return classForName(name,
				getClassLoaders(null));
	}

	/*
	 * Find a class on the classpath, starting with a specific classloader (or
	 * die trying)
	 * 
	 * @param name - the class to look for
	 * 
	 * @param classLoader - the first classloader to try
	 * 
	 * @return - the class
	 * 
	 * @throws ClassNotFoundException Duh.
	 */
	public Class<?> classForName(
			String name,
			ClassLoader classLoader)
			throws ClassNotFoundException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 9 8135540"); 
		return classForName(
				name,
				getClassLoaders(classLoader));
	}

	/*
	 * Try to get a resource from a group of classloaders
	 * 
	 * @param resource - the resource to get
	 * 
	 * @param classLoader - the classloaders to examine
	 * 
	 * @return the resource or null
	 */
	InputStream getResourceAsStream(
			String resource,
			ClassLoader[] classLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 10 8135540"); 
		for (ClassLoader cl : /* TRUE */classLoader){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 11 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 12 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 13 8135540")|| true) && (null != cl? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 14 8135540"); {

				// try to find the resource as passed
				InputStream returnValue = cl
						.getResourceAsStream(resource);

				// now, some class loaders want this leading "/", so we'll add
				// it and try again if we didn't find the resource
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 15 8135540")|| true) && (null == returnValue? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 16 8135540");
					returnValue = cl
							.getResourceAsStream("/"
									+ resource); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 17 8135540");

				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 18 8135540")|| true) && (null != returnValue? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 19 8135540");
					return returnValue; }
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 22 8135540");
		return null;
	}

	/*
	 * Get a resource as a URL using the current class path
	 * 
	 * @param resource - the resource to locate
	 * 
	 * @param classLoader - the class loaders to examine
	 * 
	 * @return the resource or null
	 */
	URL getResourceAsURL(
			String resource,
			ClassLoader[] classLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 23 8135540"); 

		URL url;

		for (ClassLoader cl : /* TRUE */classLoader){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 24 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 25 8135540"); {

			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 26 8135540")|| true) && (null != cl? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 27 8135540"); {

				// look for the resource as passed in...
				url = cl.getResource(resource);

				// ...but some class loaders want this leading "/", so we'll add
				// it
				// and try again if we didn't find the resource
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 28 8135540")|| true) && (null == url? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 29 8135540");
					url = cl.getResource("/"
							+ resource); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 30 8135540");

				// "It's always in the last place I look for it!"
				// ... because only an idiot would keep looking for it after
				// finding it, so stop looking already.
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 31 8135540")|| true) && (null != url? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 32 8135540");
					return url; }

			} }

		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 35 8135540");

		// didn't find it anywhere.
		return null;

	}

	/*
	 * Attempt to load a class from a group of classloaders
	 * 
	 * @param name - the class to load
	 * 
	 * @param classLoader - the group of classloaders to examine
	 * 
	 * @return the class
	 * 
	 * @throws ClassNotFoundException - Remember the wisdom of Judge Smails:
	 * Well, the world needs ditch diggers, too.
	 */
	Class<?> classForName(String name,
			ClassLoader[] classLoader)
			throws ClassNotFoundException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 36 8135540"); 

		for (ClassLoader cl : /* TRUE */classLoader){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 37 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 38 8135540"); {

			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 39 8135540")|| true) && (null != cl? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 40 8135540"); {

				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 41 8135540"); 

					Class<?> c = Class
							.forName(
									name,
									true,
									cl);

					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 42 8135540")|| true) && (null != c? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 210 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 43 8135540");
						return c; }

				} catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 45 8135540"); 
					// we'll ignore this until all classloaders fail to locate
					// the class
				}

			} }

		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 210 48 8135540");

		throw new ClassNotFoundException(
				"Cannot find class: "
						+ name);

	}

	ClassLoader[] getClassLoaders(
			ClassLoader classLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 210 49 8135540"); 
		return new ClassLoader[] {
				classLoader,
				defaultClassLoader,
				Thread.currentThread()
						.getContextClassLoader(),
				getClass()
						.getClassLoader(),
				systemClassLoader };
	}

}
