/*----------------------------------------------------------------------------*/
/* Source File:   IREGISTRATIONSERVICE.JAVA                                   */
/* Description:   Interface to service to access Registration objects         */
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
package com.csoftz.techsolve.lazy.service.interfaces;

import com.csoftz.techsolve.lazy.domain.entities.cassandra.Registration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface to service to access Registration objects
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.26/2017
 * @since 1.8 (JDK), Mar.26/2017
 */
public interface IRegistrationService {
    /**
     * Stores a new record for  'registration'
     *
     * @param registration A reference to registration object
     * @return The same object received
     */
    Registration save(Registration registration);

    /**
     * Stores the list of Enteprises supplied.
     *
     * @param registrationList Data to save
     * @return Same given list.
     */
    List<Registration> save(List<Registration> registrationList);

    /**
     * Updates a record for 'registration'
     *
     * @param registration A reference to registration object
     * @return The same object received.
     */
    Registration update(Registration registration);

    /**
     * Given the 'id' tries to find if record exists.
     *
     * @param id Identification of record to find.
     * @return Optional indicating if found or not.
     */
    Optional<Registration> findOne(UUID id);

    /**
     * Retrieves all existing registrations.
     *
     * @return The list of registrations found
     */
    List<Registration> findAll();

    /**
     * Removes a record for 'registration'
     *
     * @param id The id to remove
     */
    void delete(UUID id);
}
