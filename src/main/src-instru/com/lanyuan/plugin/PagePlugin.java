// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.log4j.Logger;

import com.lanyuan.annotation.TableSeg;
import com.lanyuan.util.FormMap;

/**
 * Mybatis的分页查询插件，通过拦截StatementHandler的prepare方法来实现。 
 * 只有在参数列表中包括Page类型的参数时才进行分页查询。 
 * 在多参数的情况下，只对第一个Page类型的参数生效。 
 * 另外，在参数列表中，Page类型的参数无需用@Param来标注 
 * @author lanyuan
 * 2015-03-20
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
@SuppressWarnings("unchecked")
@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class })})
public class PagePlugin implements Interceptor {
	public final static Logger logger = Logger.getLogger(PagePlugin.class);
	private static String dialect = null;//数据库类型
	private static String pageSqlId = ""; // mybaits的数据库xml映射文件中需要拦截的ID(正则匹配)
	@SuppressWarnings("rawtypes")
	public Object intercept(Invocation ivk) throws Throwable {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 0 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 1 8135540")|| true) && (ivk.getTarget() instanceof RoutingStatementHandler? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 2 8135540"); {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk
					.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper
					.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper
					.getValueByFieldName(delegate, "mappedStatement");
			/**
			 * 方法1：通过ＩＤ来区分是否需要分页．.*query.*
			 * 方法2：传入的参数是否有page参数，如果有，则分页，
			 */
		//	if (mappedStatement.getId().matches(pageSqlId)) { // 拦截需要分页的SQL
				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 3 8135540")|| true) && (parameterObject == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 4 8135540"); {
					//throw new NullPointerException("boundSql.getParameterObject() is null!");
					return ivk.proceed();
				} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 5 8135540");  {
					if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 6 8135540")|| true) && (mappedStatement.getId().indexOf(".BaseMapper.")>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 7 8135540");{
						Connection connection = (Connection) ivk.getArgs()[0];
						//parameterObject = toHashMap(model, pageView);
						 // 公共方法被调用
						Map formMap = null;
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 8 8135540")|| true) && (parameterObject instanceof FormMap? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 9 8135540");{
							formMap = toHashMap(parameterObject);
						} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 10 8135540");  if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 11 8135540")|| true) && (parameterObject instanceof Map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 12 8135540");{
							Map map = (Map) parameterObject;
							if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 13 8135540")|| true) && (map.containsKey("list")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 14 8135540");{
								List<Object> lists = (List<Object>) map.get("list");
								String sql = Plugin.joinSql(connection, mappedStatement, boundSql, formMap,lists);
								ReflectHelper.setValueByFieldName(boundSql, "sql", sql);
								return ivk.proceed();
							} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 15 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 16 8135540")|| true) && ("HashMap".equals(parameterObject.getClass().getSimpleName())? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 17 8135540"); {
								return ivk.proceed();
							} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 18 8135540"); {
								Class fm = (Class) map.get("param3");
								Object o = fm.newInstance();
								formMap = toHashMap(o);
								formMap.put("key", map.get("param1"));
								formMap.put("value", map.get("param2"));
							} } }
						} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 21 8135540"); {
							throw new NullPointerException("调用公共方法，传入参数有错误！具体请看参数说明！");
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 22 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 23 8135540");
						String sql = Plugin.joinSql(connection, mappedStatement, boundSql, formMap,null);
						ReflectHelper.setValueByFieldName(boundSql, "sql", sql);
						return ivk.proceed();
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 24 8135540");
					PageView pageView = null;
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 25 8135540")|| true) && (parameterObject instanceof PageView? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 26 8135540"); { // 参数就是Pages实体
						pageView = (PageView) parameterObject;
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 27 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 28 8135540")|| true) && (parameterObject instanceof Map? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 29 8135540"); {
						for (Entry entry : /* TRUE */(Set<Entry>) ((Map) parameterObject)
								.entrySet()){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 30 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 31 8135540"); {
							if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 32 8135540")|| true) && (entry.getValue() instanceof PageView? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 33 8135540"); {
								pageView = (PageView) entry.getValue();
								 break;
							} }
						}}
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 36 8135540");  { // 参数为某个实体，该实体拥有Pages属性
						pageView = ReflectHelper.getValueByFieldType(
								parameterObject, PageView.class);
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 37 8135540")|| true) && (pageView == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 38 8135540"); {
							return ivk.proceed();
						} }
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 40 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 41 8135540");
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 42 8135540")|| true) && (pageView == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 43 8135540"); {
						return ivk.proceed();
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 44 8135540");
					String sql = boundSql.getSql();
					Connection connection = (Connection) ivk.getArgs()[0];
					setPageParameter(sql, connection, mappedStatement, boundSql, parameterObject, pageView);
					String pageSql = generatePagesSql(sql, pageView);
					ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); // 将分页sql语句反射回BoundSql.
				} }
			//}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 46 8135540");
		return ivk.proceed();
	}
	/**
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数
     * <code>PageParameter</code>获得相关信息。
     * 
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
	 * @throws SQLException 
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
            BoundSql boundSql,Object parameterObject, PageView pageView) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 47 8135540"); 
        // 记录总记录数
    	PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 48 8135540"); 
			String countSql = "";
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 49 8135540"); 
				 countSql = "select count(1) from " + suffixStr(removeOrderBys(sql));
				countStmt = connection.prepareStatement(countSql);
				rs = countStmt.executeQuery();
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 50 8135540"); 
				PagePlugin.logger.error(countSql+" 统计Sql出错,自动转换为普通统计Sql语句!");
				countSql = "select count(1) from (" + sql+ ") tmp_count"; 
				countStmt = connection.prepareStatement(countSql);
				rs = countStmt.executeQuery();
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 51 8135540");
			int count = 0;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 52 8135540")|| true) && (rs.next()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 53 8135540"); {
				count = ((Number) rs.getObject(1)).intValue();
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 54 8135540");
			pageView.setRowCount(count);
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 55 8135540"); 
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 56 8135540"); 
				rs.close();
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 57 8135540"); 
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 58 8135540");
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 59 8135540"); 
				countStmt.close();
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 60 8135540"); 
			}
		}

    }
	/**
	   *   select
	     *  id,
		 * 	articleNo,
		 * sum(ddd) ss,
		 * 	articleName,
	     *  (SELECT loginName from ly_userinfo u where u.id=userId) loginName,
		 * 	(SELECT userName from ly_userinfo u where u.id=userId) userName,
		 * sum(ddd) ss
		 * from article	
		 * 兼容以上子查询
		 * //去除sql ..from 前面的字符。考虑 aafrom fromdd 等等情况
	   */
	public static String suffixStr(String toSql){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 63 8135540"); 
		toSql=toSql.toUpperCase();
		int sun = toSql.indexOf("from");
		String f1 = toSql.substring(sun-1,sun);
		String f2 = toSql.substring(sun+4,sun+5);
		int zoa_cond_n64_0 = 2;
int zoa_cond_n64_1 = 2;
//zoa_cond_n64_0#f1.trim().isEmpty()$zoa_cond_n64_1#f2.trim().isEmpty()
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 64 8135540")|| true) && ((f1.trim().isEmpty()?(zoa_cond_n64_0 != (zoa_cond_n64_0 = 1)):(zoa_cond_n64_0 == (zoa_cond_n64_0 = 0)))&&(f2.trim().isEmpty()?(zoa_cond_n64_1 != (zoa_cond_n64_1 = 1)):(zoa_cond_n64_1 == (zoa_cond_n64_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 15 13 1 2 ","8135540",true,zoa_cond_n64_0,zoa_cond_n64_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 15 13 0 2 ","8135540",false,zoa_cond_n64_0,zoa_cond_n64_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 65 8135540");{//判断第一个from的前后是否为空
			String s1 = toSql.substring(0,sun);
			int s0 =s1.indexOf("(");
			if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 66 8135540")|| true) && (s0>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 16 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 16 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 67 8135540");{
				int se1 =s1.indexOf("select");
				if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 68 8135540")|| true) && (s0<se1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 17 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 69 8135540");{
					if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 70 8135540")|| true) && (se1>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 18 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 18 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 71 8135540");{
						String ss1 = s1.substring(se1-1,se1);
						String ss2 = s1.substring(se1+6,se1+7);
						int zoa_cond_n72_0 = 2;
int zoa_cond_n72_1 = 2;
//zoa_cond_n72_0#ss1.trim().isEmpty()$zoa_cond_n72_1#ss2.trim().isEmpty()
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 72 8135540")|| true) && ((ss1.trim().isEmpty()?(zoa_cond_n72_0 != (zoa_cond_n72_0 = 1)):(zoa_cond_n72_0 == (zoa_cond_n72_0 = 0)))&&(ss2.trim().isEmpty()?(zoa_cond_n72_1 != (zoa_cond_n72_1 = 1)):(zoa_cond_n72_1 == (zoa_cond_n72_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 21 17 1 2 ","8135540",true,zoa_cond_n72_0,zoa_cond_n72_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 21 17 0 2 ","8135540",false,zoa_cond_n72_0,zoa_cond_n72_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 73 8135540");{//判断第一个from的前后是否为空
							return suffixStr(toSql.substring(sun+5));
						} }
					} }
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 76 8135540");	
				int se2 =s1.indexOf("(select");
					if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 77 8135540")|| true) && (se2>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 22 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 22 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 78 8135540");{
						String ss2 = s1.substring(se2+7,se2+8);
						if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 79 8135540")|| true) && (ss2.trim().isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 23 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 23 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 80 8135540");{//判断第一个from的前后是否为空
							return suffixStr(toSql.substring(sun+5));
						} }
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 82 8135540");
					int zoa_cond_n83_0 = 2;
