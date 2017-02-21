package com.wkb.core.logs;

import org.apache.log4j.Priority;
import org.apache.log4j.jdbc.JDBCAppender;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.SQLException;  
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.spi.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 平台封装数据库appender
 * @author huanglt
 *
 */
public class WkbJDBCAppender extends JDBCAppender {

	private static final Pattern SQL_VALUE_PATTERN = Pattern.compile("'(.*?)'(?=\\s*[,)])", Pattern.MULTILINE);  
    private String jndiDataSource;  
    private static Logger logger=LoggerFactory.getLogger(WkbJDBCAppender.class);

	/** {@inheritDoc} */  
    @Override  
    protected Connection getConnection() throws SQLException {  
        if (jndiDataSource == null) {  
            return super.getConnection();  
        } else {  
            return lookupDataSource().getConnection();  
        }  
    }  
   
    /** 
     * Looks up the datasource in the naming context specified by the 
     * {@link #jndiDataSource}. 
     * 
     * @return the datasource. 
     */  
    private DataSource lookupDataSource() {  
        try {  
            Context context = new InitialContext();  
            return (DataSource) context.lookup(jndiDataSource);  
        } catch (NamingException e) {
        	logger.error(e.getMessage());
            throw new RuntimeException("Cannot find JNDI DataSource: " + jndiDataSource, e);  
        }  
    }  
   
    /** {@inheritDoc} */  
    @Override  
    protected void closeConnection(Connection con) {  
        try {  
            con.close();  
        } catch (SQLException e) {
        	logger.error(e.getMessage());
            errorHandler.error("Failed to close connection", e, ErrorCode.CLOSE_FAILURE);  
        }  
    }  
   
    /** 
     * Executes the specified SQL statement, by parsing its values and turning 
     * them into parameters, so that characters that must be escaped in a SQL 
     * statement are supported. 
     */  
    @Override  
    protected void execute(String sql) throws SQLException {  
        String statement = sql;  
        ArrayList<String> args = new ArrayList<String>();  
        Matcher m = SQL_VALUE_PATTERN.matcher(sql);  
        while (m.find()) {  
            args.add(m.group(1));  
            statement = statement.replace(m.group(), "?");  
        }  
   
        executeStatement(statement, args.toArray(new String[args.size()]));  
    }  
   
    /** 
     * Executes the statement settings its parameters to the specified arguments. 
     *  
     * @param statement 
     *            the statement to execute. 
     * @param args 
     *            the parameter values. 
     */  
    protected void executeStatement(String statement, String[] args) throws SQLException {  
        Connection con = getConnection();  
        con.setAutoCommit(false);
        PreparedStatement stmt = null;  
        try {  
            stmt = con.prepareStatement(statement);  
            for (int i = 0; i < args.length; i++) {  
                stmt.setString(i + 1, args[i]);  
            }  
            stmt.executeUpdate();  
            con.commit();
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        	con.rollback();
            if (stmt != null) {  
                stmt.close();  
            }  
            throw e;  
        }  
        stmt.close(); 
        closeConnection(con);  
    }  
    
    @Override
    public boolean isAsSevereAsThreshold(Priority priority){
    	return this.getThreshold().equals(priority);
    }
   
    public String getJndiDataSource() {  
        return jndiDataSource;  
    }  
   
    public void setJndiDataSource(String jndiDataSource) {  
        this.jndiDataSource = jndiDataSource;  
    }    
}
