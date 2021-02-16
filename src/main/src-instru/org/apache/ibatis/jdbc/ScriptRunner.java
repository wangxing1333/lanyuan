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

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Clinton Begin
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ScriptRunner {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

  private static final String DEFAULT_DELIMITER = ";";

  private Connection connection;

  private boolean stopOnError;
  private boolean autoCommit;
  private boolean sendFullScript;
  private boolean removeCRs;
  private boolean escapeProcessing = true;

  private PrintWriter logWriter = new PrintWriter(System.out);
  private PrintWriter errorLogWriter = new PrintWriter(System.err);

  private String delimiter = DEFAULT_DELIMITER;
  private boolean fullLineDelimiter = false;

  public ScriptRunner(Connection connection) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 0 8135540"); 
    this.connection = connection;
  }

  public void setStopOnError(boolean stopOnError) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 1 8135540"); 
    this.stopOnError = stopOnError;
  }

  public void setAutoCommit(boolean autoCommit) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 2 8135540"); 
    this.autoCommit = autoCommit;
  }

  public void setSendFullScript(boolean sendFullScript) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 3 8135540"); 
    this.sendFullScript = sendFullScript;
  }

  public void setRemoveCRs(boolean removeCRs) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 4 8135540"); 
    this.removeCRs = removeCRs;
  }

  /**
   * @since 3.1.1
   */
  public void setEscapeProcessing(boolean escapeProcessing) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 5 8135540"); 
    this.escapeProcessing = escapeProcessing;
  }

  public void setLogWriter(PrintWriter logWriter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 6 8135540"); 
    this.logWriter = logWriter;
  }

  public void setErrorLogWriter(PrintWriter errorLogWriter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 7 8135540"); 
    this.errorLogWriter = errorLogWriter;
  }

  public void setDelimiter(String delimiter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 8 8135540"); 
    this.delimiter = delimiter;
  }

  public void setFullLineDelimiter(boolean fullLineDelimiter) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 9 8135540"); 
    this.fullLineDelimiter = fullLineDelimiter;
  }

  public void runScript(Reader reader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 10 8135540"); 
    setAutoCommit();

    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 11 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 12 8135540")|| true) && (sendFullScript? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 13 8135540"); {
        executeFullScript(reader);
      } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 14 8135540");  {
        executeLineByLine(reader);
      } }
    } finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 16 8135540"); 
      rollbackConnection();
    }
  }

  private void executeFullScript(Reader reader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 18 8135540"); 
    StringBuilder script = new StringBuilder();
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 19 8135540"); 
      BufferedReader lineReader = new BufferedReader(reader);
      String line;
      while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 20 8135540")|| true) && ((line = lineReader.readLine()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 1 1 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 21 8135540");  {
        script.append(line);
        script.append(LINE_SEPARATOR);
      }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 22 8135540"); 
      executeStatement(script.toString());
      commitConnection();
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 23 8135540"); 
      String message = "Error executing: " + script + ".  Cause: " + e;
      printlnError(message);
      throw new RuntimeSqlException(message, e);
    }
  }

  private void executeLineByLine(Reader reader) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 25 8135540"); 
    StringBuilder command = new StringBuilder();
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 26 8135540"); 
      BufferedReader lineReader = new BufferedReader(reader);
      String line;
      while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 27 8135540")|| true) && ((line = lineReader.readLine()) != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 2 2 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 28 8135540");  {
        command = handleLine(command, line);
      }}ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 29 8135540"); 
      commitConnection();
      checkForMissingLineTerminator(command);
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 30 8135540"); 
      String message = "Error executing: " + command + ".  Cause: " + e;
      printlnError(message);
      throw new RuntimeSqlException(message, e);
    }
  }

  public void closeConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 32 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 33 8135540"); 
      connection.close();
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 34 8135540"); 
      // ignore
    }
  }

  private void setAutoCommit() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 36 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 37 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 38 8135540")|| true) && (autoCommit != connection.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 39 8135540"); {
        connection.setAutoCommit(autoCommit);
      } }
    } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 41 8135540"); 
      throw new RuntimeSqlException("Could not set AutoCommit to " + autoCommit + ". Cause: " + t, t);
    }
  }

  private void commitConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 43 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 44 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 45 8135540")|| true) && (!connection.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 46 8135540"); {
        connection.commit();
      } }
    } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 48 8135540"); 
      throw new RuntimeSqlException("Could not commit transaction. Cause: " + t, t);
    }
  }

  private void rollbackConnection() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 50 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 51 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 52 8135540")|| true) && (!connection.getAutoCommit()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 53 8135540"); {
        connection.rollback();
      } }
    } catch (Throwable t) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 55 8135540"); 
      // ignore
    }
  }

  private void checkForMissingLineTerminator(StringBuilder command) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 57 8135540"); 
    int zoa_cond_n58_0 = 2;
