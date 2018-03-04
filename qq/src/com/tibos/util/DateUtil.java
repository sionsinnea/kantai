package com.tibos.util;

import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.GregorianCalendar;  
  
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
  
/** 
 *  
 * <p> 
 * description:ʱ���ȡ��ת�������� 
 * </p> 
 *  
 * @author 
 * @since 2015-10-28 
 * @see 
 */  
public class DateUtil {  
    private static final long serialVersionUID = 7867268199240522574L;  
  
    private static final Log logger = LogFactory.getLog(DateUtil.class);  
  
    private static final int[] dayArray = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };  
  
    private static SimpleDateFormat sdf = new SimpleDateFormat();  
  
    public static Calendar getCalendar() {  
        return GregorianCalendar.getInstance();  
    }  
  
    /** 
     * �õ���ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     * @return String �õ���ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     */  
    public static String getDateMilliFormat() {  
        Calendar cal = Calendar.getInstance();  
        return getDateMilliFormat(cal);  
    }  
  
    /** 
     * �õ���ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     * @param cal Calendar 
     * @return String ��ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     */  
    public static String getDateMilliFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * �õ���ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     * @param date Date 
     * @return String ��ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     */  
    public static String getDateMilliFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ����ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ���ת��ΪCalendar���� 
     * @param strDate ��ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarMilliFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /**  
     * ����ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ���ת��ΪDate���� 
     * @param strDate ��ʽΪyyyy-MM-dd HH:mm:ss,SSS��ʱ���ַ��� 
     * @return java.util.Date 
     */  
    public static Date parseDateMilliFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * ���ʱ���ʽΪyyyy-MM-dd HH:mm:ss���ַ��� 
     * @return String ���ʱ���ʽΪyyyy-MM-dd HH:mm:ss���ַ��� 
     */  
    public static String getDateSecondFormat() {  
        Calendar cal = Calendar.getInstance();  
        return getDateSecondFormat(cal);  
    }  
  
    /** 
     * ���ʱ���ʽΪyyyy-MM-dd HH:mm:ss���ַ��� 
     * @param cal Calendar 
     * @return String ���ʱ���ʽΪyyyy-MM-dd HH:mm:ss���ַ��� 
     */  
    public static String getDateSecondFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * ���ʱ���ʽΪyyyy-MM-dd HH:mm:ss���ַ��� 
     * @param date Date 
     * @return String ���ʱ���ʽΪyyyy-MM-dd HH:mm:ss���ַ��� 
     */  
    public static String getDateSecondFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ����ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ���ת��ΪCalendar���� 
     * @param strDate ��ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ��� 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarSecondFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /** 
     * ����ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ���ת��ΪDate���� 
     * @param strDate ��ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ��� 
     * @return java.util.Date 
     */  
    public static Date parseDateSecondFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * ���ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     * @return String ���ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     */  
    public static String getDateMinuteFormat() {  
        Calendar cal = Calendar.getInstance();  
        return getDateMinuteFormat(cal);  
    }  
  
    /** 
     * ���ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     * @param cal Calendar 
     * @return String ���ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     */  
    public static String getDateMinuteFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd HH:mm";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * ���ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     * @param date Date 
     * @return String ���ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     */  
    public static String getDateMinuteFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd HH:mm";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ��ʱ���ַ���(��ʽ��yyyy-MM-dd HH:mm)ת��ΪCalendar���� 
     * @param strDate  ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarMinuteFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /** 
     * ��ʱ���ַ���(��ʽ��yyyy-MM-dd HH:mm)ת��ΪDate���� 
     * @param strDate ʱ���ʽΪyyyy-MM-dd HH:mm���ַ��� 
     * @return java.util.Date 
     */  
    public static Date parseDateMinuteFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * �����ʽΪyyyy-MM-ddʱ���ַ��� 
     * @return String �����ʽΪyyyy-MM-ddʱ���ַ��� 
     */  
    public static String getDateDayFormat() {  
        Calendar cal = Calendar.getInstance();  
        return getDateDayFormat(cal);  
    }  
  
    /** 
     * ��Calendar����ת����String(yyyy-MM-dd)���� 
     * @param cal 
     * @return String �����ʽΪyyyy-MM-ddʱ���ַ��� 
     */  
    public static String getDateDayFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * ��Date����ת����String(yyyy-MM-dd)���� 
     * @param date 
     * @return String �����ʽΪyyyy-MM-ddʱ���ַ��� 
     */  
    public static String getDateDayFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ��ʱ���ʽ���ַ���ת����Calendar���� 
     * @param strDate ʱ���ʽΪ:yyyy-MM-dd���ַ��� 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarDayFormat(String strDate) {  
        if (strDate == null || strDate.trim().length() == 0) {  
            return null;  
        }  
        String pattern = "yyyy-MM-dd";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /** 
     * ��ʱ���ʽ���ַ���ת����Date���� 
     * @param strDate ʱ���ʽΪ:yyyy-MM-dd���ַ��� 
     * @return java.util.Date 
     */  
    public static Date parseDateDayFormat(String strDate) {  
        if (strDate == null || strDate.trim().length() == 0) {  
            return null;  
        }  
        String pattern = "yyyy-MM-dd";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * ���ʱ���ʽyyyy-MM-dd_HH-mm-ss 
     * @return String ���ʱ���ʽyyyy-MM-dd_HH-mm-ss 
     */  
    public static String getDateFileFormat() {  
        Calendar cal = Calendar.getInstance();  
        return getDateFileFormat(cal);  
    }  
  
    /** 
     * ���ʱ���ʽyyyy-MM-dd_HH-mm-ss 
     * @param cal 
     * @return String ���ʱ���ʽyyyy-MM-dd_HH-mm-ss 
     */  
    public static String getDateFileFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd_HH-mm-ss";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * ���ʱ���ʽyyyy-MM-dd_HH-mm-ss 
     * @param date 
     * @return String ���ʱ���ʽyyyy-MM-dd_HH-mm-ss 
     */  
    public static String getDateFileFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd_HH-mm-ss";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ����ʽΪyyyy-MM-dd_HH-mm-ssʱ���ַ���ת��ΪCalendar���� 
     * @param strDate ��ʽΪyyyy-MM-dd_HH-mm-ss��ʱ���ַ��� 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarFileFormat(String strDate) {  
        String pattern = "yyyy-MM-dd_HH-mm-ss";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /** 
     * ����ʽΪyyyy-MM-dd_HH-mm-ssʱ���ַ���ת��ΪDate���� 
     * @param strDate ��ʽΪyyyy-MM-dd_HH-mm-ss��ʱ���ַ��� 
     * @return java.util.Date 
     */  
    public static Date parseDateFileFormat(String strDate) {  
        String pattern = "yyyy-MM-dd_HH-mm-ss";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * �õ�ʱ���ַ�������ʽΪyyyy-MM-dd HH:mm:ss 
     * @return String ��ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ��� 
     */  
    public static String getDateW3CFormat() {  
        Calendar cal = Calendar.getInstance();  
        return getDateW3CFormat(cal);  
    }  
  
    /** 
     * ����ʱ��(Calendar)���͵õ�ʱ���ַ�������ʽΪyyyy-MM-dd HH:mm:ss,������Զ����ʽ��ο�getDateFormat���� 
     * @param cal Calendar 
     * @return String ��ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ��� 
     */  
    public static String getDateW3CFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * ����ʱ��(Date)���͵õ�ʱ���ַ�������ʽΪyyyy-MM-dd HH:mm:ss,������Զ����ʽ��ο�getDateFormat���� 
     * @param date Date 
     * @return String ��ʽΪyyyy-MM-dd HH:mm:ss��ʱ���ַ��� 
     */  
    public static String getDateW3CFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ����ʱ���ַ����õ�Date����ʱ�䣬��ʽ��pattern��yyyy-MM-dd HH:mm:ss 
     * @param strDate ʱ���ַ���,����Ϊyyyy-MM-dd HH:mm:ss��ʽ 
     * @return java.util.Calendar ʱ�� 
     */  
    public static Calendar parseCalendarW3CFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /** 
     * ����ʱ���ַ����õ�Date����ʱ�䣬��ʽ��pattern��yyyy-MM-dd HH:mm:ss 
     * @param strDate ʱ���ַ���,����Ϊyyyy-MM-dd HH:mm:ss��ʽ 
     * @return java.util.Date ʱ�� 
     */  
    public static Date parseDateW3CFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * ����ʱ��(Calendar)���͵õ�ʱ���ַ�������ʽΪyyyy-MM-dd HH:mm:ss,������Զ����ʽ��ο�getDateFormat���� 
     * @param cal Calendar 
     * @return String �����ַ��� 
     */  
    public static String getDateFormat(java.util.Calendar cal) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return getDateFormat(cal, pattern);  
    }  
  
    /** 
     * ����ʱ��(Date)���͵õ�ʱ���ַ�����Ĭ�ϸ�ʽΪyyyy-MM-dd HH:mm:ss,������Զ����ʽ��ο�getDateFormat���� 
     * @param date Date�������� 
     * @return String �����ַ��� 
     */  
    public static String getDateFormat(java.util.Date date) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return getDateFormat(date, pattern);  
    }  
  
    /** 
     * ����ʱ���ַ���ת��ΪCalendarʱ������,ʱ���ַ�����ʽΪyyyy-MM-dd HH:mm:ss 
     * @param strDate strDate ʱ���ַ���,����Ϊyyyy-MM-dd HH:mm:ss��ʽ 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return parseCalendarFormat(strDate, pattern);  
    }  
  
    /** 
     * ����ʱ���ַ���ת��ΪDateʱ������,ʱ���ַ�����ʽΪyyyy-MM-dd HH:mm:ss 
     * @param strDate ʱ���ַ���,����Ϊyyyy-MM-dd HH:mm:ss��ʽ 
     * @return java.util.Date 
     */  
    public static Date parseDateFormat(String strDate) {  
        String pattern = "yyyy-MM-dd HH:mm:ss";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    /** 
     * ��������(Calendar)�����ڸ�ʽ���ض�Ӧ���ַ��� 
     * @param cal Calendar���� 
     * @param pattern ��������ڸ�ʽ(���磺yyyy-MM-dd HH:mm:ss) 
     * @return String �����ַ��� 
     */  
    public static String getDateFormat(java.util.Calendar cal, String pattern) {  
        return getDateFormat(cal.getTime(), pattern);  
    }  
  
    /** 
     * ��������(Date)�����ڸ�ʽ���ض�Ӧ���ַ��� 
     * @param date Date�������� 
     * @param pattern ��������ڸ�ʽ(���磺yyyy-MM-dd HH:mm:ss) 
     * @return String �����ַ��� 
     */  
    public static String getDateFormat(java.util.Date date, String pattern) {  
        if (date == null)  
            return null;  
        synchronized (sdf) {  
            String str = null;  
            sdf.applyPattern(pattern);  
            str = sdf.format(date);  
            return str;  
        }  
    }  
  
    /** 
     * ����ʱ���ַ����Ͷ�Ӧ�ĸ�ʽ���ʱ��(Calendar)����,���ʱ���ַ����͸�ʽ��ƥ��������쳣 
     * @param strDate ʱ���ַ��� 
     * @param pattern ʱ���ַ�����Ӧ�ĸ�ʽpattern 
     * @return java.util.Calendar 
     */  
    public static Calendar parseCalendarFormat(String strDate, String pattern) {  
        synchronized (sdf) {  
            Calendar cal = null;  
            sdf.applyPattern(pattern);  
            try {  
                sdf.parse(strDate);  
                cal = sdf.getCalendar();  
            } catch (Exception e) {  
                logger.error("DateUtil", e);  
            }  
            return cal;  
        }  
    }  
  
    /** 
     * ����ʱ���ַ����Ͷ�Ӧ�ĸ�ʽ���ʱ��(Date)����,���ʱ���ַ����͸�ʽ��ƥ��������쳣 
     * @param strDate ʱ���ַ��� 
     * @param pattern ʱ���ַ�����Ӧ�ĸ�ʽpattern 
     * @return java.util.Date 
     */  
    public static Date parseDateFormat(String strDate, String pattern) {  
        if (strDate == null || strDate.trim().length() == 0) {  
            return null;  
        }  
        synchronized (sdf) {  
            StringBuffer datebuf = new StringBuffer();  
            datebuf.append(strDate);  
            if (strDate.length() == 10) {  
                datebuf.deleteCharAt(7);  
                datebuf.deleteCharAt(4);  
            }  
  
            Date date = null;  
            sdf.applyPattern(pattern);  
            try {  
                date = sdf.parse(datebuf.toString());  
            } catch (Exception e) {  
                logger.error("DateUtil", e);  
            }  
            return date;  
        }  
    }  
    /** 
     * �õ����������·ݵ����һ���������˵��2�������򷵻�29��2��ƽ���򷵻�28�� 
     *@param month �·� 
     *@return int ����·ݵ����һ����������·ݲ������򷵻�-1 
     */  
    public static int getLastDayOfMonth(int month) {  
        if (month < 1 || month > 12) {  
            return -1;  
        }  
        int retn = 0;  
        if (month == 2) {  
            if (isLeapYear()) {  
                retn = 29;  
            } else {  
                retn = dayArray[month - 1];  
            }  
        } else {  
            retn = dayArray[month - 1];  
        }  
        return retn;  
    }  
    /** 
     * �õ������������·ݵ����һ���������˵��2�������򷵻�29��2��ƽ���򷵻�28�� 
     *@param year �� 
     *@param month �� 
     *@return int ��һ������·ݵ����һ����������·ݲ������򷵻�-1 
     */  
    public static int getLastDayOfMonth(int year, int month) {  
        if (month < 1 || month > 12) {  
            return -1;  
        }  
        int retn = 0;  
        if (month == 2) {  
            if (isLeapYear(year)) {  
                retn = 29;  
            } else {  
                retn = dayArray[month - 1];  
            }  
        } else {  
            retn = dayArray[month - 1];  
        }  
        return retn;  
    }  
    /** 
     * �ж��Ƿ������꣬����������򷵻�true���򷵻�FALSE 
     *@return Boolean ����������򷵻�true���򷵻�FALSE 
     */  
    public static boolean isLeapYear() {  
        Calendar cal = Calendar.getInstance();  
        int year = cal.get(Calendar.YEAR);  
        return isLeapYear(year);  
    }  
  
    /** 
     * �ж��Ƿ������꣬����������򷵻�true���򷵻�FALSE 
     *@param year �� 
     *@return ����������򷵻�true���򷵻�FALSE 
     */  
    public static boolean isLeapYear(int year) {  
        /** 
         * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������ 
         * 3.�ܱ�4����ͬʱ�ܱ�100������������ 
         */  
        if ((year % 400) == 0)  
            return true;  
        else if ((year % 4) == 0) {  
            if ((year % 100) == 0)  
                return false;  
            else  
                return true;  
        } else  
            return false;  
    }  
  
    /** 
     * �ж�ָ�����ڵ�����Ƿ������� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return �Ƿ�����, ����������򷵻�true���򷵻�FALSE 
     */  
    public static boolean isLeapYear(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������ 
         * 3.�ܱ�4����ͬʱ�ܱ�100������������ 
         */  
        // int year = date.getYear();  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        int year = gc.get(Calendar.YEAR);  
        return isLeapYear(year);  
    }  
    /** 
     * �ж�ָ�����ڵ�����Ƿ������� 
     *  
     * @param Calendar 
     *            ָ�����ڡ� 
     * @return �Ƿ�����, ����������򷵻�true���򷵻�FALSE 
     */  
    public static boolean isLeapYear(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.��400���������꣬���� 2.���ܱ�4������������ 3.�ܱ�4����ͬʱ���ܱ�100������������ 
         * 3.�ܱ�4����ͬʱ�ܱ�100������������ 
         */  
        int year = gc.get(Calendar.YEAR);  
        return isLeapYear(year);  
    }  
  
    /** 
     * �õ�ָ�����ڵ�ǰһ�������� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ�ǰһ�������� 
     */  
    public static java.util.Date getPreviousWeekDay(java.util.Date date) {  
        {  
            /** 
             * ��ϸ��ƣ� 1.���date�������գ����3�� 2.���date�������������2�� 3.�����1�� 
             */  
            GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
            gc.setTime(date);  
            return getPreviousWeekDay(gc);  
        }  
    }  
  
    public static java.util.Date getPreviousWeekDay(java.util.Calendar gc) {  
        {  
            /** 
             * ��ϸ��ƣ� 1.���date�������գ����3�� 2.���date�������������2�� 3.�����1�� 
             */  
            switch (gc.get(Calendar.DAY_OF_WEEK)) {  
                case (Calendar.MONDAY):  
                    gc.add(Calendar.DATE, -3);  
                    break;  
                case (Calendar.SUNDAY):  
                    gc.add(Calendar.DATE, -2);  
                    break;  
                default:  
                    gc.add(Calendar.DATE, -1);  
                    break;  
            }  
            return gc.getTime();  
        }  
    }  
  
    /** 
     * �õ�ָ�����ڵĺ�һ�������� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵĺ�һ�������� 
     */  
    public static java.util.Date getNextWeekDay(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.���date�������壬���3�� 2.���date�������������2�� 3.�����1�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        switch (gc.get(Calendar.DAY_OF_WEEK)) {  
            case (Calendar.FRIDAY):  
                gc.add(Calendar.DATE, 3);  
                break;  
            case (Calendar.SATURDAY):  
                gc.add(Calendar.DATE, 2);  
                break;  
            default:  
                gc.add(Calendar.DATE, 1);  
                break;  
        }  
        return gc.getTime();  
    }  
  
    public static java.util.Calendar getNextWeekDay(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.���date�������壬���3�� 2.���date�������������2�� 3.�����1�� 
         */  
        switch (gc.get(Calendar.DAY_OF_WEEK)) {  
            case (Calendar.FRIDAY):  
                gc.add(Calendar.DATE, 3);  
                break;  
            case (Calendar.SATURDAY):  
                gc.add(Calendar.DATE, 2);  
                break;  
            default:  
                gc.add(Calendar.DATE, 1);  
                break;  
        }  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ���һ���µ����һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ���µ����һ�� 
     */  
    public static java.util.Date getLastDayOfNextMonth(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ����������getLastDayOfMonth 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.setTime(DateUtil.getNextMonth(gc.getTime()));  
        gc.setTime(DateUtil.getLastDayOfMonth(gc.getTime()));  
        return gc.getTime();  
    }  
  
    /** 
     * ȡ��ָ�����ڵ���һ�����ڵ����һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ�����ڵ����һ�� 
     */  
    public static java.util.Date getLastDayOfNextWeek(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ����������getLastDayOfWeek 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.setTime(DateUtil.getNextWeek(gc.getTime()));  
        gc.setTime(DateUtil.getLastDayOfWeek(gc.getTime()));  
        return gc.getTime();  
    }  
  
    /** 
     * ȡ��ָ�����ڵ���һ���µĵ�һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ���µĵ�һ�� 
     */  
    public static java.util.Date getFirstDayOfNextMonth(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfMonth 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.setTime(DateUtil.getNextMonth(gc.getTime()));  
        gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));  
        return gc.getTime();  
    }  
    /** 
     * ָ��ʱ����һ���·ݵĵ�һ�� 
     *@param gc 
     *@return 
     */  
    public static java.util.Calendar getFirstDayOfNextMonth(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.����getNextMonth���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfMonth 
         */  
        gc.setTime(DateUtil.getNextMonth(gc.getTime()));  
        gc.setTime(DateUtil.getFirstDayOfMonth(gc.getTime()));  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ���һ�����ڵĵ�һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ�����ڵĵ�һ�� 
     */  
    public static java.util.Date getFirstDayOfNextWeek(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfWeek 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.setTime(DateUtil.getNextWeek(gc.getTime()));  
        gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));  
        return gc.getTime();  
    }  
    /** 
     * ָ��ʱ����һ�����ڵĵ�һ�� 
     *@param gc 
     *@return 
     */  
    public static java.util.Calendar getFirstDayOfNextWeek(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.����getNextWeek���õ�ǰʱ�� 2.��1Ϊ����������getFirstDayOfWeek 
         */  
        gc.setTime(DateUtil.getNextWeek(gc.getTime()));  
        gc.setTime(DateUtil.getFirstDayOfWeek(gc.getTime()));  
        return gc;  
    }  
  
    /** 
     * ָ�����ڼ�1�� 
     *@param date 
     *@return 
     */  
    public static java.util.Date getNextYear(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.ָ�����ڼ�1�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.add(Calendar.YEAR, 1);  
        return gc.getTime();  
    }  
    /** 
     * ָ�����ڼ�1�� 
     *@param gc 
     *@return 
     */  
    public static java.util.Calendar getNextYear(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.ָ�����ڼ�1�� 
         */  
        gc.add(Calendar.YEAR, 1);  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ���һ���� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ���� 
     */  
    public static java.util.Date getNextMonth(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.ָ�����ڵ��·ݼ�1 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.add(Calendar.MONTH, 1);  
        return gc.getTime();  
    }  
  
    /** 
     * ��ϸ��ƣ� 1.ָ�����ڵ��·ݼ�1 
     */  
    public static java.util.Calendar getNextMonth(java.util.Calendar gc) {  
        gc.add(Calendar.MONTH, 1);  
        return gc;  
    }  
  
    /** 
     * ��ϸ��ƣ� 1.ָ�����ڼ�1�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ�� 
     */  
    public static java.util.Date getNextDay(java.util.Date date) {  
  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.add(Calendar.DATE, 1);  
        return gc.getTime();  
    }  
  
    /** 
     * ��ϸ��ƣ� 1.ָ�����ڼ�1�� 
     */  
    public static java.util.Calendar getNextDay(java.util.Calendar gc) {  
        gc.add(Calendar.DATE, 1);  
        return gc;  
    }  
  
    /** 
     * ��ϸ��ƣ� 1.ָ�����ڼ�1�� 
     */  
    public static java.util.Date getPreviousDay(java.util.Date date) {  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.add(Calendar.DATE, -1);  
        return gc.getTime();  
    }  
  
    /** 
     * ��ϸ��ƣ� 1.ָ�����ڼ�1�� 
     */  
    public static java.util.Calendar getPreviousDay(java.util.Calendar gc) {  
        gc.add(Calendar.DATE, -1);  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ���һ������ 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ���һ������ 
     */  
    public static java.util.Date getNextWeek(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.ָ�����ڼ�7�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.add(Calendar.DATE, 7);  
        return gc.getTime();  
    }  
  
    /** 
     * ȡ��ָ�����ڵ�n�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ�n�� 
     */  
    public static java.util.Date getNextNumDay(java.util.Date date, int n) {  
        /** 
         * ��ϸ��ƣ� 1.ָ�����ڼ�n�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.add(Calendar.DATE, n);  
        return gc.getTime();  
    }  
    /** 
     * ָ�����ڼ�7�� 
     *@param gc 
     *@return 
     */  
    public static java.util.Calendar getNextWeek(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.ָ�����ڼ�7�� 
         */  
        gc.add(Calendar.DATE, 7);  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ��������ڵ����һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ��������ڵ����һ�� 
     */  
    public static java.util.Date getLastDayOfWeek(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.���date�������գ����6�� 2.���date������һ�����5�� 3.���date�����ڶ������4�� 
         * 4.���date�������������3�� 5.���date�������ģ����2�� 6.���date�������壬���1�� 
         * 7.���date�������������0�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        switch (gc.get(Calendar.DAY_OF_WEEK)) {  
            case (Calendar.SUNDAY):  
                gc.add(Calendar.DATE, 6);  
                break;  
            case (Calendar.MONDAY):  
                gc.add(Calendar.DATE, 5);  
                break;  
            case (Calendar.TUESDAY):  
                gc.add(Calendar.DATE, 4);  
                break;  
            case (Calendar.WEDNESDAY):  
                gc.add(Calendar.DATE, 3);  
                break;  
            case (Calendar.THURSDAY):  
                gc.add(Calendar.DATE, 2);  
                break;  
            case (Calendar.FRIDAY):  
                gc.add(Calendar.DATE, 1);  
                break;  
            case (Calendar.SATURDAY):  
                gc.add(Calendar.DATE, 0);  
                break;  
        }  
        return gc.getTime();  
    }  
  
    /** 
     * ȡ��ָ�����ڵ��������ڵĵ�һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ��������ڵĵ�һ�� 
     */  
    public static java.util.Date getFirstDayOfWeek(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.���date�������գ����0�� 2.���date������һ�����1�� 3.���date�����ڶ������2�� 
         * 4.���date�������������3�� 5.���date�������ģ����4�� 6.���date�������壬���5�� 
         * 7.���date�������������6�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        switch (gc.get(Calendar.DAY_OF_WEEK)) {  
            case (Calendar.SUNDAY):  
                gc.add(Calendar.DATE, 0);  
                break;  
            case (Calendar.MONDAY):  
                gc.add(Calendar.DATE, -1);  
                break;  
            case (Calendar.TUESDAY):  
                gc.add(Calendar.DATE, -2);  
                break;  
            case (Calendar.WEDNESDAY):  
                gc.add(Calendar.DATE, -3);  
                break;  
            case (Calendar.THURSDAY):  
                gc.add(Calendar.DATE, -4);  
                break;  
            case (Calendar.FRIDAY):  
                gc.add(Calendar.DATE, -5);  
                break;  
            case (Calendar.SATURDAY):  
                gc.add(Calendar.DATE, -6);  
                break;  
        }  
        return gc.getTime();  
    }  
    /** 
     * ȡ��ָ�����ڵ��������ڵĵ�һ�� 
     *  
     * @param gc 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ��������ڵĵ�һ�� 
     */  
    public static java.util.Calendar getFirstDayOfWeek(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.���date�������գ����0�� 2.���date������һ�����1�� 3.���date�����ڶ������2�� 
         * 4.���date�������������3�� 5.���date�������ģ����4�� 6.���date�������壬���5�� 
         * 7.���date�������������6�� 
         */  
        switch (gc.get(Calendar.DAY_OF_WEEK)) {  
            case (Calendar.SUNDAY):  
                gc.add(Calendar.DATE, 0);  
                break;  
            case (Calendar.MONDAY):  
                gc.add(Calendar.DATE, -1);  
                break;  
            case (Calendar.TUESDAY):  
                gc.add(Calendar.DATE, -2);  
                break;  
            case (Calendar.WEDNESDAY):  
                gc.add(Calendar.DATE, -3);  
                break;  
            case (Calendar.THURSDAY):  
                gc.add(Calendar.DATE, -4);  
                break;  
            case (Calendar.FRIDAY):  
                gc.add(Calendar.DATE, -5);  
                break;  
            case (Calendar.SATURDAY):  
                gc.add(Calendar.DATE, -6);  
                break;  
        }  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ������·ݵ����һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ������·ݵ����һ�� 
     */  
    public static java.util.Date getLastDayOfMonth(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.���date��1�£���Ϊ31�� 2.���date��2�£���Ϊ28�� 3.���date��3�£���Ϊ31�� 
         * 4.���date��4�£���Ϊ30�� 5.���date��5�£���Ϊ31�� 6.���date��6�£���Ϊ30�� 
         * 7.���date��7�£���Ϊ31�� 8.���date��8�£���Ϊ31�� 9.���date��9�£���Ϊ30�� 
         * 10.���date��10�£���Ϊ31�� 11.���date��11�£���Ϊ30�� 12.���date��12�£���Ϊ31�� 
         * 1.���date�������2�£���Ϊ29�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        switch (gc.get(Calendar.MONTH)) {  
            case 0:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 1:  
                gc.set(Calendar.DAY_OF_MONTH, 28);  
                break;  
            case 2:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 3:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 4:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 5:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 6:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 7:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 8:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 9:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 10:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 11:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
        }  
        // �������  
        if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY) && (isLeapYear(gc.get(Calendar.YEAR)))) {  
            gc.set(Calendar.DAY_OF_MONTH, 29);  
        }  
        return gc.getTime();  
    }  
    /** 
     * ȡ��ָ�����ڵ������·ݵ����һ�� 
     *  
     * @param gc 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ������·ݵ����һ�� 
     */  
    public static java.util.Calendar getLastDayOfMonth(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.���date��1�£���Ϊ31�� 2.���date��2�£���Ϊ28�� 3.���date��3�£���Ϊ31�� 
         * 4.���date��4�£���Ϊ30�� 5.���date��5�£���Ϊ31�� 6.���date��6�£���Ϊ30�� 
         * 7.���date��7�£���Ϊ31�� 8.���date��8�£���Ϊ31�� 9.���date��9�£���Ϊ30�� 
         * 10.���date��10�£���Ϊ31�� 11.���date��11�£���Ϊ30�� 12.���date��12�£���Ϊ31�� 
         * 1.���date�������2�£���Ϊ29�� 
         */  
        switch (gc.get(Calendar.MONTH)) {  
            case 0:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 1:  
                gc.set(Calendar.DAY_OF_MONTH, 28);  
                break;  
            case 2:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 3:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 4:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 5:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 6:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 7:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 8:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 9:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
            case 10:  
                gc.set(Calendar.DAY_OF_MONTH, 30);  
                break;  
            case 11:  
                gc.set(Calendar.DAY_OF_MONTH, 31);  
                break;  
        }  
        // �������  
        if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY) && (isLeapYear(gc.get(Calendar.YEAR)))) {  
            gc.set(Calendar.DAY_OF_MONTH, 29);  
        }  
        return gc;  
    }  
  
    /** 
     * ȡ��ָ�����ڵ������·ݵĵ�һ�� 
     *  
     * @param date 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ������·ݵĵ�һ�� 
     */  
    public static java.util.Date getFirstDayOfMonth(java.util.Date date) {  
        /** 
         * ��ϸ��ƣ� 1.����Ϊ1�� 
         */  
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
        gc.setTime(date);  
        gc.set(Calendar.DAY_OF_MONTH, 1);  
        return gc.getTime();  
    }  
    /** 
     * ȡ��ָ�����ڵ������·ݵĵ�һ�� 
     *  
     * @param gc 
     *            ָ�����ڡ� 
     * @return ָ�����ڵ������·ݵĵ�һ�� 
     */  
    public static java.util.Calendar getFirstDayOfMonth(java.util.Calendar gc) {  
        /** 
         * ��ϸ��ƣ� 1.����Ϊ1�� 
         */  
        gc.set(Calendar.DAY_OF_MONTH, 1);  
        return gc;  
    }  
  
    /** 
     * �����ڶ���ת����Ϊָ��ORA���ڡ�ʱ���ʽ���ַ�����ʽ��������ڶ���Ϊ�գ����� һ�����ַ������󣬶�����һ���ն��� 
     *  
     * @param theDate 
     *            ��Ҫת��Ϊ�ַ��������ڶ��� 
     * @param hasTime 
     *            ������ص��ַ�����ʱ����Ϊtrue 
     * @return ת���Ľ�� 
     */  
    public static String toOraString(Date theDate, boolean hasTime) {  
        /** 
         * ��ϸ��ƣ� 1.�����ʱ�䣬�����ø�ʽΪgetOraDateTimeFormat()�ķ���ֵ 
         * 2.�������ø�ʽΪgetOraDateFormat()�ķ���ֵ 3.����toString(Date theDate, DateFormat 
         * theDateFormat) 
         */  
        DateFormat theFormat;  
        if (hasTime) {  
            theFormat = getOraDateTimeFormat();  
        } else {  
            theFormat = getOraDateFormat();  
        }  
        return toString(theDate, theFormat);  
    }  
  
    /** 
     * �����ڶ���ת����Ϊָ�����ڡ�ʱ���ʽ���ַ�����ʽ��������ڶ���Ϊ�գ����� һ�����ַ������󣬶�����һ���ն��� 
     *  
     * @param theDate 
     *            ��Ҫת��Ϊ�ַ��������ڶ��� 
     * @param hasTime 
     *            ������ص��ַ�����ʱ����Ϊtrue 
     * @return ת���Ľ�� 
     */  
    public static String toString(Date theDate, boolean hasTime) {  
        /** 
         * ��ϸ��ƣ� 1.�����ʱ�䣬�����ø�ʽΪgetDateTimeFormat�ķ���ֵ 2.�������ø�ʽΪgetDateFormat�ķ���ֵ 
         * 3.����toString(Date theDate, DateFormat theDateFormat) 
         */  
        DateFormat theFormat;  
        if (hasTime) {  
            theFormat = getDateTimeFormat();  
        } else {  
            theFormat = getDateFormat();  
        }  
        return toString(theDate, theFormat);  
    }  
  
    /** 
     * ��׼���ڸ�ʽMM/dd/yyyy 
     */  
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");  
  
    /** 
     * ��׼ʱ���ʽMM/dd/yyyy HH:mm 
     */  
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm");  
  
    /** 
     * ORA��׼���ڸ�ʽyyyyMMdd 
     */  
    public static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");  
    /** 
     * yyyyMM 
     */  
    public static final SimpleDateFormat ORA_DATE_MONTH_FORMAT = new SimpleDateFormat("yyyyMM");  
  
    /** 
     * ORA��׼ʱ���ʽyyyyMMddHHmm 
     */  
    private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");  
  
    /** 
     * ����һ����׼���ڸ�ʽ�Ŀ�¡ 
     *  
     * @return ��׼���ڸ�ʽ�Ŀ�¡ 
     */  
    public static DateFormat getDateFormat() {  
        /** 
         * ��ϸ��ƣ� 1.����DATE_FORMAT 
         */  
        SimpleDateFormat theDateFormat = (SimpleDateFormat) DATE_FORMAT.clone();  
        theDateFormat.setLenient(false);  
        return theDateFormat;  
    }  
  
    /** 
     * ����һ����׼ʱ���ʽ�Ŀ�¡ 
     *  
     * @return ��׼ʱ���ʽ�Ŀ�¡ 
     */  
    public static DateFormat getDateTimeFormat() {  
        /** 
         * ��ϸ��ƣ� 1.����DATE_TIME_FORMAT 
         */  
        SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) DATE_TIME_FORMAT.clone();  
        theDateTimeFormat.setLenient(false);  
        return theDateTimeFormat;  
    }  
  
    /** 
     * ����һ����׼ORA���ڸ�ʽ�Ŀ�¡ 
     *  
     * @return ��׼ORA���ڸ�ʽ�Ŀ�¡ 
     */  
    public static DateFormat getOraDateFormat() {  
        /** 
         * ��ϸ��ƣ� 1.����ORA_DATE_FORMAT 
         */  
        SimpleDateFormat theDateFormat = (SimpleDateFormat) ORA_DATE_FORMAT.clone();  
        theDateFormat.setLenient(false);  
        return theDateFormat;  
    }  
  
    /** 
     * ����һ����׼ORAʱ���ʽ�Ŀ�¡ 
     *  
     * @return ��׼ORAʱ���ʽ�Ŀ�¡ 
     */  
    public static DateFormat getOraDateTimeFormat() {  
        /** 
         * ��ϸ��ƣ� 1.����ORA_DATE_TIME_FORMAT 
         */  
        SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) ORA_DATE_TIME_FORMAT.clone();  
        theDateTimeFormat.setLenient(false);  
        return theDateTimeFormat;  
    }  
  
    /** 
     * ��һ�����ڶ���ת����Ϊָ�����ڡ�ʱ���ʽ���ַ����� ������ڶ���Ϊ�գ�����һ�����ַ�����������һ���ն��� 
     *  
     * @param theDate 
     *            Ҫת�������ڶ��� 
     * @param theDateFormat 
     *            ���ص������ַ����ĸ�ʽ 
     * @return ת����� 
     */  
    public static String toString(Date theDate, DateFormat theDateFormat) {  
        /** 
         * ��ϸ��ƣ� 1.theDateΪ�գ��򷵻�"" 2.����ʹ��theDateFormat��ʽ�� 
         */  
        if (theDate == null)  
            return "";  
        return theDateFormat.format(theDate);  
    }  
  
    /** 
     * ������������֮�������¸���������һ���º��� 
     */  
    public static int subMonth(java.util.Calendar begingc, java.util.Calendar endgc) {  
        int beginYear = begingc.get(Calendar.YEAR);  
        int beginMonth = begingc.get(Calendar.MONTH);  
        int endYear = endgc.get(Calendar.YEAR);  
        int endMonth = endgc.get(Calendar.MONTH);  
        return (endYear - beginYear) * 12 + (endMonth - beginMonth);  
    }  
  
    /** 
     * ������������֮������������,�����ǡ�������������¡����գ���ʱ�����֣����� �������һ���°���һ���¼��� 
     */  
    public static int betweenMonths(Date begin, Date end) {  
        Calendar begingc = Calendar.getInstance();  
        begingc.setTime(begin);  
        int beginYear = begingc.get(Calendar.YEAR);  
        int beginMonth = begingc.get(Calendar.MONTH);  
        int beginDay = begingc.get(Calendar.DAY_OF_MONTH);  
  
        Calendar endgc = Calendar.getInstance();  
        endgc.setTime(end);  
        int endYear = endgc.get(Calendar.YEAR);  
        int endMonth = endgc.get(Calendar.MONTH);  
        int endDay = endgc.get(Calendar.DAY_OF_MONTH);  
  
        int between = (endYear - beginYear) * 12 + (endMonth - beginMonth);  
  
        if (endDay > beginDay)  
            between = between + 1;  
        else if (endDay < beginDay)  
            between = between - 1;  
        return between;  
  
    }  
  
    /** 
     * ������������֮������ 
     *  
     * @deprecated 
     */  
    public static double distanceYear(String beginDate, String endDate) {  
        if (beginDate == null || beginDate.trim().length() == 0 || endDate == null || endDate.trim().length() == 0) {  
            return 0;  
        }  
        int yday = 365;  
        // logger.info("&&&&&&&&&" + yday);  
        double disYear = 0.0;  
        String pattern = "yyyy-MM-dd";  
  
        Calendar bcal = parseCalendarFormat(beginDate, pattern);  
        int bday = bcal.get(Calendar.DAY_OF_YEAR);  
  
        Calendar ecal = parseCalendarFormat(endDate, pattern);  
        int eday = ecal.get(Calendar.DAY_OF_YEAR);  
  
        if (isLeapYear(Integer.parseInt(beginDate.substring(0, 4)))) {  
            // logger.info("&&&&&&&&&xxx" + yday);  
            yday = 366;  
            disYear = (yday - bday + eday) / yday;  
        } else {  
            // logger.info("&&&&&&&&&" + yday);  
            // logger.info("&&&&&&&&&" + bday);  
            // logger.info("&&&&&&&&&" + eday);  
            // logger.info("&&&&&&&&&" + ( yday - bday + eday ));  
            disYear = (double) (yday - bday + eday) / yday;  
            // logger.info("&&&&&&&&&" + disYear);  
        }  
        return disYear;  
    }  
  
    /** 
     * �������������ʱ��֮������ 
     *  
     * @deprecated 
     */  
    public static int calculeteBetweenDays(Date begin, Date end) {  
        if (begin == null || end == null)  
            return 0;  
        Calendar cal = Calendar.getInstance();  
        int beginYear = begin.getYear();  
        int endYear = end.getYear();  
        cal.setTime(begin);  
        int beginDay = cal.get(Calendar.DAY_OF_YEAR);  
        cal.setTime(end);  
        int endDay = cal.get(Calendar.DAY_OF_YEAR);  
        return (365) * (endYear - beginYear) + (endDay - beginDay);  
  
    }  
  
    /** 
     * ������ʱ��֮���� 
     * @param begin 
     * @param end 
     * @deprecated 
     * @return 
     */  
    public static double calculateBetweenYears(Date begin, Date end) {  
        return (double) calculeteBetweenDays(begin, end) / 365;  
    }  
  
    /** 
     * ������������֮�����ݣ������ǡ�������������¡����գ���ʱ�����֣����� ����һ���°���һ���¼��� 
     *  
     * @param begin 
     * @param end 
     * @return 
     */  
    public static double betweenYears(Date begin, Date end) {  
        return betweenMonths(begin, end) / 12.0;  
    }  
  
    /** 
     *  ת�����ڸ�ʽ 
     *@param date Date 
     *@param simple SimpleDateFormat 
     *@return 
     */  
    public static String transDateToString(Date date, SimpleDateFormat simple) {  
        if (date == null) {  
            return null;  
        }  
        return simple.format(date);  
    }  
  
    /** 
     *  ת�����ڸ�ʽ 
     *@param date Date 
     *@param format  
     *@return 
     */  
    public static String transDateToString(Date date, String format) {  
        if (date == null) {  
            return null;  
        }  
        SimpleDateFormat simple = new SimpleDateFormat(format);  
        return simple.format(date);  
    }  
    /** 
     *  
     *@param s 
     *@return 
     *@throws ParseException 
     */  
    public static Date transStringToDate(String s) throws ParseException {  
        if (s == null || s.trim().equals("")) {  
            return null;  
        }  
        return SimpleDateFormat.getDateInstance().parse(s);  
    }  
    /** 
     * ��day��timeƴ��ת����Date��ʽ 
     *@param day yyyyMMdd 
     *@param time HHmmss(����Ϊnull) 
     *@return 
     */  
    public static Date getBankCardDate(String day, String time) {  
        if (day == null || "".equals(day.trim())) {  
            return null;  
        }  
        if (time == null || "".equals(time.trim())) {  
            time = "000000";  
        }  
        String strDate = day + time;  
        String pattern = "yyyyMMddHHmmss";  
        return parseDateFormat(strDate, pattern);  
    }  
  
    public static long getIntervalDays(Date beginDate, Date endDate) {  
        long days = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);  
        return days;  
    }  
    /** 
     * ֻ�����ֵ������ַ���ת��ΪDate 
     *@param stringDate ֻ�����ֵ������ַ��� 
     *@return Date 
     * @see 
     */  
    public static Date fromString(String stringDate) {  
        if (stringDate == null || stringDate.length() == 0) {  
            return null;  
        }  
  
        int length = stringDate.length();  
        String dateFm;  
        if (length == 8) {  
            dateFm = "yyyyMMdd"; // ��ʽ����ǰϵͳ���ڵ���  
        } else if (length == 10) {  
            dateFm = "yyyyMMddHH";// ��ʽ����ǰϵͳ���ڵ�ʱ  
        } else if (length == 12) {  
            dateFm = "yyyyMMddHHmm"; // ��ʽ����ǰϵͳ���ڵ�����  
        } else if (length == 14) {  
            dateFm = "yyyyMMddHHmmss"; // ��ʽ����ǰϵͳ���ڵ���  
        } else {  
            dateFm = "yyyyMM";  
        }  
        return DateUtil.parseDateFormat(stringDate, dateFm);  
    }  
    /** 
     * ��ȡ���ڵ��賿ʱ�� (yyyy-MM-dd 00:00:00) 
     *@param date 
     *@return 
     */  
    public static String getBeginDate(Date date) {  
        String pattern = "yyyy-MM-dd 00:00:00";  
        return getDateFormat(date, pattern);  
    }  
    /** 
     * ��ȡ���ڵ���ҹʱ�� (yyyy-MM-dd 23:59:59) 
     *@param date 
     *@return 
     */  
    public static String getPolicyEndDate(Date date) {  
        String pattern = "yyyy-MM-dd 23:59:59";  
        return getDateFormat(date, pattern);  
    }  
  
      
    //�����null����true�������String�����򻹻��ж��Ƿ���""(���ַ���)�������""����true�����򷵻�FALSE  
    public static boolean isNullOrEmpty(Object obj) {  
        return null == obj ? true : (obj instanceof String && "".equals(obj.toString().trim())) ? true : false;  
    }  
}
