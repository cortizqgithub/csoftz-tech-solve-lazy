/*----------------------------------------------------------------------------*/
/* Source File:   LAZYWORKEREVALUATIONSERVICE.JAVA                            */
/* Description:   Service to check input data and evaluate lazy worker duties */
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
package com.csoftz.techsolve.lazy.service;

import com.csoftz.techsolve.lazy.domain.LazyWorkerExchangeInfo;
import com.csoftz.techsolve.lazy.service.interfaces.ILazyWorkerEvaluationService;
import org.springframework.stereotype.Service;

/**
 * Service to check input data and evaluate lazy worker duties
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.25/2017
 * @since 1.8 (JDK), Mar.25/2017
 */
@Service
@SuppressWarnings("unused")
public class LazyWorkerEvaluationService implements ILazyWorkerEvaluationService {

    /**
     * See interface declaration for details.
     * @param processingData Input data to process
     * @return Information about validity of supplied information.
     */
    @Override
    public LazyWorkerExchangeInfo validateProcessingDataFormat(String processingData) {
        LazyWorkerExchangeInfo info = new LazyWorkerExchangeInfo();
        return info;
    }

    /**
     * See interface declaration for details.
     * @param lazyWorkerExchangeInfo Instance to object to evaluate
     */
    @Override
    public void execute(LazyWorkerExchangeInfo lazyWorkerExchangeInfo) {

    }
}