int zoa_cond_n58_1 = 2;
//zoa_cond_n58_0#command != null$zoa_cond_n58_1#command.toString().trim().length() > 0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 58 8135540")|| true) && ((command != null?(zoa_cond_n58_0 != (zoa_cond_n58_0 = 1)):(zoa_cond_n58_0 == (zoa_cond_n58_0 = 0))) && (command.toString().trim().length() > 0?(zoa_cond_n58_1 != (zoa_cond_n58_1 = 1)):(zoa_cond_n58_1 == (zoa_cond_n58_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 8 6 1 2 ","8135540",true,zoa_cond_n58_0,zoa_cond_n58_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 8 6 0 2 ","8135540",false,zoa_cond_n58_0,zoa_cond_n58_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 59 8135540"); {
      throw new RuntimeSqlException("Line missing end-of-line terminator (" + delimiter + ") => " + command);
    } }
  }

  private StringBuilder handleLine(StringBuilder command, String line) throws SQLException, UnsupportedEncodingException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 61 8135540"); 
    String trimmedLine = line.trim();
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 62 8135540")|| true) && (lineIsComment(trimmedLine)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 9 7 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 63 8135540"); {
      println(trimmedLine);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 64 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 65 8135540")|| true) && (commandReadyToExecute(trimmedLine)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 10 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 66 8135540"); {
      command.append(line.substring(0, line.lastIndexOf(delimiter)));
      command.append(LINE_SEPARATOR);
      println(command);
      executeStatement(command.toString());
      command.setLength(0);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 67 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 68 8135540")|| true) && (trimmedLine.length() > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 11 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 69 8135540"); {
      command.append(line);
      command.append(LINE_SEPARATOR);
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 70 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 71 8135540"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 72 8135540");
    return command;
  }

  private boolean lineIsComment(String trimmedLine) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 73 8135540"); 
    return trimmedLine.startsWith("//") || trimmedLine.startsWith("--");
  }

  private boolean commandReadyToExecute(String trimmedLine) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 74 8135540"); 
    // issue #561 remove anything after the delimiter
    return !fullLineDelimiter && trimmedLine.contains(delimiter) || fullLineDelimiter && trimmedLine.equals(delimiter);
  }

  private void executeStatement(String command) throws SQLException, UnsupportedEncodingException {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 75 8135540"); 
    boolean hasResults = false;
    Statement statement = connection.createStatement();
    statement.setEscapeProcessing(escapeProcessing);
    String sql = command;
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 76 8135540")|| true) && (removeCRs? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 77 8135540");
      sql = sql.replaceAll("\r\n", "\n"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 78 8135540");
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 79 8135540")|| true) && (stopOnError? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 13 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 13 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 80 8135540"); {
      hasResults = statement.execute(sql);
    } } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 81 8135540");  {
      try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 82 8135540"); 
        hasResults = statement.execute(sql);
      } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 83 8135540"); 
        String message = "Error executing: " + command + ".  Cause: " + e;
        printlnError(message);
      }
    } }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 85 8135540");
    printResults(statement, hasResults);
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 86 8135540"); 
      statement.close();
    } catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 87 8135540"); 
      // Ignore to workaround a bug in some connection pools
    }
  }

  private void printResults(Statement statement, boolean hasResults) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 89 8135540"); 
    try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 90 8135540"); 
      if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 91 8135540")|| true) && (hasResults? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 14 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 14 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 92 8135540"); {
        ResultSet rs = statement.getResultSet();
        if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 93 8135540")|| true) && (rs != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 15 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 15 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 94 8135540"); {
          ResultSetMetaData md = rs.getMetaData();
          int cols = md.getColumnCount();
          for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 95 8135540")|| true) && (i < cols? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 16 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 16 14 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 96 8135540"); {
            String name = md.getColumnLabel(i + 1);
            print(name + "\t");
          }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 97 8135540");
          println("");
          while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 98 8135540")|| true) && (rs.next()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 17 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 17 15 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 99 8135540");  {
            for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 100 8135540")|| true) && (i < cols? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 18 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 18 16 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 101 8135540"); {
              String value = rs.getString(i + 1);
              print(value + "\t");
            }}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 102 8135540");
            println("");
          }}
        } }
      } }
    } catch (SQLException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 106 8135540"); 
      printlnError("Error printing results: " + e.getMessage());
    }
  }

  private void print(Object o) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 108 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 109 8135540")|| true) && (logWriter != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 19 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 19 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 110 8135540"); {
      logWriter.print(o);
      logWriter.flush();
    } }
  }

  private void println(Object o) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 112 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 113 8135540")|| true) && (logWriter != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 20 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 20 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 114 8135540"); {
      logWriter.println(o);
      logWriter.flush();
    } }
  }

  private void printlnError(Object o) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 167 116 8135540"); 
    if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 117 8135540")|| true) && (errorLogWriter != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 21 19 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 167 21 19 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 167 118 8135540"); {
      errorLogWriter.println(o);
      errorLogWriter.flush();
    } }
  }

}