int zoa_cond_n83_1 = 2;
//zoa_cond_n83_0#se1 == -1$zoa_cond_n83_1#se2 == -1
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 83 8135540")|| true) && ((se1==-1?(zoa_cond_n83_0 != (zoa_cond_n83_0 = 1)):(zoa_cond_n83_0 == (zoa_cond_n83_0 = 0)))&&(se2==-1?(zoa_cond_n83_1 != (zoa_cond_n83_1 = 1)):(zoa_cond_n83_1 == (zoa_cond_n83_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 26 20 1 2 ","8135540",true,zoa_cond_n83_0,zoa_cond_n83_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 26 20 0 2 ","8135540",false,zoa_cond_n83_0,zoa_cond_n83_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 84 8135540");{
						return toSql.substring(sun+5);
					} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 85 8135540"); {
						toSql=toSql.substring(sun+5);
					} }
			} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 87 8135540"); {
				toSql=toSql.substring(sun+5);
			} }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 89 8135540");
		return toSql;
	}
	public static void main(String[] args) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 90 8135540"); 
		String sql="  select "+
		 "	articleNo "+
		 " from article left jion aefv where 1=(SELECT userName from ly_userinfo u where u.id=userId) "
		 + "and id = sdf   order by as asc";
		sql=removeOrderBys(sql);
		System.out.println(sql);
		System.out.println(suffixStr(sql));
	}
	 /** 
   * 去除Sql的orderBy。 
   * @param toSql 
   * @return String
   *
   */  
  private static String removeOrderBys(String toSql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 91 8135540");   
	  	toSql=toSql.toUpperCase();
	  	int sun = toSql.indexOf("order");
	  	if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 92 8135540")|| true) && (sun>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 27 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 27 21 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 93 8135540");{
	  	  	String f1 = toSql.substring(sun-1,sun);
	  		String f2 = toSql.substring(sun+5,sun+5);
	  		int zoa_cond_n94_0 = 2;
int zoa_cond_n94_1 = 2;
//zoa_cond_n94_0#f1.trim().isEmpty()$zoa_cond_n94_1#f2.trim().isEmpty()
if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 94 8135540")|| true) && ((f1.trim().isEmpty()?(zoa_cond_n94_0 != (zoa_cond_n94_0 = 1)):(zoa_cond_n94_0 == (zoa_cond_n94_0 = 0)))&&(f2.trim().isEmpty()?(zoa_cond_n94_1 != (zoa_cond_n94_1 = 1)):(zoa_cond_n94_1 == (zoa_cond_n94_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 30 22 1 2 ","8135540",true,zoa_cond_n94_0,zoa_cond_n94_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 30 22 0 2 ","8135540",false,zoa_cond_n94_0,zoa_cond_n94_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 95 8135540");{//判断第一个from的前后是否为空
	  		  	String zb = toSql.substring(sun);
	  		  	int s0 =zb.indexOf(")");
	  		  	if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 96 8135540")|| true) && (s0>-1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 31 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 31 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 97 8135540");{//from之前是否有括号
	  		  		String s1=toSql.substring(0,sun);
	  		  		String s2 =zb.substring(s0);
	  		  		return removeOrderBys(s1+s2);
	  		  	} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 98 8135540"); {
	  		  		toSql=toSql.substring(0,sun);
	  		  	} }
	  		} }
	  	} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 101 8135540");
		return toSql;
  }
	
    /**
	 * 根据数据库方言，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	public static String generatePagesSql(String sql, PageView page) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 102 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 103 8135540")|| true) && (page != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 32 24 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 32 24 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 104 8135540"); {
			if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 105 8135540")|| true) && ("mysql".equals(dialect)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 33 25 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 33 25 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 106 8135540");{
				return buildPageSqlForMysql(sql, page).toString();
			} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 107 8135540");  if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 108 8135540")|| true) && ("oracle".equals(dialect)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 34 26 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 34 26 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 109 8135540");{
				return buildPageSqlForOracle(sql, page).toString();
			} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 110 8135540");  if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 111 8135540")|| true) && ("SQLServer2008".equals(dialect)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 35 27 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 35 27 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 112 8135540");{
				return buildPageSqlForSQLServer2008Dialect(sql, page).toString();
			} } } }
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 116 8135540");
		return sql;
	}
	  /**
     * mysql的分页语句
     * 
     * @param sql
     * @param page
     * @return String
     */
    public static StringBuilder buildPageSqlForMysql(String sql, PageView page) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 117 8135540"); 
    	 StringBuilder pageSql = new StringBuilder(100);
         String beginrow = String.valueOf((page.getPageNow() - 1) * page.getPageSize());
         pageSql.append(sql);
         pageSql.append(" limit " + beginrow + "," + page.getPageSize());
         return pageSql;
    }

    /**
     * 参考hibernate的实现完成oracle的分页
     * 
     * @param sql
     * @param page
     * @return String
     */
    public static StringBuilder buildPageSqlForOracle(String sql, PageView page) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 118 8135540"); 
        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((page.getPageNow()) * page.getPageSize());
        String endrow = String.valueOf(page.getPageNow()+1 * page.getPageSize());

        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(endrow);
        pageSql.append(") where row_id > ").append(beginrow);
        return pageSql;
    }
    /**
     * 参考hibernate的实现完成SQLServer2008的分页
     * 
     * @param sql
     * @param page
     * @return String
     */
    public static String buildPageSqlForSQLServer2008Dialect(String sql, PageView page) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 119 8135540"); 
        SQLServer2008Dialect dialect = new SQLServer2008Dialect(); 
        String sqlbuild = dialect.getLimitString(sql, (page.getPageNow() - 1) * page.getPageSize(), page.getPageSize());
        return sqlbuild;
    }
	public Object plugin(Object target) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 120 8135540"); 
		return Plugin.wrap(target, this);
	}

	@SuppressWarnings("restriction")
	public void setProperties(Properties p) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 121 8135540"); 
		dialect = p.getProperty("dialect");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 122 8135540")|| true) && (isEmpty(dialect)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 36 28 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 36 28 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 123 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 124 8135540"); 
				throw new PropertyException("dialectName or dialect property is not found!");
			} catch (PropertyException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 125 8135540"); 
				e.printStackTrace();
			}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 127 8135540"); 
		pageSqlId = p.getProperty("pageSqlId");//根据id来区分是否需要分页
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 128 8135540")|| true) && (isEmpty(pageSqlId)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 37 29 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 37 29 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 129 8135540"); {
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 130 8135540"); 
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 131 8135540"); 
				e.printStackTrace();
			}
		} }
	}
	/**
	 * 判断变量是否为空
	 * 
	 * @param s
	 * @return
	 */
	public boolean isEmpty(String s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 134 8135540"); 
		int zoa_cond_n135_0 = 2;
int zoa_cond_n135_1 = 2;
int zoa_cond_n135_2 = 2;
int zoa_cond_n135_3 = 2;
//zoa_cond_n135_0#null == s$zoa_cond_n135_1#"".equals(s)$zoa_cond_n135_2#"".equals(s.trim())$zoa_cond_n135_3#"null".equalsIgnoreCase(s)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 135 8135540")|| true) && ((null == s?(zoa_cond_n135_0 != (zoa_cond_n135_0 = 1)):(zoa_cond_n135_0 == (zoa_cond_n135_0 = 0))) || ("".equals(s)?(zoa_cond_n135_1 != (zoa_cond_n135_1 = 1)):(zoa_cond_n135_1 == (zoa_cond_n135_1 = 0))) || ("".equals(s.trim())?(zoa_cond_n135_2 != (zoa_cond_n135_2 = 1)):(zoa_cond_n135_2 == (zoa_cond_n135_2 = 0))) || ("null".equalsIgnoreCase(s)?(zoa_cond_n135_3 != (zoa_cond_n135_3 = 1)):(zoa_cond_n135_3 == (zoa_cond_n135_3 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 42 30 1 4 ","8135540",true,zoa_cond_n135_0,zoa_cond_n135_1,zoa_cond_n135_2,zoa_cond_n135_3) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 42 30 0 4 ","8135540",false,zoa_cond_n135_0,zoa_cond_n135_1,zoa_cond_n135_2,zoa_cond_n135_3) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 136 8135540"); {
			return true;
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 137 8135540");  {
			return false;
		} }
	}
	
	public Map<String, Object> toHashMap(Object parameterObject) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 254 139 8135540"); 
		Map<String, Object> froMmap = (FormMap<String, Object>) parameterObject;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 140 8135540"); 
			String name = parameterObject.getClass().getName();
			Class<?> clazz = Class.forName(name);  
			boolean flag = clazz.isAnnotationPresent(TableSeg.class);  //某个类是不是存在TableSeg注解
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 141 8135540")|| true) && (flag? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 43 31 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 254 43 31 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 142 8135540"); {  
				TableSeg table = (TableSeg) clazz.getAnnotation(TableSeg.class);
				logger.info(" 公共方法被调用,传入参数 ==>> " + froMmap);
				froMmap.put("ly_table", table.tableName());
			} }else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 143 8135540"); {
				throw new NullPointerException("在"+name+" 没有找到数据库表对应该的注解!");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 144 8135540");
			return froMmap;
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 145 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 254 146 8135540");
		return froMmap;
	}
}
