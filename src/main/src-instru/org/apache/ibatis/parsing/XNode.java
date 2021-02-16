// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 *    Copyright 2009-2011 the original author or authors.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class XNode {

  private Node node;
  private String name;
  private String body;
  private Properties attributes;
  private Properties variables;
  private XPathParser xpathParser;

  public XNode(XPathParser xpathParser, Node node, Properties variables) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 0 8135540"); 
    this.xpathParser = xpathParser;
    this.node = node;
    this.name = node.getNodeName();
    this.variables = variables;
    this.attributes = parseAttributes(node);
    this.body = parseBody(node);
  }

  public XNode newXNode(Node node) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 1 8135540"); 
    return new XNode(xpathParser, node, variables);
  }

  public XNode getParent() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 2 8135540"); 
    Node parent = node.getParentNode();
    int zoa_cond_n3_0 = 2;
int zoa_cond_n3_1 = 2;
//zoa_cond_n3_0#parent == null$zoa_cond_n3_1#(parent instanceof Element)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 3 8135540")|| true) && ((parent == null?(zoa_cond_n3_0 != (zoa_cond_n3_0 = 1)):(zoa_cond_n3_0 == (zoa_cond_n3_0 = 0))) || !((parent instanceof Element)?(zoa_cond_n3_1 != (zoa_cond_n3_1 = 1)):(zoa_cond_n3_1 == (zoa_cond_n3_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 2 0 1 2 ","8135540",true,zoa_cond_n3_0,zoa_cond_n3_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 2 0 0 2 ","8135540",false,zoa_cond_n3_0,zoa_cond_n3_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 4 8135540"); {
      return null;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 5 8135540");  {
      return new XNode(xpathParser, parent, variables);
    } }
  }

  public String getPath() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 7 8135540"); 
    StringBuilder builder = new StringBuilder();
    Node current = node;
    int zoa_cond_n8_0 = 2;
