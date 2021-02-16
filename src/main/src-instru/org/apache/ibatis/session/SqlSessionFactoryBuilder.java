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
package org.apache.ibatis.session;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/*
 * Builds {@link SqlSession} instances.
 *
 */
/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SqlSessionFactoryBuilder {

  public SqlSessionFactory build(Reader reader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 0 8135540"); 
    return build(reader, null, null);
  }

  public SqlSessionFactory build(Reader reader, String environment) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 1 8135540"); 
    return build(reader, environment, null);
  }

  public SqlSessionFactory build(Reader reader, Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 2 8135540"); 
    return build(reader, null, properties);
  }

  public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 3 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 4 8135540"); 
      XMLConfigBuilder parser = new XMLConfigBuilder(reader, environment, properties);
      return build(parser.parse());
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 5 8135540"); 
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 6 8135540"); 
      ErrorContext.instance().reset();
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 7 8135540"); 
        reader.close();
      } catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 8 8135540"); 
        // Intentionally ignore. Prefer previous error.
      }
    }
  }

  public SqlSessionFactory build(InputStream inputStream) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 11 8135540"); 
    return build(inputStream, null, null);
  }

  public SqlSessionFactory build(InputStream inputStream, String environment) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 12 8135540"); 
    return build(inputStream, environment, null);
  }

  public SqlSessionFactory build(InputStream inputStream, Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 13 8135540"); 
    return build(inputStream, null, properties);
  }

  public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 14 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 15 8135540"); 
      XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
      return build(parser.parse());
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 16 8135540"); 
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 17 8135540"); 
      ErrorContext.instance().reset();
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 18 8135540"); 
        inputStream.close();
      } catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 253 19 8135540"); 
        // Intentionally ignore. Prefer previous error.
      }
    }
  }
    
  public SqlSessionFactory build(Configuration config) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 253 22 8135540"); 
    return new DefaultSqlSessionFactory(config);
  }

}
