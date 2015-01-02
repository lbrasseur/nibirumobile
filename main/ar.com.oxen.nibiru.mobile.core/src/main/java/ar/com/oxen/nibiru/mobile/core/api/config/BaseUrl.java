package ar.com.oxen.nibiru.mobile.core.api.config;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.google.inject.BindingAnnotation;

@Qualifier
@BindingAnnotation
@Target({ PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface BaseUrl {
}