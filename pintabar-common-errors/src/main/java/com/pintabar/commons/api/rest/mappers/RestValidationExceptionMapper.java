package com.pintabar.commons.api.rest.mappers;

import com.pintabar.commons.api.rest.errors.ErrorResponse;
import com.pintabar.commons.exceptions.ErrorCode;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.validation.ResponseConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * @author Lucas.Godoy on 13/08/17.
 */
@Provider
@Component
public class RestValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	private final ExceptionMapperHelper exceptionMapperHelper;

	public RestValidationExceptionMapper(ExceptionMapperHelper exceptionMapperHelper) {
		this.exceptionMapperHelper = exceptionMapperHelper;
	}

	@Override
	public Response toResponse(ValidationException exception) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
		if (exception instanceof ConstraintViolationException) {
			final ConstraintViolationException constraint = (ConstraintViolationException) exception;
			String message = null;
			for (final ConstraintViolation<?> violation : constraint.getConstraintViolations()) {
				message = buildErrorMessage(violation);
			}
			if (!(constraint instanceof ResponseConstraintViolationException)) {
				httpStatus = Response.Status.BAD_REQUEST;
			}

			ErrorResponse errorResponse = null;
			if (message != null) {
				errorResponse = exceptionMapperHelper.buildErrorResponse(httpStatus, ErrorCode.PARAMETER_ERROR, exception, message);
			} else {
				errorResponse = exceptionMapperHelper.buildErrorResponse(httpStatus, ErrorCode.PARAMETER_ERROR, exception);
			}
			return Response.status(httpStatus)
					.entity(errorResponse)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		return Response.status(httpStatus)
				.entity(exceptionMapperHelper.buildErrorResponse(httpStatus, ErrorCode.PARAMETER_ERROR, exception, exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

	private String buildErrorMessage(ConstraintViolation<?> violation) {
		return "Value "
				+ (violation.getInvalidValue() != null ? "'" + violation.getInvalidValue().toString() + "'" : "(null)")
				+ " of " + violation.getRootBeanClass().getSimpleName()
				+ "." + violation.getPropertyPath()
				+ ": " + violation.getMessage();
	}
}
