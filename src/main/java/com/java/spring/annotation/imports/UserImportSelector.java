package com.java.spring.annotation.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.java.spring.annotation.bean.User;

public class UserImportSelector implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.java.spring.annotation.bean.User"};
	}

}
