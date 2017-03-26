/*----------------------------------------------------------------------------*/
/* Source File:   LAZYCONTROLLER.JAVA                                         */
/* Description:   Data transfer object to hold information about the user     */
/*                who is making the test.                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.25/2017                                                 */
/* Last Modified: Mar.25/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.25/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.techsolve.lazy.domain;

import java.util.List;

/**
 * Data transfer object to hold information about the user
 * who is making the test.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.24/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
public class LazyWorkerExchangeInfo {
    private String userIdNumber;
    private boolean valid;
    private String errorDescription;
    private String outputResult;

    /**
     * Default constructor
     */
    public LazyWorkerExchangeInfo() {
        this.userIdNumber = "";
        this.valid = false;
        this.errorDescription = "";
        this.outputResult = "";
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getOutputResult() {
        return outputResult;
    }

    public void setOutputResult(String outputResult) {
        this.outputResult = outputResult;
    }

    @Override
    public String toString() {
        return "LazyWorkerExchangeInfo{" +
                "userIdNumber='" + userIdNumber + '\'' +
                ", valid=" + valid +
                ", errorDescription='" + errorDescription + '\'' +
                ", outputResult='" + outputResult + '\'' +
                '}';
    }
}
