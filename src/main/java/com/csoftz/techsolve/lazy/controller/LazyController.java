/*----------------------------------------------------------------------------*/
/* Source File:   LAZYCONTROLLER.JAVA                                         */
/* Description:   Lazy page                                                   */
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

package com.csoftz.techsolve.lazy.controller;

import com.csoftz.techsolve.lazy.domain.LazyWorkerExchangeInfo;
import com.csoftz.techsolve.lazy.service.interfaces.ILazyWorkerEvaluationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Lazy page
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.25/2017
 * @since 1.8 (JDK), Mar.25/2017
 */
@Controller
@RequestMapping("/lazy")
@SuppressWarnings("unused")
public class LazyController {
    /**
     * Logger factory.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ILazyWorkerEvaluationService lazyWorkerEvaluationService;

    /**
     * Inject service to this controller.
     */
    public LazyController(final ILazyWorkerEvaluationService lazyWorkerEvaluationService) {
        this.lazyWorkerEvaluationService = lazyWorkerEvaluationService;
    }

    /**
     * Goes to the landing page of lazy route.
     *
     * @return Lazy page view.
     */
    @GetMapping("")
    public String index() {
        if (logger.isDebugEnabled()) {
            logger.debug("index started");
        }
        return "lazy/index";
    }

    /**
     * Process and return information about the data supplied in the LAZY page index page.
     *
     * @param userIdNumber   Participant id number
     * @param processingData Data to be processed
     * @param model          Bag for passing information from Controller to View.
     * @return An HTML page with processing results.
     */
    @PostMapping("/process")
    public String processLazyData(String userIdNumber, String processingData, Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("processLazyData started");
            logger.info("processinData=[" + processingData + "]");
        }
        LazyWorkerExchangeInfo lazyWorkerExchangeInfo = lazyWorkerEvaluationService.validateProcessingDataFormat(processingData);
        if (lazyWorkerExchangeInfo.isValid()){
            lazyWorkerEvaluationService.execute(lazyWorkerExchangeInfo);
        }
        lazyWorkerExchangeInfo.setUserIdNumber(userIdNumber);
        model.addAttribute(lazyWorkerExchangeInfo);
        return "lazy/process-data";
    }
}
