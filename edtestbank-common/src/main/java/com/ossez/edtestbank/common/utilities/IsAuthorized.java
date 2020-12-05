package com.ossez.edtestbank.common.utilities;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("@propertiesConfiguration.roleAuthentication == false or hasAnyRole('ROLE_USERS','ROLE_ADMIN')")
public @interface IsAuthorized {
}