int zoa_cond_n8_1 = 2;
//zoa_cond_n8_0#current != null$zoa_cond_n8_1#current instanceof Element
while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 8 8135540")|| true) && ((current != null?(zoa_cond_n8_0 != (zoa_cond_n8_0 = 1)):(zoa_cond_n8_0 == (zoa_cond_n8_0 = 0))) && (current instanceof Element?(zoa_cond_n8_1 != (zoa_cond_n8_1 = 1)):(zoa_cond_n8_1 == (zoa_cond_n8_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 5 1 1 2 ","8135540",true,zoa_cond_n8_0,zoa_cond_n8_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 5 1 0 2 ","8135540",false,zoa_cond_n8_0,zoa_cond_n8_1) && false))){zoa_cond_n8_0 = 2;
zoa_cond_n8_1 = 2;
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 9 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 10 8135540")|| true) && (current != node? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 6 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 6 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 11 8135540"); {
        builder.insert(0, "/");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 12 8135540");
      builder.insert(0, current.getNodeName());
      current = current.getParentNode();
    }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 13 8135540"); 
    return builder.toString();
  }

  public String getValueBasedIdentifier() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 14 8135540"); 
    StringBuilder builder = new StringBuilder();
    XNode current = this;
    while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 15 8135540")|| true) && (current != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 7 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 7 3 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 16 8135540");  {
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 17 8135540")|| true) && (current != this? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 8 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 8 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 18 8135540"); {
        builder.insert(0, "_");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 19 8135540");
      String value = current.getStringAttribute("id",
          current.getStringAttribute("value",
              current.getStringAttribute("property", null)));
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 20 8135540")|| true) && (value != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 9 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 9 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 21 8135540"); {
        value = value.replace('.', '_');
        builder.insert(0, "]");
        builder.insert(0,
            value);
        builder.insert(0, "[");
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 22 8135540");
      builder.insert(0, current.getName());
      current = current.getParent();
    }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 23 8135540"); 
    return builder.toString();
  }

  public String evalString(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 24 8135540"); 
    return xpathParser.evalString(node, expression);
  }

  public Boolean evalBoolean(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 25 8135540"); 
    return xpathParser.evalBoolean(node, expression);
  }

  public Double evalDouble(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 26 8135540"); 
    return xpathParser.evalDouble(node, expression);
  }

  public List<XNode> evalNodes(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 27 8135540"); 
    return xpathParser.evalNodes(node, expression);
  }

  public XNode evalNode(String expression) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 28 8135540"); 
    return xpathParser.evalNode(node, expression);
  }

  public Node getNode() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 29 8135540"); 
    return node;
  }

  public String getName() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 30 8135540"); 
    return name;
  }

  public String getStringBody() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 31 8135540"); 
    return getStringBody(null);
  }

  public String getStringBody(String def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 32 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 33 8135540")|| true) && (body == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 10 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 10 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 34 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 35 8135540");  {
      return body;
    } }
  }

  public Boolean getBooleanBody() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 37 8135540"); 
    return getBooleanBody(null);
  }

  public Boolean getBooleanBody(Boolean def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 38 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 39 8135540")|| true) && (body == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 11 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 11 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 40 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 41 8135540");  {
      return Boolean.valueOf(body);
    } }
  }

  public Integer getIntBody() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 43 8135540"); 
    return getIntBody(null);
  }

  public Integer getIntBody(Integer def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 44 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 45 8135540")|| true) && (body == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 12 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 12 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 46 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 47 8135540");  {
      return Integer.parseInt(body);
    } }
  }

  public Long getLongBody() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 49 8135540"); 
    return getLongBody(null);
  }

  public Long getLongBody(Long def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 50 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 51 8135540")|| true) && (body == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 13 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 13 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 52 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 53 8135540");  {
      return Long.parseLong(body);
    } }
  }

  public Double getDoubleBody() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 55 8135540"); 
    return getDoubleBody(null);
  }

  public Double getDoubleBody(Double def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 56 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 57 8135540")|| true) && (body == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 14 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 14 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 58 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 59 8135540");  {
      return Double.parseDouble(body);
    } }
  }

  public Float getFloatBody() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 61 8135540"); 
    return getFloatBody(null);
  }

  public Float getFloatBody(Float def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 62 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 63 8135540")|| true) && (body == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 15 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 15 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 64 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 65 8135540");  {
      return Float.parseFloat(body);
    } }
  }

  public <T extends Enum<T>> T getEnumAttribute(Class<T> enumType, String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 67 8135540"); 
    return getEnumAttribute(enumType, name, null);
  }

  public <T extends Enum<T>> T getEnumAttribute(Class<T> enumType, String name, T def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 68 8135540"); 
    String value = getStringAttribute(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 69 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 16 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 16 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 70 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 71 8135540");  {
      return Enum.valueOf(enumType, value);
    } }
  }

  public String getStringAttribute(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 73 8135540"); 
    return getStringAttribute(name, null);
  }

  public String getStringAttribute(String name, String def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 74 8135540"); 
    String value = attributes.getProperty(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 75 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 17 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 17 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 76 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 77 8135540");  {
      return value;
    } }
  }

  public Boolean getBooleanAttribute(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 79 8135540"); 
    return getBooleanAttribute(name, null);
  }

  public Boolean getBooleanAttribute(String name, Boolean def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 80 8135540"); 
    String value = attributes.getProperty(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 81 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 18 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 18 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 82 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 83 8135540");  {
      return Boolean.valueOf(value);
    } }
  }

  public Integer getIntAttribute(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 85 8135540"); 
    return getIntAttribute(name, null);
  }

  public Integer getIntAttribute(String name, Integer def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 86 8135540"); 
    String value = attributes.getProperty(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 87 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 19 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 19 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 88 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 89 8135540");  {
      return Integer.parseInt(value);
    } }
  }

  public Long getLongAttribute(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 91 8135540"); 
    return getLongAttribute(name, null);
  }

  public Long getLongAttribute(String name, Long def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 92 8135540"); 
    String value = attributes.getProperty(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 93 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 20 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 20 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 94 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 95 8135540");  {
      return Long.parseLong(value);
    } }
  }

  public Double getDoubleAttribute(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 97 8135540"); 
    return getDoubleAttribute(name, null);
  }

  public Double getDoubleAttribute(String name, Double def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 98 8135540"); 
    String value = attributes.getProperty(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 99 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 21 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 21 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 100 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 101 8135540");  {
      return Double.parseDouble(value);
    } }
  }

  public Float getFloatAttribute(String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 103 8135540"); 
    return getFloatAttribute(name, null);
  }

  public Float getFloatAttribute(String name, Float def) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 104 8135540"); 
    String value = attributes.getProperty(name);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 105 8135540")|| true) && (value == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 22 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 22 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 106 8135540"); {
      return def;
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 107 8135540");  {
      return Float.parseFloat(value);
    } }
  }

  public List<XNode> getChildren() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 109 8135540"); 
    List<XNode> children = new ArrayList<XNode>();
    NodeList nodeList = node.getChildNodes();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 110 8135540")|| true) && (nodeList != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 23 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 23 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 111 8135540"); {
      for (int i = 0, n = nodeList.getLength(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 112 8135540")|| true) && (i < n? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 24 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 24 20 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 113 8135540"); {
        Node node = nodeList.item(i);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 114 8135540")|| true) && (node.getNodeType() == Node.ELEMENT_NODE? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 25 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 25 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 115 8135540"); {
          children.add(new XNode(xpathParser, node, variables));
        } }
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 118 8135540");
    return children;
  }

  public Properties getChildrenAsProperties() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 119 8135540"); 
    Properties properties = new Properties();
    for (XNode child : /* TRUE */getChildren()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 120 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 121 8135540"); {
      String name = child.getStringAttribute("name");
      String value = child.getStringAttribute("value");
      int zoa_cond_n122_0 = 2;
int zoa_cond_n122_1 = 2;
//zoa_cond_n122_0#name != null$zoa_cond_n122_1#value != null
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 122 8135540")|| true) && ((name != null?(zoa_cond_n122_0 != (zoa_cond_n122_0 = 1)):(zoa_cond_n122_0 == (zoa_cond_n122_0 = 0))) && (value != null?(zoa_cond_n122_1 != (zoa_cond_n122_1 = 1)):(zoa_cond_n122_1 == (zoa_cond_n122_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 28 22 1 2 ","8135540",true,zoa_cond_n122_0,zoa_cond_n122_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 28 22 0 2 ","8135540",false,zoa_cond_n122_0,zoa_cond_n122_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 123 8135540"); {
        properties.setProperty(name, value);
      } }
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 125 8135540");
    return properties;
  }

  public String toString() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 126 8135540"); 
    StringBuilder builder = new StringBuilder();
    builder.append("<");
    builder.append(name);
    for (Map.Entry<Object, Object> entry : /* TRUE */attributes.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 127 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 128 8135540"); {
      builder.append(" ");
      builder.append(entry.getKey());
      builder.append("=\"");
      builder.append(entry.getValue());
      builder.append("\"");
    }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 129 8135540");
    List<XNode> children = getChildren();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 130 8135540")|| true) && (children.size() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 29 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 29 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 131 8135540"); {
      builder.append(">\n");
      for (XNode node : /* TRUE */children){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 132 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 133 8135540"); {
        builder.append(node.toString());
      }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 134 8135540");
      builder.append("</");
      builder.append(name);
      builder.append(">");
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 135 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 136 8135540")|| true) && (body != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 30 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 30 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 137 8135540"); {
      builder.append(">");
      builder.append(body);
      builder.append("</");
      builder.append(name);
      builder.append(">");
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 138 8135540");  {
      builder.append("/>");
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 139 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 140 8135540");
    builder.append("\n");
    return builder.toString();
  }

  private Properties parseAttributes(Node n) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 141 8135540"); 
    Properties attributes = new Properties();
    NamedNodeMap attributeNodes = n.getAttributes();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 142 8135540")|| true) && (attributeNodes != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 31 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 31 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 143 8135540"); {
      for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 144 8135540")|| true) && (i < attributeNodes.getLength()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 32 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 32 26 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 145 8135540"); {
        Node attribute = attributeNodes.item(i);
        String value = PropertyParser.parse(attribute.getNodeValue(), variables);
        attributes.put(attribute.getNodeName(), value);
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 147 8135540");
    return attributes;
  }

  private String parseBody(Node node) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 148 8135540"); 
    String data = getBodyData(node);
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 149 8135540")|| true) && (data == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 33 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 33 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 150 8135540"); {
      NodeList children = node.getChildNodes();
      for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 151 8135540")|| true) && (i < children.getLength()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 34 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 34 28 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 152 8135540"); {
        Node child = children.item(i);
        data = getBodyData(child);
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 153 8135540")|| true) && (data != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 35 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 35 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 154 8135540");  break; }
      }}
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 157 8135540");
    return data;
  }

  private String getBodyData(Node child) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 217 158 8135540"); 
    int zoa_cond_n159_0 = 2;
int zoa_cond_n159_1 = 2;
//zoa_cond_n159_0#child.getNodeType() == Node.CDATA_SECTION_NODE$zoa_cond_n159_1#child.getNodeType() == Node.TEXT_NODE
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 159 8135540")|| true) && ((child.getNodeType() == Node.CDATA_SECTION_NODE?(zoa_cond_n159_0 != (zoa_cond_n159_0 = 1)):(zoa_cond_n159_0 == (zoa_cond_n159_0 = 0)))
        || (child.getNodeType() == Node.TEXT_NODE?(zoa_cond_n159_1 != (zoa_cond_n159_1 = 1)):(zoa_cond_n159_1 == (zoa_cond_n159_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 38 30 1 2 ","8135540",true,zoa_cond_n159_0,zoa_cond_n159_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 217 38 30 0 2 ","8135540",false,zoa_cond_n159_0,zoa_cond_n159_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 160 8135540"); {
      String data = ((CharacterData) child).getData();
      data = PropertyParser.parse(data, variables);
      return data;
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 217 161 8135540");
    return null;
  }

}