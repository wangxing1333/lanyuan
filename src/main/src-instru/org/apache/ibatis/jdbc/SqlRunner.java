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

import org.apache.commons.lang.StringUtils;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class SqlRunner {
    public static final int NO_GENERATED_KEY = Integer.MIN_VALUE + 1001;
    private Connection connection;
    private TypeHandlerRegistry typeHandlerRegistry;
    private boolean useGeneratedKeySupport;

    public SqlRunner(Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 0 8135540"); 
        this.connection = connection;
        this.typeHandlerRegistry = new TypeHandlerRegistry();
    }

    public void setUseGeneratedKeySupport(boolean useGeneratedKeySupport) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 1 8135540"); 
        this.useGeneratedKeySupport = useGeneratedKeySupport;
    }

    /*
     * Executes a SELECT statement that returns one row.
     *
     * @param sql The SQL
     *
     * @param args The arguments to be set on the statement.
     *
     * @return The number of rows impacted or BATCHED_RESULTS if the statements
     * are being batched.
     *
     * @throws SQLException If more than one row is returned
     */
    public Map<String, Object> selectOne(String sql, Object... args)
        throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 2 8135540"); 
        List<Map<String, Object>> results = selectAll(sql, args);

        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 3 8135540")|| true) && (results.size() != 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 4 8135540"); {
            throw new SQLException("Statement returned " + results.size() +
                " results where exactly one (1) was expected.");
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 5 8135540");

        return results.get(0);
    }

    /*
     * Executes a SELECT statement that returns multiple rows.
     *
     * @param sql The SQL
     *
     * @param args The arguments to be set on the statement.
     *
     * @return The number of rows impacted or BATCHED_RESULTS if the statements
     * are being batched.
     *
     * @throws SQLException If statement prepration or execution fails
     */
    public List<Map<String, Object>> selectAll(String sql, Object... args)
        throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 6 8135540"); 
        PreparedStatement ps = connection.prepareStatement(sql);

        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 7 8135540"); 
            setParameters(ps, args);

            ResultSet rs = ps.executeQuery();

            return getResults(rs);
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 8 8135540"); 
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 9 8135540"); 
                ps.close();
            } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 10 8135540"); 
                // ignore
            }
        }
    }

    /*
     * Executes an INSERT statement.
     *
     * @param sql The SQL
     *
     * @param args The arguments to be set on the statement.
     *
     * @return The number of rows impacted or BATCHED_RESULTS if the statements
     * are being batched.
     *
     * @throws SQLException If statement prepration or execution fails
     */
    public int insert(String sql, Object... args) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 13 8135540"); 
        PreparedStatement ps;

        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 14 8135540")|| true) && (useGeneratedKeySupport? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 15 8135540"); {
            ps = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
        } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 16 8135540");  {
            ps = connection.prepareStatement(sql);
        } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 17 8135540");

        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 18 8135540"); 
            setParameters(ps, args);
            ps.executeUpdate();

            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 19 8135540")|| true) && (useGeneratedKeySupport? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 20 8135540"); {
                List<Map<String, Object>> keys = getResults(ps.getGeneratedKeys());

                if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 21 8135540")|| true) && (keys.size() == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 22 8135540"); {
                    Map<String, Object> key = keys.get(0);
                    Iterator<Object> i = key.values().iterator();

                    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 23 8135540")|| true) && (i.hasNext()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 24 8135540"); {
                        Object genkey = i.next();

                        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 25 8135540")|| true) && (genkey != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 26 8135540"); {
                            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 27 8135540"); 
                                return Integer.parseInt(genkey.toString());
                            } catch (NumberFormatException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 28 8135540"); 
                                // ignore, no numeric key suppot
                            }
                        } }
                    } }
                } }
            } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 33 8135540");

            return NO_GENERATED_KEY;
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 34 8135540"); 
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 35 8135540"); 
                ps.close();
            } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 36 8135540"); 
                // ignore
            }
        }
    }

    /*
     * Executes an UPDATE statement.
     *
     * @param sql The SQL
     *
     * @param args The arguments to be set on the statement.
     *
     * @return The number of rows impacted or BATCHED_RESULTS if the statements
     * are being batched.
     *
     * @throws SQLException If statement prepration or execution fails
     */
    public int update(String sql, Object... args) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 39 8135540"); 
        PreparedStatement ps = connection.prepareStatement(sql);

        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 40 8135540"); 
            setParameters(ps, args);

            return ps.executeUpdate();
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 41 8135540"); 
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 42 8135540"); 
                ps.close();
            } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 43 8135540"); 
                // ignore
            }
        }
    }

    /*
     * Executes a DELETE statement.
     *
     * @param sql The SQL
     *
     * @param args The arguments to be set on the statement.
     *
     * @return The number of rows impacted or BATCHED_RESULTS if the statements
     * are being batched.
     *
     * @throws SQLException If statement prepration or execution fails
     */
    public int delete(String sql, Object... args) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 46 8135540"); 
        return update(sql, args);
    }

    /*
     * Executes any string as a JDBC Statement. Good for DDL
     *
     * @param sql The SQL
     *
     * @throws SQLException If statement prepration or execution fails
     */
    public void run(String sql) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 47 8135540"); 
        Statement stmt = connection.createStatement();

        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 48 8135540"); 
            stmt.execute(sql);
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 49 8135540"); 
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 50 8135540"); 
                stmt.close();
            } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 51 8135540"); 
                // ignore
            }
        }
    }

    public void closeConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 54 8135540"); 
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 55 8135540"); 
            connection.close();
        } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 56 8135540"); 
            // ignore
        }
    }

    private void setParameters(PreparedStatement ps, Object... args)
        throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 58 8135540"); 
        for (int i = 0, n = args.length; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 59 8135540")|| true) && (i < n? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 6 6 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 60 8135540"); {
            if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 61 8135540")|| true) && (args[i] == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 7 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 62 8135540"); {
                throw new SQLException(
                    "SqlRunner requires an instance of Null to represent typed null values for JDBC compatibility");
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 63 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 64 8135540")|| true) && (args[i] instanceof Null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 65 8135540"); {
                ((Null) args[i]).getTypeHandler()
                 .setParameter(ps, i + 1, null, ((Null) args[i]).getJdbcType());
            } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 66 8135540");  {
                TypeHandler typeHandler = typeHandlerRegistry.getTypeHandler(args[i].getClass());

                if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 67 8135540")|| true) && (typeHandler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 68 8135540"); {
                    throw new SQLException(
                        "SqlRunner could not find a TypeHandler instance for " +
                        args[i].getClass());
                } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 69 8135540");  {
                    typeHandler.setParameter(ps, i + 1, args[i], null);
                } }
            } } }
        }}
    }

    private List<Map<String, Object>> getResults(ResultSet rs)
        throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 74 8135540"); 
        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 75 8135540"); 
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            List<String> columns = new ArrayList<String>();
            List<TypeHandler<?>> typeHandlers = new ArrayList<TypeHandler<?>>();
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 0, n = rsmd.getColumnCount(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 76 8135540")|| true) && (i < n? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 10 10 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 77 8135540"); {
                columns.add(rsmd.getColumnLabel(i + 1));

                try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 78 8135540"); 
                    Class<?> type = Resources.classForName(rsmd.getColumnClassName(i +
                                1));
                    TypeHandler<?> typeHandler = typeHandlerRegistry.getTypeHandler(type);

                    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 79 8135540")|| true) && (typeHandler == null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 80 8135540"); {
                        typeHandler = typeHandlerRegistry.getTypeHandler(Object.class);
                    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 81 8135540");

                    typeHandlers.add(typeHandler);
                } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 82 8135540"); 
                    typeHandlers.add(typeHandlerRegistry.getTypeHandler(
                            Object.class));
                }
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 84 8135540");

            while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 85 8135540")|| true) && (rs.next()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 12 12 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 86 8135540");  {
                Map<String, Object> row = new HashMap<String, Object>();

                for (int i = 0, n = columns.size(); (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 87 8135540")|| true) && (i < n? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 13 13 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 88 8135540"); {
                    String name = columns.get(i);
                    TypeHandler<?> handler = typeHandlers.get(i);
                    row.put(name.toUpperCase(Locale.ENGLISH),
                        handler.getResult(rs, name));
                }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 89 8135540");

                list.add(row);
            }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 90 8135540"); 

            return list;
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 91 8135540"); 
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 92 8135540"); 
                if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 93 8135540")|| true) && (rs != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 14 14 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 94 8135540"); {
                    rs.close();
                } }
            } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 96 8135540"); 
                // ignore
            }
        }
    }

    public static Map<String, Object> findByTablefield(Connection connection,
        BoundSql boundSql, String table) throws SQLException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 194 99 8135540"); 
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        String field = "";
        Map<String, Object> map = new HashMap<String, Object>();

        try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 100 8135540"); 
            String sql = Configuration.SHOW_COLUMNS_FROM + table;
            countStmt = connection.prepareStatement(sql);
            rs = countStmt.executeQuery();

            while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 101 8135540")|| true) && (rs.next()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 15 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 15 15 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 102 8135540");  {
                field += (rs.getString("Field") + ",");

                String column_key = rs.getString("Key");

                if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 103 8135540")|| true) && ("PRI".equals(column_key)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 16 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 194 16 16 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 104 8135540"); {
                    map.put(Configuration.COLUMN_KEY,
                        ResolverUtil.trimComma(field));
                } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 105 8135540");

                ;
            }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 106 8135540"); 

            map.put(Configuration.FIELD, ResolverUtil.trimComma(field));
            field = ResolverUtil.trimComma(field);
        } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 107 8135540"); 
            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 108 8135540"); 
                rs.close();
            } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 109 8135540"); 
            }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 110 8135540");

            try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 111 8135540"); 
                countStmt.close();
            } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 112 8135540"); 
            }
        }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 194 114 8135540");

        return map;
    }
}
