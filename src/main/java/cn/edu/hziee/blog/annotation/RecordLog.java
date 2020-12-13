package cn.edu.hziee.blog.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface RecordLog {
    
    String operateDesc()  default ""; //描述
    
    String userType()  default "用户";
} 