package com.tibos.util;

import java.lang.reflect.InvocationTargetException;  
import java.lang.reflect.Method;  
import java.math.BigDecimal;  
import javax.servlet.http.HttpServletRequest; 

public class DTOBuilder {
	/** 
     * ������ڣ��õ�Dto 
     *@param request  
     *@param dtoClass �����ʵ���� 
     *@return 
     */  
    public static Object getDTO(HttpServletRequest request, Class dtoClass) {  
        Object dtoObj = null;  
        if ((dtoClass == null) || (request == null))  
            return dtoObj;  
        try {  
            //ʵ��������  
            dtoObj = dtoClass.newInstance();  
            setDTOValue(request, dtoObj);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        return dtoObj;  
    }  
    /** 
     * ��������  
     *@param request 
     *@param dto 
     *@throws Exception 
     */  
    public static void setDTOValue(HttpServletRequest request, Object dto) throws Exception {  
        if ((dto == null) || (request == null))  
            return;  
        //�õ��������еķ��� �����϶���set��get����  
        Method[] methods = dto.getClass().getMethods();  
        for (int i = 0; i < methods.length; i++) {  
            try {  
                //������  
                String methodName = methods[i].getName();  
                //��������������  
                Class[] type = methods[i].getParameterTypes();  
                //��ʱset����ʱ���ж����ݣ�setXxxx����  
                if ((methodName.length() > 3) && (methodName.startsWith("set")) && (type.length == 1)) {  
                    //��set����Ĵ�д��ĸת��Сд����ȡ����  
                    String name = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);  
                    Object objValue = getBindValue(request, name, type[0]);  
                    if (objValue != null) {  
                        Object[] value = { objValue };  
                        invokeMothod(dto, methodName, type, value);  
                    }  
                }  
            } catch (Exception ex) {  
                throw ex;  
            }  
        }  
    }  
    /** 
     * ͨ��request�õ���Ӧ��ֵ 
     *@param request HttpServletRequest 
     *@param bindName ������ 
     *@param bindType ���Ե����� 
     *@return 
     */  
    public static Object getBindValue(HttpServletRequest request, String bindName, Class bindType) {  
        //�õ�request�е�ֵ  
        String value = request.getParameter(bindName);  
        if (value != null) {  
            value = value.trim();  
        }  
        return getBindValue(value, bindType);  
    }  
    /** 
     * ͨ�����÷�������setXxxx����ֵ���õ������� 
     *@param classObject ʵ������� 
     *@param strMethodName ������(һ�㶼��setXxxx) 
     *@param argsType ������������ 
     *@param args ����ֵ���� 
     *@return 
     *@throws NoSuchMethodException 
     *@throws SecurityException 
     *@throws IllegalAccessException 
     *@throws IllegalArgumentException 
     *@throws InvocationTargetException 
     */  
    public static Object invokeMothod(Object classObject, String strMethodName, Class[] argsType, Object[] args)  
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,  
            InvocationTargetException {  
        //�õ�classObject�����ķ���  
        Method concatMethod = classObject.getClass().getMethod(strMethodName, argsType);  
        //���÷�����classObject��ֵ����Ӧ������  
        return concatMethod.invoke(classObject, args);  
    }  
    /** 
     * ����bindType���͵Ĳ�ͬת����Ӧ������ֵ 
     *@param value String���͵�ֵ��Ҫ����bindType���͵Ĳ�ͬת����Ӧ������ֵ 
     *@param bindType ���Ե����� 
     *@return 
     */  
    public static Object getBindValue(String value, Class bindType) {  
        if ((value == null) || (value.trim().length() == 0))  
            return null;  
        String typeName = bindType.getName();  
        //�����жϸ������Ͳ�ת����Ӧ��ֵ  
        if (typeName.equals("java.lang.String"))  
            return value;  
        if (typeName.equals("int"))  
            return new Integer(value);  
        if (typeName.equals("long"))  
            return new Long(value);  
        if (typeName.equals("boolean"))  
            return new Boolean(value);  
        if (typeName.equals("float"))  
            return new Float(value);  
        if (typeName.equals("double"))  
            return new Double(value);  
        if (typeName.equals("java.math.BigDecimal")) {  
            if ("NaN.00".equals(value))  
                return new BigDecimal("0");  
            return new BigDecimal(value.trim());  
        }  
        if (typeName.equals("java.util.Date"))  
            //�ο�DateUtil.parseDateDayFormat������value�����ʱ�����ͣ�������yyyy-MM-dd��ʽ���ܱ�ʶ��  
            //��ο��ҵ���һƪ����http://blog.csdn.net/bq1073100909/article/details/49472615  
            return DateUtil.parseDateDayFormat(value);  
        if (typeName.equals("java.lang.Integer"))  
            return new Integer(value);  
        if (typeName.equals("java.lang.Long")) {  
            return new Long(value);  
        }  
        if (typeName.equals("java.lang.Boolean")) {  
            return new Boolean(value);  
        }  
        return value;  
    }  
}
