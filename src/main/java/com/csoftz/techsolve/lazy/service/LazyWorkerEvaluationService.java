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

import com.csoftz.techsolve.lazy.domain.BagItems;
import com.csoftz.techsolve.lazy.domain.LazyWorkerExchangeInfo;
import com.csoftz.techsolve.lazy.service.interfaces.ILazyWorkerEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

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
     *
     * @param processingData Input data to process
     * @return Information about validity of supplied information.
     */
    @Override
    public LazyWorkerExchangeInfo validateProcessingDataFormat(String processingData) {
        LazyWorkerExchangeInfo info = new LazyWorkerExchangeInfo();
        int anyVal = 0;
        int numberOfDays = 0;
        int scannedDay = 0;

        // Let's assume that input format is valid.
        info.setValid(true);
        if (processingData.equals("")) {
            info.setValid(false);
            info.setErrorDescription("No data supplied. Process aborted.");
        } else {
            String[] lines = processingData.split("\\r?\\n");
            int i = 1;
            boolean validNumber = true;

            try {
                anyVal = Integer.parseInt(lines[0]);
            } catch (NumberFormatException e) {
                validNumber = false;
            }
            if (!validNumber) {
                info.setValid(false);
                info.setErrorDescription("Line 1: Invalid format. No test cases number supplied");
            } else {
                numberOfDays = anyVal;
                if (!(1 <= numberOfDays && numberOfDays <= 500)) {
                    info.setValid(false);
                    info.setErrorDescription("Invalid format. Number of days is not in the range 1 <= T <= 500");
                }
            }

            int itemsSize = 0;
            if (info.isValid()) {
                while (i < lines.length) {
                    if (lines[i].trim().equals("")) {
                        info.setValid(false);
                        info.setErrorDescription("Line " + (i + 1) + ": Invalid format. An empty line was found.");
                        break;
                    }
                    try {
                        anyVal = Integer.parseInt(lines[i]);
                    } catch (NumberFormatException e) {
                        validNumber = false;
                    }
                    if (!validNumber) {
                        info.setValid(false);
                        info.setErrorDescription("Line " + (i + 1) + ": Invalid format. Value of N expected.");
                    } else {
                        itemsSize = anyVal;
                        if (!(1 <= itemsSize && itemsSize <= 100)) {
                            info.setValid(false);
                            info.setErrorDescription("Invalid format. Value of items expected to be in the range 1 <= N <= 100");
                            break;
                        }
                        i++;
                    }

                    // Try to gather items for day
                    BagItems bagItems = new BagItems();
                    int j = 0;
                    scannedDay++;
                    while (j < itemsSize) {
                        if (lines[i].trim().equals("")) {
                            info.setValid(false);
                            info.setErrorDescription("Line " + (i + 1) + ": Invalid format. An empty line was found.");
                            break;
                        }
                        try {
                            anyVal = Integer.parseInt(lines[i]);
                        } catch (NumberFormatException e) {
                            validNumber = false;
                        }
                        if (!validNumber) {
                            info.setValid(false);
                            info.setErrorDescription("Line " + (i + 1) + ": Invalid format. Some value of W for item expected.");
                        } else {
                            if (!(1 <= anyVal && anyVal <= 100)) {
                                info.setValid(false);
                                info.setErrorDescription("Invalid format. Value of items expected to be in the range 1 <= W <= 100");
                                break;
                            }
                            bagItems.getItems().add(anyVal);
                        }
                        i++;
                        j++;
                        if (i >= lines.length) {
                            break;
                        }
                    }
                    info.getWorkDaysList().add(bagItems);
                    if (!info.isValid()) {
                        // Exit loop as some line is not valid in last loop
                        break;
                    }
                }
            }
            if (info.isValid() && scannedDay < numberOfDays) {
                info.setValid(false);
                info.setErrorDescription("Invalid format. Not all days are present in file");
            }
        }
        return info;
    }

    /**
     * See interface declaration for details.
     *
     * @param lazyWorkerExchangeInfo Instance to object to evaluate
     */
    @Override
    public void execute(LazyWorkerExchangeInfo lazyWorkerExchangeInfo) {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        List<BagItems> bagItemsList = lazyWorkerExchangeInfo.getWorkDaysList();
        for (BagItems bagItem : bagItemsList) {
            bagItem.getItems().sort((a,b)-> a.compareTo(b));

            Integer[] w = bagItem.getItems().toArray(new Integer[bagItem.getItems().size()]);
            int N = bagItem.getItems().size();

            int cnt = 0;
            int step = 0;
            int end = N - 1;
            while (step <= end) {
                int top = w[end--];
                int mult = 1;
                while (step <= end && top * mult < 50) {
                    step++;
                    mult++;
                }
                if (top * mult >= 50) cnt++;
            }
            sb.append("Case #").append(i).append(":").append(cnt).append("<br/>");
        }
        lazyWorkerExchangeInfo.setOutputResult(sb.toString());
    }
}
