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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * A default implementation of {@link VFS} that works for most application servers.
 * 
 * @author Ben Gunter
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DefaultVFS extends VFS {
  private static final Log log = LogFactory.getLog(ResolverUtil.class);

  /** The magic header that indicates a JAR (ZIP) file. */
  private static final byte[] JAR_MAGIC = { 'P', 'K', 3, 4 };

  @Override
  public boolean isValid() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 0 8135540"); 
    return true;
  }

  @Override
  public List<String> list(URL url, String path) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 1 8135540"); 
    InputStream is = null;
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 2 8135540"); 
      List<String> resources = new ArrayList<String>();

      // First, try to find the URL of a JAR file containing the requested resource. If a JAR
      // file is found, then we'll list child resources by reading the JAR.
      URL jarUrl = findJarForResource(url);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 3 8135540")|| true) && (jarUrl != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 4 8135540"); {
        is = jarUrl.openStream();
        log.debug("Listing " + url);
        resources = listResources(new JarInputStream(is), path);
      } }
      else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 5 8135540");  {
        List<String> children = new ArrayList<String>();
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 6 8135540"); 
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 7 8135540")|| true) && (isJar(url)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 8 8135540"); {
            // Some versions of JBoss VFS might give a JAR stream even if the resource
            // referenced by the URL isn't actually a JAR
            is = url.openStream();
            JarInputStream jarInput = new JarInputStream(is);
            log.debug("Listing " + url);
            for (JarEntry entry; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 9 8135540")|| true) && ((entry = jarInput.getNextJarEntry()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 2 2 0 0 ","8135540",false,0) && false));){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 10 8135540"); {
              log.debug("Jar entry: " + entry.getName());
              children.add(entry.getName());
            }}
          } }
          else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 12 8135540");  {
            /*
             * Some servlet containers allow reading from directory resources like a
             * text file, listing the child resources one per line. However, there is no
             * way to differentiate between directory and file resources just by reading
             * them. To work around that, as each line is read, try to look it up via
             * the class loader as a child of the current resource. If any line fails
             * then we assume the current resource is not a directory.
             */
            is = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            List<String> lines = new ArrayList<String>();
            for (String line; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 13 8135540")|| true) && ((line = reader.readLine()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 3 3 0 0 ","8135540",false,0) && false));){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 14 8135540"); {
              log.debug("Reader entry: " + line);
              lines.add(line);
              if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 15 8135540")|| true) && (getResources(path + "/" + line).isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 16 8135540"); {
                lines.clear();
                 break;
              } }
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 18 8135540");

            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 19 8135540")|| true) && (!lines.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 20 8135540"); {
              log.debug("Listing " + url);
              children.addAll(lines);
            } }
          } }
        } catch (FileNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 23 8135540"); 
          /*
           * For file URLs the openStream() call might fail, depending on the servlet
           * container, because directories can't be opened for reading. If that happens,
           * then list the directory directly instead.
           */
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 24 8135540")|| true) && ("file".equals(url.getProtocol())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 25 8135540"); {
            File file = new File(url.getFile());
            log.debug("Listing directory " + file.getAbsolutePath());
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 26 8135540")|| true) && (file.isDirectory()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 27 8135540"); {
              log.debug("Listing " + url);
              children = Arrays.asList(file.list());
            } }
          } }
          else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 29 8135540");  {
            // No idea where the exception came from so rethrow it
            throw e;
          } }
        }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 31 8135540");

        // The URL prefix to use when recursively listing child resources
        String prefix = url.toExternalForm();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 32 8135540")|| true) && (!prefix.endsWith("/")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 33 8135540");
          prefix = prefix + "/"; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 34 8135540");

        // Iterate over immediate children, adding files and recursing into directories
        for (String child : /* TRUE */children){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 35 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 36 8135540"); {
          String resourcePath = path + "/" + child;
          resources.add(resourcePath);
          URL childUrl = new URL(prefix + child);
          resources.addAll(list(childUrl, resourcePath));
        }}
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 38 8135540");

      return resources;
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 39 8135540"); 
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 40 8135540"); 
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 41 8135540")|| true) && (is != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 42 8135540");
          is.close(); }
      } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 44 8135540"); 
      }
    }
  }

  /**
   * List the names of the entries in the given {@link JarInputStream} that begin with the
   * specified {@code path}. Entries will match with or without a leading slash.
   * 
   * @param jar The JAR input stream
   * @param path The leading path to match
   * @return The names of all the matching entries
   * @throws IOException If I/O errors occur
   */
  protected List<String> listResources(JarInputStream jar, String path) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 47 8135540"); 
    // Include the leading and trailing slash when matching names
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 48 8135540")|| true) && (!path.startsWith("/")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 49 8135540");
      path = "/" + path; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 50 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 51 8135540")|| true) && (!path.endsWith("/")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 52 8135540");
      path = path + "/"; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 53 8135540");

    // Iterate over the entries and collect those that begin with the requested path
    List<String> resources = new ArrayList<String>();
    for (JarEntry entry; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 54 8135540")|| true) && ((entry = jar.getNextJarEntry()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 12 12 0 0 ","8135540",false,0) && false));){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 55 8135540"); {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 56 8135540")|| true) && (!entry.isDirectory()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 57 8135540"); {
        // Add leading slash if it's missing
        String name = entry.getName();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 58 8135540")|| true) && (!name.startsWith("/")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 14 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 59 8135540");
          name = "/" + name; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 60 8135540");

        // Check file name
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 61 8135540")|| true) && (name.startsWith(path)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 15 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 15 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 62 8135540"); {
          log.debug("Found resource: " + name);
          resources.add(name.substring(1)); // Trim leading slash
        } }
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 65 8135540");
    return resources;
  }

  /**
   * Attempts to deconstruct the given URL to find a JAR file containing the resource referenced
   * by the URL. That is, assuming the URL references a JAR entry, this method will return a URL
   * that references the JAR file containing the entry. If the JAR cannot be located, then this
   * method returns null.
   * 
   * @param url The URL of the JAR entry.
   * @return The URL of the JAR file, if one is found. Null if not.
   * @throws MalformedURLException
   */
  protected URL findJarForResource(URL url) throws MalformedURLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 66 8135540"); 
    log.debug("Find JAR URL: " + url);

    // If the file part of the URL is itself a URL, then that URL probably points to the JAR
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 67 8135540"); 
      for (;/* TRUE */;){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 68 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 69 8135540"); {
        url = new URL(url.getFile());
        log.debug("Inner URL: " + url);
      }}
    } catch (MalformedURLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 71 8135540"); 
      // This will happen at some point and serves as a break in the loop
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 72 8135540");

    // Look for the .jar extension and chop off everything after that
    StringBuilder jarUrl = new StringBuilder(url.toExternalForm());
    int index = jarUrl.lastIndexOf(".jar");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 73 8135540")|| true) && (index >= 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 16 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 16 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 74 8135540"); {
      jarUrl.setLength(index + 4);
      log.debug("Extracted JAR URL: " + jarUrl);
    } }
    else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 75 8135540");  {
      log.debug("Not a JAR: " + jarUrl);
      return null;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 76 8135540");

    // Try to open and test it
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 77 8135540"); 
      URL testUrl = new URL(jarUrl.toString());
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 78 8135540")|| true) && (isJar(testUrl)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 17 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 17 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 79 8135540"); {
        return testUrl;
      } }
      else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 80 8135540");  {
        // WebLogic fix: check if the URL's file exists in the filesystem.
        log.debug("Not a JAR: " + jarUrl);
        jarUrl.replace(0, jarUrl.length(), testUrl.getFile());
        File file = new File(jarUrl.toString());

        // File name might be URL-encoded
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 81 8135540")|| true) && (!file.exists()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 18 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 18 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 82 8135540"); {
          try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 83 8135540"); 
            file = new File(URLEncoder.encode(jarUrl.toString(), "UTF-8"));
          } catch (UnsupportedEncodingException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 84 8135540"); 
            throw new RuntimeException("Unsupported encoding?  UTF-8?  That's unpossible.");
          }
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 86 8135540");

        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 87 8135540")|| true) && (file.exists()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 19 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 19 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 88 8135540"); {
          log.debug("Trying real file: " + file.getAbsolutePath());
          testUrl = file.toURI().toURL();
          if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 89 8135540")|| true) && (isJar(testUrl)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 20 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 20 20 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 90 8135540"); {
            return testUrl;
          } }
        } }
      } }
    } catch (MalformedURLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 94 8135540"); 
      log.warn("Invalid JAR URL: " + jarUrl);
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 95 8135540");

    log.debug("Not a JAR: " + jarUrl);
    return null;
  }

  /**
   * Converts a Java package name to a path that can be looked up with a call to
   * {@link ClassLoader#getResources(String)}.
   * 
   * @param packageName The Java package name to convert to a path
   */
  protected String getPackagePath(String packageName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 96 8135540"); 
    return packageName == null ? null : packageName.replace('.', '/');
  }

  /**
   * Returns true if the resource located at the given URL is a JAR file.
   * 
   * @param url The URL of the resource to test.
   */
  protected boolean isJar(URL url) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 97 8135540"); 
    return isJar(url, new byte[JAR_MAGIC.length]);
  }

  /**
   * Returns true if the resource located at the given URL is a JAR file.
   * 
   * @param url The URL of the resource to test.
   * @param buffer A buffer into which the first few bytes of the resource are read. The buffer
   *            must be at least the size of {@link #JAR_MAGIC}. (The same buffer may be reused
   *            for multiple calls as an optimization.)
   */
  protected boolean isJar(URL url, byte[] buffer) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 229 98 8135540"); 
    InputStream is = null;
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 99 8135540"); 
      is = url.openStream();
      is.read(buffer, 0, JAR_MAGIC.length);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 100 8135540")|| true) && (Arrays.equals(buffer, JAR_MAGIC)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 21 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 229 21 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 101 8135540"); {
        log.debug("Found JAR: " + url);
        return true;
      } }
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 103 8135540"); 
      // Failure to read the stream means this is not a JAR
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 104 8135540"); 
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 105 8135540"); 
        is.close();
      } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 106 8135540"); 
      }
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 229 108 8135540");

    return false;
  }
}
