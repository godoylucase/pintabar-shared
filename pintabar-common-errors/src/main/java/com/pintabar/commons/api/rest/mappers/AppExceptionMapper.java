package com.pintabar.commons.api.rest.mappers;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by lucasgodoy on 22/06/17.
 */
@Provider
@Component
public class AppExceptionMapper implements ExceptionMapper<AppException> {

	private final ExceptionMapperHelper exceptionMapperHelper;

	public AppExceptionMapper(ExceptionMapperHelper exceptionMapperHelper) {
		this.exceptionMapperHelper = exceptionMapperHelper;
	}

	@Override
	public Response toResponse(AppException ex) {
		ErrorCode errorCode = ex.getErrorCode();
		Object[] params = ex.getParams();

		return Response.status(errorCode.getHttpStatus())
				.entity(exceptionMapperHelper.buildErrorResponse(errorCode, ex, params))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
