package com.pintabar.commons.exceptions.business;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;

/**
 * @author Lucas.Godoy on 30/08/17.
 */
public class InvalidBusinessException extends AppException {

	public InvalidBusinessException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}

}
