/*----------------------------------------------------------------------------*/
/* Source File:   BAGITEMS.JAVA                                               */
/* Description:   Holds the items to be carried away to the trunk             */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.26/2017                                                 */
/* Last Modified: Mar.26/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.26/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.techsolve.lazy.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the items to be carried away to the trunk
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.26/2017
 * @since 1.8 (JDK), Mar.26/2017
 */
public class BagItems {
    private List<Integer> items;

    /**
     * Default constructor
     */
    public BagItems() {
        this.items = new ArrayList<>();
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "BagItems{" +
                "items=" + items +
                '}';
    }
}
