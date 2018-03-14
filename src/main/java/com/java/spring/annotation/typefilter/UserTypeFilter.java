package com.java.spring.annotation.typefilter;

import java.io.IOException;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class UserTypeFilter implements TypeFilter{

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		String className = annotationMetadata.getClassName();
		if(className.equals("com.java.spring.annotation.service.UserService")){
			return true;
		}
		return false;
	}

}
