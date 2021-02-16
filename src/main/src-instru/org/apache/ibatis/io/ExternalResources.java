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

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Properties;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ExternalResources {

  private ExternalResources() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 309 0 8135540"); 
    // do nothing
  }

  public static void copyExternalResource(File sourceFile, File destFile) throws IOException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 309 1 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 2 8135540")|| true) && (!destFile.exists()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 309 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 309 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 3 8135540"); {
      destFile.createNewFile();
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 4 8135540");

    FileChannel source = null;
    FileChannel destination = null;
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 5 8135540"); 
      source = new FileInputStream(sourceFile).getChannel();
      destination = new FileOutputStream(destFile).getChannel();
      destination.transferFrom(source, 0, source.size());
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 6 8135540"); 
      closeQuietly(source);
      closeQuietly(destination);
    }

  }

  private static void closeQuietly(Closeable closeable) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 309 8 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 9 8135540")|| true) && (closeable != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 309 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 309 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 10 8135540"); {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 11 8135540"); 
        closeable.close();
      } catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 12 8135540"); 
        // do nothing, close quietly
      }
    } }
  }

  public static String getConfiguredTemplate(String templatePath, String templateProperty) throws FileNotFoundException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 309 15 8135540"); 
    String templateName = "";
    Properties migrationProperties = new Properties();

    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 16 8135540"); 
      migrationProperties.load(new FileInputStream(templatePath));
      templateName = migrationProperties.getProperty(templateProperty);
    } catch (FileNotFoundException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 17 8135540"); 
      throw e;
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 18 8135540"); 
      e.printStackTrace();
    }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 309 19 8135540");

    return templateName;
  }

}
