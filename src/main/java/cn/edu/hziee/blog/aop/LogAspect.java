package cn.edu.hziee.blog.aop;


import cn.edu.hziee.blog.annotation.RecordLog;
import cn.edu.hziee.blog.model.Record;
import cn.edu.hziee.blog.service.RecordService;
import cn.edu.hziee.blog.util.UserIpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.*;

@Aspect
@Component
public class LogAspect {//自定义注解

    @Autowired
    private RecordService recordService;

    // 切点 在注解的位置切入代码
    @Pointcut("@annotation(cn.edu.hziee.blog.annotation.RecordLog)")
    public void afterRecord() {
    }

//    //controller层所有方法
//    @Pointcut("execution(public * cn.edu.hziee.blog.controller..*.*(..))")
//    public void controllerMethod() {
//    }

    @After("afterRecord()")
    public void doAfterRecord(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        //记录请求信息
        Object[] objs = joinPoint.getArgs();
        Record record = new Record();
        //获取拦截的方法（Method对象）
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        System.out.println("uri请求：" + request.getRequestURL().toString());
        System.out.println("方法参数：" + getParameter(method, joinPoint.getArgs()));

        try {
            record.setUserip(UserIpUtil.getIp(request));
            record.setUsertype(getUserType(joinPoint));
            record.setRequestparam(joinPoint.getArgs()[0].toString());
            record.setOperatedesc(getDescription(joinPoint));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            record.setRecordtime(sdf.format(new Date()));
            if(!record.getRequestparam().equals("")){
//                recordService.insertSelective(record);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //获取注解中对方法的描述信息
    public static String getDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(RecordLog.class)
                            .operateDesc();
                    break;
                }
            }
        }
        return description;
    }

    //获取注解中的用户信息
    public static String getUserType(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String userType = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    userType = method.getAnnotation(RecordLog.class)
                            .userType();
                    break;
                }
            }
        }
        return userType;
    }

    //根据方法和传入的参数获取请求参数
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            } else {
                argList.add(args[i]);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }


}
