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
package org.apache.ibatis.jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Clinton Begin
 * @author Jeff Butler
 * @author Adam Gent
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public abstract class AbstractSQL<T> {

	private static final String AND = ") \nAND (";
	private static final String OR = ") \nOR (";

	public abstract T getSelf();

	public T UPDATE(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 0 8135540"); 
		sql().statementType = SQLStatement.StatementType.UPDATE;
		sql().tables.add(table);
		return getSelf();
	}

	public T SET(String sets) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 1 8135540"); 
		sql().sets.add(sets);
		return getSelf();
	}

	public T INSERT_INTO(String tableName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 2 8135540"); 
		sql().statementType = SQLStatement.StatementType.INSERT;
		sql().tables.add(tableName);
		return getSelf();
	}

	public T VALUES(String columns, String values) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 3 8135540"); 
		sql().columns.add(columns);
		sql().values.add(values);
		return getSelf();
	}

	public T SELECT(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 4 8135540"); 
		sql().statementType = SQLStatement.StatementType.SELECT;
		sql().select.add(columns);
		return getSelf();
	}

	public T SELECT_DISTINCT(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 5 8135540"); 
		sql().distinct = true;
		SELECT(columns);
		return getSelf();
	}

	public T DELETE_FROM(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 6 8135540"); 
		sql().statementType = SQLStatement.StatementType.DELETE;
		sql().tables.add(table);
		return getSelf();
	}

	public T FROM(String table) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 7 8135540"); 
		sql().tables.add(table);
		return getSelf();
	}

	public T JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 8 8135540"); 
		sql().join.add(join);
		return getSelf();
	}

	public T INNER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 9 8135540"); 
		sql().innerJoin.add(join);
		return getSelf();
	}

	public T LEFT_OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 10 8135540"); 
		sql().leftOuterJoin.add(join);
		return getSelf();
	}

	public T RIGHT_OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 11 8135540"); 
		sql().rightOuterJoin.add(join);
		return getSelf();
	}

	public T OUTER_JOIN(String join) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 12 8135540"); 
		sql().outerJoin.add(join);
		return getSelf();
	}

	public T WHERE(String conditions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 13 8135540"); 
		sql().where.add(conditions);
		sql().lastList = sql().where;
		return getSelf();
	}

	public T OR() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 14 8135540"); 
		sql().lastList.add(OR);
		return getSelf();
	}

	public T AND() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 15 8135540"); 
		sql().lastList.add(AND);
		return getSelf();
	}

	public T GROUP_BY(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 16 8135540"); 
		sql().groupBy.add(columns);
		return getSelf();
	}

	public T HAVING(String conditions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 17 8135540"); 
		sql().having.add(conditions);
		sql().lastList = sql().having;
		return getSelf();
	}

	public T ORDER_BY(String columns) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 18 8135540"); 
		sql().orderBy.add(columns);
		return getSelf();
	}

	private SQLStatement sql = new SQLStatement();

	private SQLStatement sql() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 19 8135540"); 
		return sql;
	}

	public <A extends Appendable> A usingAppender(A a) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 20 8135540"); 
		sql().sql(a);
		return a;
	}

	@Override
	public String toString() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 21 8135540"); 
		StringBuilder sb = new StringBuilder();
		sql().sql(sb);
		return sb.toString();
	}

	private static class SafeAppendable {
		private final Appendable a;
		private boolean empty = true;

		public SafeAppendable(Appendable a) {
			super();
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 22 8135540"); 
			this.a = a;
		}

		public SafeAppendable append(CharSequence s) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 23 8135540"); 
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 24 8135540"); 
				int zoa_cond_n25_0 = 2;
int zoa_cond_n25_1 = 2;
//zoa_cond_n25_0#empty$zoa_cond_n25_1#s.length() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 25 8135540")|| true) && ((empty?(zoa_cond_n25_0 != (zoa_cond_n25_0 = 1)):(zoa_cond_n25_0 == (zoa_cond_n25_0 = 0))) && (s.length() > 0?(zoa_cond_n25_1 != (zoa_cond_n25_1 = 1)):(zoa_cond_n25_1 == (zoa_cond_n25_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 2 0 1 2 ","8135540",true,zoa_cond_n25_0,zoa_cond_n25_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 2 0 0 2 ","8135540",false,zoa_cond_n25_0,zoa_cond_n25_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 26 8135540");
					empty = false; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 27 8135540");
				a.append(s);
			} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 28 8135540"); 
				throw new RuntimeException(e);
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 29 8135540");
			return this;
		}

		public boolean isEmpty() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 30 8135540"); 
			return empty;
		}

	}

	private static class SQLStatement {

		public enum StatementType {
			DELETE, INSERT, SELECT, UPDATE
		}

		StatementType statementType;
		List<String> sets = new ArrayList<String>();
		List<String> select = new ArrayList<String>();
		List<String> tables = new ArrayList<String>();
		List<String> join = new ArrayList<String>();
		List<String> innerJoin = new ArrayList<String>();
		List<String> outerJoin = new ArrayList<String>();
		List<String> leftOuterJoin = new ArrayList<String>();
		List<String> rightOuterJoin = new ArrayList<String>();
		List<String> where = new ArrayList<String>();
		List<String> having = new ArrayList<String>();
		List<String> groupBy = new ArrayList<String>();
		List<String> orderBy = new ArrayList<String>();
		List<String> lastList = new ArrayList<String>();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		boolean distinct;

		private void sqlClause(SafeAppendable builder, String keyword,
				List<String> parts, String open, String close,
				String conjunction) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 31 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 32 8135540")|| true) && (!parts.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 3 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 3 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 33 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 34 8135540")|| true) && (!builder.isEmpty()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 4 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 35 8135540");
					builder.append("\n"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 36 8135540");
				builder.append(keyword);
				builder.append(" ");
				builder.append(open);
				String last = "________";
				for (int i = 0, n = parts.size(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 37 8135540")|| true) && (i < n? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 5 3 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 38 8135540"); {
					String part = parts.get(i);
					int zoa_cond_n39_0 = 2;
int zoa_cond_n39_1 = 2;
int zoa_cond_n39_2 = 2;
int zoa_cond_n39_3 = 2;
int zoa_cond_n39_4 = 2;
//zoa_cond_n39_0#i > 0$zoa_cond_n39_1#part.equals(AND)$zoa_cond_n39_2#part.equals(OR)$zoa_cond_n39_3#last.equals(AND)$zoa_cond_n39_4#last.equals(OR)
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 39 8135540")|| true) && ((i > 0?(zoa_cond_n39_0 != (zoa_cond_n39_0 = 1)):(zoa_cond_n39_0 == (zoa_cond_n39_0 = 0))) && !(part.equals(AND)?(zoa_cond_n39_1 != (zoa_cond_n39_1 = 1)):(zoa_cond_n39_1 == (zoa_cond_n39_1 = 0))) && !(part.equals(OR)?(zoa_cond_n39_2 != (zoa_cond_n39_2 = 1)):(zoa_cond_n39_2 == (zoa_cond_n39_2 = 0)))
							&& !(last.equals(AND)?(zoa_cond_n39_3 != (zoa_cond_n39_3 = 1)):(zoa_cond_n39_3 == (zoa_cond_n39_3 = 0))) && !(last.equals(OR)?(zoa_cond_n39_4 != (zoa_cond_n39_4 = 1)):(zoa_cond_n39_4 == (zoa_cond_n39_4 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 11 4 1 5 ","8135540",true,zoa_cond_n39_0,zoa_cond_n39_1,zoa_cond_n39_2,zoa_cond_n39_3,zoa_cond_n39_4) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 11 4 0 5 ","8135540",false,zoa_cond_n39_0,zoa_cond_n39_1,zoa_cond_n39_2,zoa_cond_n39_3,zoa_cond_n39_4) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 40 8135540"); {
						builder.append(conjunction);
					} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 41 8135540");
					builder.append(part);
					last = part;
				}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 42 8135540");
				builder.append(close);
			} }
		}

		private String selectSQL(SafeAppendable builder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 44 8135540"); 
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 45 8135540")|| true) && (distinct? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 12 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 12 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 46 8135540"); {
				sqlClause(builder, "SELECT DISTINCT", select, "", "", ", ");
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 47 8135540");  {
				sqlClause(builder, "SELECT", select, "", "", ", ");
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 48 8135540");

			sqlClause(builder, "FROM", tables, "", "", ", ");
			sqlClause(builder, "JOIN", join, "", "", "\nJOIN ");
			sqlClause(builder, "INNER JOIN", innerJoin, "", "", "\nINNER JOIN ");
			sqlClause(builder, "OUTER JOIN", outerJoin, "", "", "\nOUTER JOIN ");
			sqlClause(builder, "LEFT OUTER JOIN", leftOuterJoin, "", "",
					"\nLEFT OUTER JOIN ");
			sqlClause(builder, "RIGHT OUTER JOIN", rightOuterJoin, "", "",
					"\nRIGHT OUTER JOIN ");
			sqlClause(builder, "WHERE", where, "(", ")", " AND ");
			sqlClause(builder, "GROUP BY", groupBy, "", "", ", ");
			sqlClause(builder, "HAVING", having, "(", ")", " AND ");
			sqlClause(builder, "ORDER BY", orderBy, "", "", ", ");
			return builder.toString();
		}

		private String insertSQL(SafeAppendable builder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 49 8135540"); 
			sqlClause(builder, "INSERT INTO", tables, "", "", "");
			sqlClause(builder, "", columns, "(", ")", ", ");
			sqlClause(builder, "VALUES", values, "(", ")", ", ");
			return builder.toString();
		}

		private String deleteSQL(SafeAppendable builder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 50 8135540"); 
			sqlClause(builder, "DELETE FROM", tables, "", "", "");
			sqlClause(builder, "WHERE", where, "(", ")", " AND ");
			return builder.toString();
		}

		private String updateSQL(SafeAppendable builder) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 51 8135540"); 

			sqlClause(builder, "UPDATE", tables, "", "", "");
			sqlClause(builder, "SET", sets, "", "", ", ");
			sqlClause(builder, "WHERE", where, "(", ")", " AND ");
			return builder.toString();
		}

		public String sql(Appendable a) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 213 52 8135540"); 
			SafeAppendable builder = new SafeAppendable(a);
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 53 8135540")|| true) && (statementType == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 13 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 213 13 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 54 8135540"); {
				return null;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 55 8135540");

			String answer;

			 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 56 8135540");switch (statementType) {
			case DELETE:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 58 8135540");
				answer = deleteSQL(builder);
				break;

			case INSERT:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 60 8135540");
				answer = insertSQL(builder);
				break;

			case SELECT:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 62 8135540");
				answer = selectSQL(builder);
				break;

			case UPDATE:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 64 8135540");
				answer = updateSQL(builder);
				break;

			default:
 ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 66 8135540");
				answer = null;
			}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 213 67 8135540");

			return answer;
		}
	}
}