package com.java.spring.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UserCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Class<? extends ConditionContext> class1 = context.getClass();
		System.out.println(class1);
		return true;
	}

}
