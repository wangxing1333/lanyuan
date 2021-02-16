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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * Provides a very simple API for accessing resources within an application server.
 * 
 * @author Ben Gunter
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public abstract class VFS {
  private static final Log log = LogFactory.getLog(ResolverUtil.class);

  /** The built-in implementations. */
  public static final Class<?>[] IMPLEMENTATIONS = { JBoss6VFS.class, DefaultVFS.class };

  /** The list to which implementations are added by {@link #addImplClass(Class)}. */
  public static final List<Class<? extends VFS>> USER_IMPLEMENTATIONS = new ArrayList<Class<? extends VFS>>();

  /** Singleton instance. */
  private static VFS instance;

  /**
   * Get the singleton {@link VFS} instance. If no {@link VFS} implementation can be found for the
   * current environment, then this method returns null.
   */
  @SuppressWarnings("unchecked")
  public static VFS getInstance() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 0 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 1 8135540")|| true) && (instance != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 2 8135540");
      return instance; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 3 8135540");

    // Try the user implementations first, then the built-ins
    List<Class<? extends VFS>> impls = new ArrayList<Class<? extends VFS>>();
    impls.addAll(USER_IMPLEMENTATIONS);
    impls.addAll(Arrays.asList((Class<? extends VFS>[]) IMPLEMENTATIONS));

    // Try each implementation class until a valid one is found
    VFS vfs = null;
    int zoa_cond_n4_0 = 2;
int zoa_cond_n4_1 = 2;
//zoa_cond_n4_0#vfs == null$zoa_cond_n4_1#vfs.isValid()
for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 4 8135540")|| true) && ((vfs == null?(zoa_cond_n4_0 != (zoa_cond_n4_0 = 1)):(zoa_cond_n4_0 == (zoa_cond_n4_0 = 0))) || !(vfs.isValid()?(zoa_cond_n4_1 != (zoa_cond_n4_1 = 1)):(zoa_cond_n4_1 == (zoa_cond_n4_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 3 1 1 2 ","8135540",true,zoa_cond_n4_0,zoa_cond_n4_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 3 1 0 2 ","8135540",false,zoa_cond_n4_0,zoa_cond_n4_1) && false)); i++){zoa_cond_n4_0 = 2;
zoa_cond_n4_1 = 2;
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 5 8135540"); {
      Class<? extends VFS> impl = impls.get(i);
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 6 8135540"); 
        vfs = impl.newInstance();
        int zoa_cond_n7_0 = 2;
int zoa_cond_n7_1 = 2;
//zoa_cond_n7_0#vfs == null$zoa_cond_n7_1#vfs.isValid()
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 7 8135540")|| true) && ((vfs == null?(zoa_cond_n7_0 != (zoa_cond_n7_0 = 1)):(zoa_cond_n7_0 == (zoa_cond_n7_0 = 0))) || !(vfs.isValid()?(zoa_cond_n7_1 != (zoa_cond_n7_1 = 1)):(zoa_cond_n7_1 == (zoa_cond_n7_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 6 2 1 2 ","8135540",true,zoa_cond_n7_0,zoa_cond_n7_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 6 2 0 2 ","8135540",false,zoa_cond_n7_0,zoa_cond_n7_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 8 8135540"); {
          log.debug("VFS implementation " + impl.getName() +
              " is not valid in this environment.");
        } }
      } catch (InstantiationException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 10 8135540"); 
        log.error("Failed to instantiate " + impl, e);
        return null;
      } catch (IllegalAccessException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 11 8135540"); 
        log.error("Failed to instantiate " + impl, e);
        return null;
      }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 13 8135540");

    log.debug("Using VFS adapter " + vfs.getClass().getName());
    return VFS.instance = vfs;
  }

  /**
   * Adds the specified class to the list of {@link VFS} implementations. Classes added in this
   * manner are tried in the order they are added and before any of the built-in implementations.
   * 
   * @param clazz The {@link VFS} implementation class to add.
   */
  public static void addImplClass(Class<? extends VFS> clazz) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 14 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 15 8135540")|| true) && (clazz != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 7 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 16 8135540");
      USER_IMPLEMENTATIONS.add(clazz); }
  }

  /** Get a class by name. If the class is not found then return null. */
  protected static Class<?> getClass(String className) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 18 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 19 8135540"); 
      return Thread.currentThread().getContextClassLoader().loadClass(className);
