package com.iu.b1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {

	@Before("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void before() throws Exception{
		System.out.println("Before Member Login");
	}
	
	@AfterReturning("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void after() throws Exception{
		System.out.println("After member Login");
	}
	@AfterThrowing("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void after2() throws Exception{
		System.out.println("After member Join");
	}
	
	@After("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void after3() throws Exception{
		System.out.println("After member Join");
	}
	@Around("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("메서드 실행전");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("메서드 실행 후");
		
		return obj;
		
	}
	
}
