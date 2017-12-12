package net.mrliuli.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {} //û��Ԫ�ص�ע���Ϊ���ע��(marker annotation)
