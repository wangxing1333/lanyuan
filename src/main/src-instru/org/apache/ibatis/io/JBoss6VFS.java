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
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * A {@link VFS} implementation that works with the VFS API provided by JBoss 6.
 * 
 * @author Ben Gunter
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class JBoss6VFS extends VFS {
  private static final Log log = LogFactory.getLog(ResolverUtil.class);

  /** A class that mimics a tiny subset of the JBoss VirtualFile class. */
  static class VirtualFile {
    static Class<?> VirtualFile;
    static Method getPathNameRelativeTo, getChildrenRecursively;

    Object virtualFile;

    VirtualFile(Object virtualFile) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 0 8135540"); 
      this.virtualFile = virtualFile;
    }

    String getPathNameRelativeTo(VirtualFile parent) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 1 8135540"); 
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 2 8135540"); 
        return invoke(getPathNameRelativeTo, virtualFile, parent.virtualFile);
      } catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 3 8135540"); 
        // This exception is not thrown by the called method
        log.error("This should not be possible. VirtualFile.getPathNameRelativeTo() threw IOException.");
        return null;
      }
    }

    List<VirtualFile> getChildren() throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 5 8135540"); 
      List<?> objects = invoke(getChildrenRecursively, virtualFile);
      List<VirtualFile> children = new ArrayList<VirtualFile>(objects.size());
      for (Object object : /* TRUE */objects){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 6 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 7 8135540"); {
        children.add(new VirtualFile(object));
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 8 8135540");
      return children;
    }
  }

  /** A class that mimics a tiny subset of the JBoss VFS class. */
  static class VFS {
    static Class<?> VFS;
    static Method getChild;

    static VirtualFile getChild(URL url) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 9 8135540"); 
      Object o = invoke(getChild, VFS, url);
      return o == null ? null : new VirtualFile(o);
    }
  }

  /** Flag that indicates if this VFS is valid for the current environment. */
  private static Boolean valid;

  /** Find all the classes and methods that are required to access the JBoss 6 VFS. */
  protected static synchronized void initialize() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 10 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 11 8135540")|| true) && (valid == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 12 8135540"); {
      // Assume valid. It will get flipped later if something goes wrong.
      valid = true;

      // Look up and verify required classes
      VFS.VFS = checkNotNull(getClass("org.jboss.vfs.VFS"));
      VirtualFile.VirtualFile = checkNotNull(getClass("org.jboss.vfs.VirtualFile"));

      // Look up and verify required methods
      VFS.getChild = checkNotNull(getMethod(VFS.VFS, "getChild", URL.class));
      VirtualFile.getChildrenRecursively = checkNotNull(getMethod(VirtualFile.VirtualFile,
          "getChildrenRecursively"));
      VirtualFile.getPathNameRelativeTo = checkNotNull(getMethod(VirtualFile.VirtualFile,
          "getPathNameRelativeTo", VirtualFile.VirtualFile));

      // Verify that the API has not changed
      checkReturnType(VFS.getChild, VirtualFile.VirtualFile);
      checkReturnType(VirtualFile.getChildrenRecursively, List.class);
      checkReturnType(VirtualFile.getPathNameRelativeTo, String.class);
    } }
  }

  /**
   * Verifies that the provided object reference is null. If it is null, then this VFS is marked
   * as invalid for the current environment.
   * 
   * @param object The object reference to check for null.
   */
  protected static <T> T checkNotNull(T object) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 14 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 15 8135540")|| true) && (object == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 16 8135540");
      setInvalid(); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 17 8135540");
    return object;
  }

  /**
   * Verifies that the return type of a method is what it is expected to be. If it is not, then
   * this VFS is marked as invalid for the current environment.
   * 
   * @param method The method whose return type is to be checked.
   * @param expected A type to which the method's return type must be assignable.
   * @see Class#isAssignableFrom(Class)
   */
  protected static void checkReturnType(Method method, Class<?> expected) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 18 8135540"); 
    int zoa_cond_n19_0 = 2;
int zoa_cond_n19_1 = 2;
//zoa_cond_n19_0#method != null$zoa_cond_n19_1#expected.isAssignableFrom(method.getReturnType())
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 19 8135540")|| true) && ((method != null?(zoa_cond_n19_0 != (zoa_cond_n19_0 = 1)):(zoa_cond_n19_0 == (zoa_cond_n19_0 = 0))) && !(expected.isAssignableFrom(method.getReturnType())?(zoa_cond_n19_1 != (zoa_cond_n19_1 = 1)):(zoa_cond_n19_1 == (zoa_cond_n19_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 4 2 1 2 ","8135540",true,zoa_cond_n19_0,zoa_cond_n19_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 4 2 0 2 ","8135540",false,zoa_cond_n19_0,zoa_cond_n19_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 20 8135540"); {
      log.error("Method " + method.getClass().getName() + "." + method.getName()
          + "(..) should return " + expected.getName() + " but returns " //
          + method.getReturnType().getName() + " instead.");
      setInvalid();
    } }
  }

  /** Mark this {@link VFS} as invalid for the current environment. */
  protected static void setInvalid() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 22 8135540"); 
    int zoa_cond_n23_0 = 2;
int zoa_cond_n23_1 = 2;
//zoa_cond_n23_0#JBoss6VFS.valid != null$zoa_cond_n23_1#JBoss6VFS.valid
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 23 8135540")|| true) && ((JBoss6VFS.valid != null?(zoa_cond_n23_0 != (zoa_cond_n23_0 = 1)):(zoa_cond_n23_0 == (zoa_cond_n23_0 = 0))) && (JBoss6VFS.valid?(zoa_cond_n23_1 != (zoa_cond_n23_1 = 1)):(zoa_cond_n23_1 == (zoa_cond_n23_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 7 3 1 2 ","8135540",true,zoa_cond_n23_0,zoa_cond_n23_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 7 3 0 2 ","8135540",false,zoa_cond_n23_0,zoa_cond_n23_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 24 8135540"); {
      log.debug("JBoss 6 VFS API is not available in this environment.");
      JBoss6VFS.valid = false;
    } }
  }

  static {
    ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 26 8135540"); initialize();
  }

  @Override
  public boolean isValid() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 27 8135540"); 
    return valid;
  }

  @Override
  public List<String> list(URL url, String path) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 266 28 8135540"); 
    VirtualFile directory;
    directory = VFS.getChild(url);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 29 8135540")|| true) && (directory == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 30 8135540");
      return Collections.emptyList(); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 31 8135540");

    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 32 8135540")|| true) && (!path.endsWith("/")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 9 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 266 9 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 33 8135540");
      path += "/"; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 34 8135540");

    List<VirtualFile> children = directory.getChildren();
    List<String> names = new ArrayList<String>(children.size());
    for (VirtualFile vf : /* TRUE */children){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 35 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 36 8135540"); {
      String relative = vf.getPathNameRelativeTo(directory);
      names.add(path + relative);
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 266 37 8135540");

    return names;
  }
}
