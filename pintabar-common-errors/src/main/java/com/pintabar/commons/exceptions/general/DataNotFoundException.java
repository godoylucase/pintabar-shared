package com.pintabar.commons.exceptions.general;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by lucasgodoy on 24/06/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class DataNotFoundException extends AppException {

	public DataNotFoundException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}
}
