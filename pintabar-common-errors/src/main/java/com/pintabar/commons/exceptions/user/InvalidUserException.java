package com.pintabar.commons.exceptions.user;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;

/**
 * @author Lucas.Godoy on 25/08/17.
 */
public class InvalidUserException extends AppException {

	public InvalidUserException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}
}
