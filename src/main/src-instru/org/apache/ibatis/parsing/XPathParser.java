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
package org.apache.ibatis.parsing;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.ibatis.builder.BuilderException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class XPathParser {

  private Document document;
  private boolean validation;
  private EntityResolver entityResolver;
  private Properties variables;
  private XPath xpath;

  public XPathParser(String xml) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 0 8135540"); 
    commonConstructor(false, null, null);
    this.document = createDocument(new InputSource(new StringReader(xml)));
  }

  public XPathParser(Reader reader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 1 8135540"); 
    commonConstructor(false, null, null);
    this.document = createDocument(new InputSource(reader));
  }

  public XPathParser(InputStream inputStream) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 2 8135540"); 
    commonConstructor(false, null, null);
    this.document = createDocument(new InputSource(inputStream));
  }

  public XPathParser(Document document) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 3 8135540"); 
    commonConstructor(false, null, null);
    this.document = document;
  }

  public XPathParser(String xml, boolean validation) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 4 8135540"); 
    commonConstructor(validation, null, null);
    this.document = createDocument(new InputSource(new StringReader(xml)));
  }

  public XPathParser(Reader reader, boolean validation) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 5 8135540"); 
    commonConstructor(validation, null, null);
    this.document = createDocument(new InputSource(reader));
  }

  public XPathParser(InputStream inputStream, boolean validation) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 6 8135540"); 
    commonConstructor(validation, null, null);
    this.document = createDocument(new InputSource(inputStream));
  }

  public XPathParser(Document document, boolean validation) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 7 8135540"); 
    commonConstructor(validation, null, null);
    this.document = document;
  }

  public XPathParser(String xml, boolean validation, Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 8 8135540"); 
    commonConstructor(validation, variables, null);
    this.document = createDocument(new InputSource(new StringReader(xml)));
  }

  public XPathParser(Reader reader, boolean validation, Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 9 8135540"); 
    commonConstructor(validation, variables, null);
    this.document = createDocument(new InputSource(reader));
  }

  public XPathParser(InputStream inputStream, boolean validation, Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 10 8135540"); 
    commonConstructor(validation, variables, null);
    this.document = createDocument(new InputSource(inputStream));
  }

  public XPathParser(Document document, boolean validation, Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 11 8135540"); 
    commonConstructor(validation, variables, null);
    this.document = document;
  }

  public XPathParser(String xml, boolean validation, Properties variables, EntityResolver entityResolver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 12 8135540"); 
    commonConstructor(validation, variables, entityResolver);
    this.document = createDocument(new InputSource(new StringReader(xml)));
  }

  public XPathParser(Reader reader, boolean validation, Properties variables, EntityResolver entityResolver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 13 8135540"); 
    commonConstructor(validation, variables, entityResolver);
    this.document = createDocument(new InputSource(reader));
  }

  public XPathParser(InputStream inputStream, boolean validation, Properties variables, EntityResolver entityResolver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 14 8135540"); 
    commonConstructor(validation, variables, entityResolver);
    this.document = createDocument(new InputSource(inputStream));
  }

  public XPathParser(Document document, boolean validation, Properties variables, EntityResolver entityResolver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 15 8135540"); 
    commonConstructor(validation, variables, entityResolver);
    this.document = document;
  }

  public void setVariables(Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 16 8135540"); 
    this.variables = variables;
  }

  public String evalString(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 17 8135540"); 
    return evalString(document, expression);
  }

  public String evalString(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 18 8135540"); 
    String result = (String) evaluate(expression, root, XPathConstants.STRING);
    result = PropertyParser.parse(result, variables);
    return result;
  }

  public Boolean evalBoolean(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 19 8135540"); 
    return evalBoolean(document, expression);
  }

  public Boolean evalBoolean(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 20 8135540"); 
    return (Boolean) evaluate(expression, root, XPathConstants.BOOLEAN);
  }

  public Short evalShort(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 21 8135540"); 
    return evalShort(document, expression);
  }

  public Short evalShort(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 22 8135540"); 
    return Short.valueOf(evalString(root, expression));
  }

  public Integer evalInteger(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 23 8135540"); 
    return evalInteger(document, expression);
  }

  public Integer evalInteger(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 24 8135540"); 
    return Integer.valueOf(evalString(root, expression));
  }

  public Long evalLong(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 25 8135540"); 
    return evalLong(document, expression);
  }

  public Long evalLong(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 26 8135540"); 
    return Long.valueOf(evalString(root, expression));
  }

  public Float evalFloat(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 27 8135540"); 
    return evalFloat(document, expression);
  }

  public Float evalFloat(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 28 8135540"); 
    return Float.valueOf(evalString(root, expression));
  }

  public Double evalDouble(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 29 8135540"); 
    return evalDouble(document, expression);
  }

  public Double evalDouble(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 30 8135540"); 
    return (Double) evaluate(expression, root, XPathConstants.NUMBER);
  }

  public List<XNode> evalNodes(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 31 8135540"); 
    return evalNodes(document, expression);
  }

  public List<XNode> evalNodes(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 32 8135540"); 
    List<XNode> xnodes = new ArrayList<XNode>();
    NodeList nodes = (NodeList) evaluate(expression, root, XPathConstants.NODESET);
    for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 33 8135540")|| true) && (i < nodes.getLength()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 301 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 301 0 0 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 34 8135540"); {
      xnodes.add(new XNode(this, nodes.item(i), variables));
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 35 8135540");
    return xnodes;
  }

  public XNode evalNode(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 36 8135540"); 
    return evalNode(document, expression);
  }

  public XNode evalNode(Object root, String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 37 8135540"); 
    Node node = (Node) evaluate(expression, root, XPathConstants.NODE);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 38 8135540")|| true) && (node == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 301 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 301 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 39 8135540"); {
      return null;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 40 8135540");
    return new XNode(this, node, variables);
  }

  private Object evaluate(String expression, Object root, QName returnType) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 41 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 42 8135540"); 
      return xpath.evaluate(expression, root, returnType);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 43 8135540"); 
      throw new BuilderException("Error evaluating XPath.  Cause: " + e, e);
    }
  }

  private Document createDocument(InputSource inputSource) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 45 8135540"); 
    // important: this must only be called AFTER common constructor
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 46 8135540"); 
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(validation);

      factory.setNamespaceAware(false);
      factory.setIgnoringComments(true);
      factory.setIgnoringElementContentWhitespace(false);
      factory.setCoalescing(false);
      factory.setExpandEntityReferences(true);

      DocumentBuilder builder = factory.newDocumentBuilder();
      builder.setEntityResolver(entityResolver);
      builder.setErrorHandler(new ErrorHandler() {
        public void error(SAXParseException exception) throws SAXException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 47 8135540"); 
          throw exception;
        }

        public void fatalError(SAXParseException exception) throws SAXException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 48 8135540"); 
          throw exception;
        }

        public void warning(SAXParseException exception) throws SAXException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 49 8135540"); 
        }
      });
      return builder.parse(inputSource);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 301 50 8135540"); 
      throw new BuilderException("Error creating document instance.  Cause: " + e, e);
    }
  }

  private void commonConstructor(boolean validation, Properties variables, EntityResolver entityResolver) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 301 52 8135540"); 
    this.validation = validation;
    this.entityResolver = entityResolver;
    this.variables = variables;
    XPathFactory factory = XPathFactory.newInstance();
    this.xpath = factory.newXPath();
  }

}