//      return ReflectUtil.findClass(className);
    } catch (ClassNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 20 8135540"); 
      log.debug("Class not found: " + className);
      return null;
    }
  }

  /**
   * Get a method by name and parameter types. If the method is not found then return null.
   * 
   * @param clazz The class to which the method belongs.
   * @param methodName The name of the method.
   * @param parameterTypes The types of the parameters accepted by the method.
   */
  protected static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 22 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 23 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 24 8135540")|| true) && (clazz == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 25 8135540");
        return null; }
      else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 26 8135540"); 
        return clazz.getMethod(methodName, parameterTypes); }
    } catch (SecurityException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 28 8135540"); 
      log.error("Security exception looking for method " + clazz.getName() + "." + methodName + ".  Cause: " + e);
      return null;
    } catch (NoSuchMethodException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 29 8135540"); 
      log.error("Method not found " + clazz.getName() + "." + methodName + "." + methodName + ".  Cause: " + e);
      return null;
    }
  }

  /**
   * Invoke a method on an object and return whatever it returns.
   * 
   * @param method The method to invoke.
   * @param object The instance or class (for static methods) on which to invoke the method.
   * @param parameters The parameters to pass to the method.
   * @return Whatever the method returns.
   * @throws IOException If I/O errors occur
   * @throws StripesRuntimeException If anything else goes wrong
   */
  @SuppressWarnings("unchecked")
  protected static <T> T invoke(Method method, Object object, Object... parameters)
      throws IOException, RuntimeException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 31 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 32 8135540"); 
      return (T) method.invoke(object, parameters);
    } catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 33 8135540"); 
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 34 8135540"); 
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 35 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 36 8135540")|| true) && (e.getTargetException() instanceof IOException? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 9 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 187 9 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 37 8135540");
        throw (IOException) e.getTargetException(); }
      else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 38 8135540"); 
        throw new RuntimeException(e); }
    }
  }

  /**
   * Get a list of {@link URL}s from the context classloader for all the resources found at the
   * specified path.
   * 
   * @param path The resource path.
   * @return A list of {@link URL}s, as returned by {@link ClassLoader#getResources(String)}.
   * @throws IOException If I/O errors occur
   */
  protected static List<URL> getResources(String path) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 41 8135540"); 
    return Collections.list(Thread.currentThread().getContextClassLoader().getResources(path));
  }

  /** Return true if the {@link VFS} implementation is valid for the current environment. */
  public abstract boolean isValid();

  /**
   * Recursively list the full resource path of all the resources that are children of the
   * resource identified by a URL.
   * 
   * @param url The URL that identifies the resource to list.
   * @param forPath The path to the resource that is identified by the URL. Generally, this is the
   *            value passed to {@link #getResources(String)} to get the resource URL.
   * @return A list containing the names of the child resources.
   * @throws IOException If I/O errors occur
   */
  protected abstract List<String> list(URL url, String forPath) throws IOException;

  /**
   * Recursively list the full resource path of all the resources that are children of all the
   * resources found at the specified path.
   * 
   * @param path The path of the resource(s) to list.
   * @return A list containing the names of the child resources.
   * @throws IOException If I/O errors occur
   */
  public List<String> list(String path) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 187 42 8135540"); 
    List<String> names = new ArrayList<String>();
    for (URL url : /* TRUE */getResources(path)){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 43 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 44 8135540"); {
      names.addAll(list(url, path));
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 187 45 8135540");
    return names;
  }
}
