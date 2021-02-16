// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.plugin;

/**
 * sql2008数据库的实现
 * 2015-03-20
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SQLServer2008Dialect {
	private static final String SELECT = "select";
	private static final String FROM = "from";
	private static final String DISTINCT = "distinct";

	public String getTotalString(String sql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 0 8135540"); 
		StringBuilder sb = new StringBuilder(sql.trim().toLowerCase());
		int orderbyIndex = sb.indexOf("order by");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 1 8135540")|| true) && (orderbyIndex != -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 2 8135540"); {
			sb.delete(orderbyIndex, sb.length());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 3 8135540");
		sb.insert(0, "WITH query AS (").append(
				") SELECT count(*) total FROM query ");
		return sb.toString();
	}

	public String getLimitString(String sql, int offset, int limit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 4 8135540"); 
		int zoa_cond_n5_0 = 2;
int zoa_cond_n5_1 = 2;
//zoa_cond_n5_0#offset > 1$zoa_cond_n5_1#limit > 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 5 8135540")|| true) && ((offset > 1?(zoa_cond_n5_0 != (zoa_cond_n5_0 = 1)):(zoa_cond_n5_0 == (zoa_cond_n5_0 = 0))) || (limit > 1?(zoa_cond_n5_1 != (zoa_cond_n5_1 = 1)):(zoa_cond_n5_1 == (zoa_cond_n5_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 3 1 1 2 ","8135540",true,zoa_cond_n5_0,zoa_cond_n5_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 3 1 0 2 ","8135540",false,zoa_cond_n5_0,zoa_cond_n5_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 6 8135540");
			return getLimitString(sql, offset, limit, true); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 7 8135540");
		return sql;
	}

	/**
	 * Add a LIMIT clause to the given SQL SELECT (HHH-2655: ROW_NUMBER for
	 * Paging)
	 * 
	 * The LIMIT SQL will look like:
	 * 
	 * <pre>
	 * WITH query AS (
	 *   SELECT ROW_NUMBER() OVER (ORDER BY orderby) as __liud_row_nr__, 
	 *   original_query_without_orderby
	 * )
	 * SELECT * FROM query WHERE __liud_row_nr__ BEETWIN offset AND offset + last
	 * </pre>
	 * 
	 * 
	 * @param querySqlString
	 *            The SQL statement to base the limit query off of.
	 * @param offset
	 *            Offset of the first row to be returned by the query
	 *            (zero-based)
	 * @param limit
	 *            Maximum number of rows to be returned by the query
	 * 
	 * @return A new SQL statement with the LIMIT clause applied.
	 */
	private String getLimitString(String querySqlString, int offset, int limit,
			boolean hasOffset) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 8 8135540"); 
		StringBuilder sb = new StringBuilder(querySqlString.trim()
				.toLowerCase());

		int orderByIndex = sb.indexOf("order by");
		CharSequence orderby = orderByIndex > 0 ? sb.subSequence(orderByIndex,
				sb.length()) : "ORDER BY CURRENT_TIMESTAMP";

		// Delete the order by clause at the end of the query
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 9 8135540")|| true) && (orderByIndex > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 10 8135540"); {
			sb.delete(orderByIndex, orderByIndex + orderby.length());
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 11 8135540");

		// HHH-5715 bug fix
		replaceDistinctWithGroupBy(sb);

		insertRowNumberFunction(sb, orderby);

		// Wrap the query within a with statement:
		sb.insert(0, "WITH query AS (").append(") SELECT * FROM query ");
		sb.append("WHERE __liud_row_nr__ BETWEEN ").append(offset + 1)
				.append(" AND ").append(offset + limit);
		return sb.toString();
	}

	/**
	 * Right after the select statement of a given query we must place the
	 * row_number function
	 * 
	 * @param sql
	 *            the initial sql query without the order by clause
	 * @param orderby
	 *            the order by clause of the query
	 */
	protected static void insertRowNumberFunction(StringBuilder sql,
			CharSequence orderby) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 12 8135540"); 
		// Find the end of the select statement
		int selectEndIndex = sql.indexOf(SELECT) + SELECT.length();

		// Insert after the select statement the row_number() function:
		sql.insert(selectEndIndex, " ROW_NUMBER() OVER (" + orderby
				+ ") as __liud_row_nr__,");
	}

	/**
	 * Utility method that checks if the given sql query is a select distinct
	 * one and if so replaces the distinct select with an equivalent simple
	 * select with a group by clause. See
	 * {@link SQLServer2005DialectTestCase#testReplaceDistinctWithGroupBy()}
	 * 
	 * @param sql
	 *            an sql query
	 */
	protected static void replaceDistinctWithGroupBy(StringBuilder sql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 13 8135540"); 
		int distinctIndex = sql.indexOf(DISTINCT);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 14 8135540")|| true) && (distinctIndex > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 245 5 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 245 15 8135540"); {
			sql.delete(distinctIndex, distinctIndex + DISTINCT.length() + 1);
			sql.append(" group by").append(getSelectFieldsWithoutAliases(sql));
		} }
	}

	/**
	 * This utility method searches the given sql query for the fields of the
	 * select statement and returns them without the aliases. See
	 * {@link SQLServer2005DialectTestCase#testGetSelectFieldsWithoutAliases()}
	 * 
	 * @param an
	 *            sql query
	 * @return the fields of the select statement without their alias
	 */
	protected static CharSequence getSelectFieldsWithoutAliases(
			StringBuilder sql) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 17 8135540"); 
		String select = sql.substring(sql.indexOf(SELECT) + SELECT.length(),
				sql.indexOf(FROM));

		// Strip the as clauses
		return stripAliases(select);
	}

	/**
	 * Utility method that strips the aliases. See
	 * {@link SQLServer2005DialectTestCase#testStripAliases()}
	 * 
	 * @param a
	 *            string to replace the as statements
	 * @return a string without the as statements
	 */
	protected static String stripAliases(String str) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 245 18 8135540"); 
		return str.replaceAll("\\sas[^,]+(,?)", "$1");
	}
}

