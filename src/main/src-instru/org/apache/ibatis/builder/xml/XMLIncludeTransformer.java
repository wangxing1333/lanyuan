// ZOA_CREATED! DO NOT EDIT IT! -- 
/*
 * Copyright 2012 MyBatis.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.builder.xml;

import org.apache.ibatis.builder.IncompleteElementException;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.parsing.PropertyParser;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.session.Configuration;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Frank D. Martinez [mnesarco]
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class XMLIncludeTransformer {

  private final Configuration configuration;
  private final MapperBuilderAssistant builderAssistant;

  public XMLIncludeTransformer(Configuration configuration, MapperBuilderAssistant builderAssistant) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 298 0 8135540"); 
    this.configuration = configuration;
    this.builderAssistant = builderAssistant;
  }

  public void applyIncludes(Node source) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 298 1 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 2 8135540")|| true) && (source.getNodeName().equals("include")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 3 8135540"); {
      Node toInclude = findSqlFragment(getStringAttribute(source, "refid"));
      applyIncludes(toInclude);
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 4 8135540")|| true) && (toInclude.getOwnerDocument() != source.getOwnerDocument()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 5 8135540"); {
        toInclude = source.getOwnerDocument().importNode(toInclude, true);
      } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 6 8135540");
      source.getParentNode().replaceChild(toInclude, source);
      while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 7 8135540")|| true) && (toInclude.hasChildNodes()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 2 2 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 8 8135540");  {
        toInclude.getParentNode().insertBefore(toInclude.getFirstChild(), toInclude);
      }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 9 8135540"); 
      toInclude.getParentNode().removeChild(toInclude);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 10 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 11 8135540")|| true) && (source.getNodeType() == Node.ELEMENT_NODE? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 12 8135540"); {
      NodeList children = source.getChildNodes();
      for (int i=0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 13 8135540")|| true) && (i<children.getLength()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 298 4 4 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 14 8135540"); {
        applyIncludes(children.item(i));
      }}
    } } }
  }

  private Node findSqlFragment(String refid) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 298 18 8135540"); 
    refid = PropertyParser.parse(refid, configuration.getVariables());
    refid = builderAssistant.applyCurrentNamespace(refid, true);
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 19 8135540"); 
      XNode nodeToInclude = configuration.getSqlFragments().get(refid);
      Node result = nodeToInclude.getNode().cloneNode(true);
      return result;
    } catch (IllegalArgumentException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 298 20 8135540"); 
      throw new IncompleteElementException("Could not find SQL statement to include with refid '" + refid + "'", e);
    }
  }

  private String getStringAttribute(Node node, String name) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 298 22 8135540"); 
    return node.getAttributes().getNamedItem(name).getNodeValue();
  }
}
