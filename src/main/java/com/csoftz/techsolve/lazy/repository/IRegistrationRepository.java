/*----------------------------------------------------------------------------*/
/* Source File:   IREGISTRATIONREPOSITORY.JAVA                                */
/* Description:   Spring Data interface strategy to access Registration       */
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
package com.csoftz.techsolve.lazy.repository;

import com.csoftz.techsolve.lazy.domain.entities.cassandra.Registration;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Spring Data interface strategy to access Registration
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.25/2017
 * @since 1.8 (JDK), Mar.25/2017
 */
public interface IRegistrationRepository extends CrudRepository<Registration, UUID> {
}
