package com.pintabar.commons.exceptions.general;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;

/**
 * @author Lucas.Godoy on 3/09/17.
 */
public class InvalidEntityException extends AppException {

	public InvalidEntityException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}
}
