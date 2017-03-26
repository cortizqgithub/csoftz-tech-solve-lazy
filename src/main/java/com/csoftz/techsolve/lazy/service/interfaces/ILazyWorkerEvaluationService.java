/*----------------------------------------------------------------------------*/
/* Source File:   ILAZYWORKEREVALUATIONSERVICE.JAVA                           */
/* Description:   Interface for Service to check input data and evaluate      */
/*                lazy worker duties                                          */
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
package com.csoftz.techsolve.lazy.service.interfaces;

import com.csoftz.techsolve.lazy.domain.LazyWorkerExchangeInfo;

/**
 * Interfacefor Service to check input data and evaluate lazy worker duties
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.25/2017
 * @since 1.8 (JDK), Mar.25/2017
 */
@SuppressWarnings("unused")
public interface ILazyWorkerEvaluationService {
    /**
     * Evaluate the input data to gather a valid or invalid input, if valid next step would
     * be to evaluate data in the method 'execute'.
     *
     * @param processingData Input data to process
     * @return Information about validity of supplied information.
     */
    LazyWorkerExchangeInfo validateProcessingDataFormat(String processingData);

    /**
     * Evaluate the data given.
     *
     * @param lazyWorkerExchangeInfo Instance to object to evaluate
     *                               (wraps input data and other fields to indicate processing duties.
     */
    void execute(LazyWorkerExchangeInfo lazyWorkerExchangeInfo);
}
