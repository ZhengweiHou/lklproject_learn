package com.hzw.java_learn.javabase.annotation.metaannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface MetaAnnotationTest {

}

/*
一. @Retention
	1. RetentionPolicy.SOURCE
	2. RetentionPolicy.CLASS
	3. RetentionPolicy.RUNTIME
二. @Target
	ElementType
	    //Class, interface (including annotation type), or enum declaration
	    TYPE,
	    Field declaration (includes enum constants)
	    FIELD,
	    Method declaration
	    METHOD,
	    Formal parameter declaration
	    PARAMETER,
	    Constructor declaration
	    CONSTRUCTOR,
	    Local variable declaration
	    LOCAL_VARIABLE,
	    Annotation type declaration
	    ANNOTATION_TYPE,
	    Package declaration
	    PACKAGE,
	    Type parameter declaration
	    TYPE_PARAMETER,
	    Use of a type
	    TYPE_USE


*/