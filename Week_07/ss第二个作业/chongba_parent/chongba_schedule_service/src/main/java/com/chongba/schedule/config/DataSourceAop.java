//package com.chongba.schedule.config;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class DataSourceAop {
//    /**
//     * 只读：
//     * 不是Master注解的对象或方法  && select开头的方法  ||  get开头的方法
//     */
//    @Pointcut("@annotation(com.chongba.schedule.config.ReadOnly) " +
//            "&& (execution(* com.chongba.schedule.service..*.select*(..)) " +
//            "|| execution(* com.chongba.schedule..*.get*(..)))")
//    public void readPointcut() {
//
//    }
//
//    /**
//     * 写：
//     * Master注解的对象或方法 || insert开头的方法  ||  add开头的方法 || update开头的方法
//     * || edlt开头的方法 || delete开头的方法 || remove开头的方法
//     */
//    @Pointcut("@annotation(com.chongba.schedule.config.Master) " +
//            "|| execution(* com.chongba.schedule.service..*.insert*(..)) " +
//            "|| execution(* com.chongba.schedule.service..*.add*(..)) " +
//            "|| execution(* com.chongba.schedule.service..*.update*(..)) " +
//            "|| execution(* com.chongba.schedule.service..*.edit*(..)) " +
//            "|| execution(* com.chongba.schedule.service..*.delete*(..)) " +
//            "|| execution(* com.chongba.schedule..*.remove*(..))")
//    public void writePointcut() {
//
//    }
//
//    @Before("readPointcut()")
//    public void read() {
//        DBContextHolder.slave();
//    }
//
//    @Before("writePointcut()")
//    public void write() {
//        DBContextHolder.master();
//    }
//}
