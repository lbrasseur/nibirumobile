package ar.com.oxen.nibiru.mobile.core.impl.service.security;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.google.inject.BindingAnnotation;

@Qualifier
@BindingAnnotation
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface Authentication {
}
