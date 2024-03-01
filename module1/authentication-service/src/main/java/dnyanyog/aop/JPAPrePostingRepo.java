package dnyanyog.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JPAPrePostingRepo {
	
	@Before("execution(* dnyanyog.repo.*.save(..))")
	public void beforeExecution(JoinPoint joinPoint) {
		Long currentBeforeTimeMillis=System.currentTimeMillis();
		Date date=new Date(currentBeforeTimeMillis);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String formatedDate=sdf.format(date);
		System.out.println("Before saving "+formatedDate);
		
		System.out.println("Saving object :" +joinPoint.getArgs()[0]);
	}
	
	@After("execution(* dnyanyog.repo.*.save(..))")
	
	public void afterExceution(JoinPoint joinPoint) {
		Long currentBeforeMillis=System.currentTimeMillis();
		Date date=new Date(currentBeforeMillis);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatedDate=sdf.format(date);
		System.out.println("After saving : "+formatedDate);
		System.out.println("Saving object :"+joinPoint.getArgs()[0]);
	}
		
	}


