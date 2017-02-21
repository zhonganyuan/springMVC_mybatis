package com.wkb.core.logs;

import org.apache.log4j.Level;


/**
 * log4j日志级别
 * @author huanglt
 *
 */
public class Operate extends Level {

	private static final long serialVersionUID = 1L;

	protected Operate(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}
	
	/**
     * 定义log的权重为介于TRACE和ALL之间，便于打印OPERATE级别的log
     */
    public static final int OPERATE_INT = INFO_INT + 1;
 
    public static final Level OPERATE = new Operate(OPERATE_INT, "OPERATE", 10);
 
    public static Level toLevel(String logArgument) {
        if (logArgument != null && logArgument.toUpperCase().trim().equals("OPERATE")) {
            return OPERATE;
        }
        return (Level) toLevel(logArgument);
    }
 
    public static Level toLevel(int val) {
        if (val == OPERATE_INT) {
            return OPERATE;
        }
        return (Level) toLevel(val, Level.DEBUG);
    }
 
    public static Level toLevel(int val, Level defaultLevel) {
        if (val == OPERATE_INT) {
            return OPERATE;
        }
        return Level.toLevel(val, defaultLevel);
    }
 
    public static Level toLevel(String logArgument, Level defaultLevel) {
        if (logArgument != null && logArgument.toUpperCase().trim().equals("OPERATE")) {
            return OPERATE;
        }
        return Level.toLevel(logArgument, defaultLevel);
    }

}
