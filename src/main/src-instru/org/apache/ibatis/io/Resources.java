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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * A class to simplify access to resources through the classloader.
 *sss 
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class Resources {

	private static ClassLoaderWrapper classLoaderWrapper = new ClassLoaderWrapper();

	/*
	 * Charset to use when calling getResourceAsReader. null means use the
	 * system default.
	 */
	private static Charset charset;

	Resources() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 0 8135540"); 
	}

	/*
	 * Returns the default classloader (may be null).
	 * 
	 * @return The default classloader
	 */
	public static ClassLoader getDefaultClassLoader() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 1 8135540"); 
		return classLoaderWrapper.defaultClassLoader;
	}

	/*
	 * Sets the default classloader
	 * 
	 * @param defaultClassLoader - the new default ClassLoader
	 */
	public static void setDefaultClassLoader(
			ClassLoader defaultClassLoader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 2 8135540"); 
		classLoaderWrapper.defaultClassLoader = defaultClassLoader;
	}

	/*
	 * Returns the URL of the resource on the classpath
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static URL getResourceURL(
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 3 8135540"); 
		return getResourceURL(null,
				resource); // issue #625
	}

	/*
	 * Returns the URL of the resource on the classpath
	 * 
	 * @param loader The classloader used to fetch the resource
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static URL getResourceURL(
			ClassLoader loader,
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 4 8135540"); 
		URL url = classLoaderWrapper
				.getResourceAsURL(
						resource,
						loader);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 5 8135540")|| true) && (url == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 6 8135540");
			throw new IOException(
					"Could not find resource "
							+ resource); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 7 8135540");
		return url;
	}

	/*
	 * Returns a resource on the classpath as a Stream object
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static InputStream getResourceAsStream(
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 8 8135540"); 
		return getResourceAsStream(
				null, resource);
	}

	/*
	 * Returns a resource on the classpath as a Stream object
	 * 
	 * @param loader The classloader used to fetch the resource
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static InputStream getResourceAsStream(
			ClassLoader loader,
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 9 8135540"); 
		InputStream in = classLoaderWrapper
				.getResourceAsStream(
						resource,
						loader);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 10 8135540")|| true) && (in == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 11 8135540");
			throw new IOException(
					"Could not find resource "
							+ resource); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 12 8135540");
		return in;
	}

	/*
	 * Returns a resource on the classpath as a Properties object
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static Properties getResourceAsProperties(
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 13 8135540"); 
		Properties props = new Properties();
		InputStream in = getResourceAsStream(resource);
		props.load(in);
		in.close();
		return props;
	}

	/*
	 * Returns a resource on the classpath as a Properties object
	 * 
	 * @param loader The classloader used to fetch the resource
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static Properties getResourceAsProperties(
			ClassLoader loader,
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 14 8135540"); 
		Properties props = new Properties();
		InputStream in = getResourceAsStream(
				loader, resource);
		props.load(in);
		in.close();
		return props;
	}

	/*
	 * Returns a resource on the classpath as a Reader object
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static Reader getResourceAsReader(
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 15 8135540"); 
		Reader reader;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 16 8135540")|| true) && (charset == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 17 8135540"); {
			reader = new InputStreamReader(
					getResourceAsStream(resource));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 18 8135540");  {
			reader = new InputStreamReader(
					getResourceAsStream(resource),
					charset);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 19 8135540");
		return reader;
	}

	/*
	 * Returns a resource on the classpath as a Reader object
	 * 
	 * @param loader The classloader used to fetch the resource
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static Reader getResourceAsReader(
			ClassLoader loader,
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 20 8135540"); 
		Reader reader;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 21 8135540")|| true) && (charset == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 22 8135540"); {
			reader = new InputStreamReader(
					getResourceAsStream(
							loader,
							resource));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 23 8135540");  {
			reader = new InputStreamReader(
					getResourceAsStream(
							loader,
							resource),
					charset);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 24 8135540");
		return reader;
	}

	/*
	 * Returns a resource on the classpath as a File object
	 * 
	 * @param resource The resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static File getResourceAsFile(
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 25 8135540"); 
		return new File(getResourceURL(
				resource).getFile());
	}

	/*
	 * Returns a resource on the classpath as a File object
	 * 
	 * @param loader - the classloader used to fetch the resource
	 * 
	 * @param resource - the resource to find
	 * 
	 * @return The resource
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static File getResourceAsFile(
			ClassLoader loader,
			String resource)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 26 8135540"); 
		return new File(getResourceURL(
				loader, resource)
				.getFile());
	}

	/*
	 * Gets a URL as an input stream
	 * 
	 * @param urlString - the URL to get
	 * 
	 * @return An input stream with the data from the URL
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static InputStream getUrlAsStream(
			String urlString)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 27 8135540"); 
		URL url = new URL(urlString);
		URLConnection conn = url
				.openConnection();
		return conn.getInputStream();
	}

	/*
	 * Gets a URL as a Reader
	 * 
	 * @param urlString - the URL to get
	 * 
	 * @return A Reader with the data from the URL
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static Reader getUrlAsReader(
			String urlString)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 28 8135540"); 
		Reader reader;
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 29 8135540")|| true) && (charset == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 306 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 30 8135540"); {
			reader = new InputStreamReader(
					getUrlAsStream(urlString));
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 31 8135540");  {
			reader = new InputStreamReader(
					getUrlAsStream(urlString),
					charset);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 306 32 8135540");
		return reader;
	}

	/*
	 * Gets a URL as a Properties object
	 * 
	 * @param urlString - the URL to get
	 * 
	 * @return A Properties object with the data from the URL
	 * 
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static Properties getUrlAsProperties(
			String urlString)
			throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 33 8135540"); 
		Properties props = new Properties();
		InputStream in = getUrlAsStream(urlString);
		props.load(in);
		in.close();
		return props;
	}

	/*
	 * Loads a class
	 * 
	 * @param className - the class to fetch
	 * 
	 * @return The loaded class
	 * 
	 * @throws ClassNotFoundException If the class cannot be found (duh!)
	 */
	public static Class<?> classForName(
			String className)
			throws ClassNotFoundException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 34 8135540"); 
		return classLoaderWrapper
				.classForName(className);
	}

	public static Charset getCharset() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 35 8135540"); 
		return charset;
	}

	public static void setCharset(
			Charset charset) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 306 36 8135540"); 
		Resources.charset = charset;
	}

}
