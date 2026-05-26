package com.example.demo.team16;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Team16Aspect {
	@AfterReturning("execution(* com.example.demo.team16..*.*(..))")
	public void returningLog(JoinPoint jp) {
		log.info("メゾット正常終了："+jp.getSignature());
		if(jp.getArgs().length>0) {
			log.info("引数："+Arrays.toString(jp.getArgs()));
		}
	}
	@AfterThrowing("execution(* com.example.demo.team16..*.*(..))")
	public void throwingLog(JoinPoint jp) {
		log.error("メゾット異常終了："+jp.getSignature());
		if(jp.getArgs().length>0) {
			log.error("引数："+Arrays.toString(jp.getArgs()));
		}
	}
	
}
