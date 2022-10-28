package com.training.pms.galaxe.aop;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspects {

	@Before(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSecurity() {
		System.out.println("###Security Checked in at :"+new Date() );
	}
	@After(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSerurityLater() {
		System.out.println("###Security Checked out at :"+new Date());
	}
//	@Around(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.isProductExists(..))")
//	public boolean checkAround(ProceedingJoinPoint point) throws Throwable {
//		System.out.println("###Around checked Before");
//		point.proceed();
//		System.out.println("###Around checked after");
//		return true;
//	}

	@Around(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public Object checkAround(ProceedingJoinPoint point) throws Throwable {
		Signature methods = point.getSignature();
		System.out.println("###Around checked Before");
		Object retval = point.proceed();
		System.out.println("###Around checked after");
		return retval;
	}
}
