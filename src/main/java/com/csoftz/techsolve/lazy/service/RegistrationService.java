/*----------------------------------------------------------------------------*/
/* Source File:   REGISTRATIONSERVICE.JAVA                                    */
/* Description:   Service to access Registration objects                      */
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
package com.csoftz.techsolve.lazy.service;

import com.csoftz.techsolve.lazy.domain.entities.cassandra.Registration;
import com.csoftz.techsolve.lazy.repository.IRegistrationRepository;
import com.csoftz.techsolve.lazy.service.interfaces.IRegistrationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service to access Registration objects
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.26/2017
 * @since 1.8 (JDK), Mar.26/2017
 */
@Service
public class RegistrationService implements IRegistrationService {
    private IRegistrationRepository registrationRepository;

    /**
     * Inject dependency.
     *
     * @param registrationRepository
     */
    public RegistrationService(IRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    /**
     * See interface for details.
     *
     * @param registration A reference to registration object
     * @return The same object received
     */
    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }

    /**
     * See interface for details.
     *
     * @param registrationList Data to save
     * @return Same given list.
     */
    @Override
    public List<Registration> save(List<Registration> registrationList) {
        registrationRepository.save(registrationList);
        return registrationList;
    }

    /**
     * See interface for details.
     *
     * @param registration A reference to registration object
     * @return The same object received.
     */
    @Override
    public Registration update(Registration registration) {
        return registrationRepository.save(registration);
    }

    /**
     * See interface for details.
     *
     * @param id Identification of record to find.
     * @return Optional indicating if found or not.
     */
    @Override
    public Optional<Registration> findOne(UUID id) {
        if (registrationRepository.exists(id)) {
            return Optional.of(registrationRepository.findOne(id));
        }
        return Optional.of(new Registration());
    }

    /**
     * See interface for details.
     *
     * @return The list of registrations found
     */
    @Override
    public List<Registration> findAll() {
        List<Registration> registrationList = new ArrayList<>();
        registrationRepository.findAll().forEach(registrationList::add);
        return registrationList;
    }

    /**
     * See interface for details.
     *
     * @param id The id to remove
     */
    @Override
    public void delete(UUID id) {
        registrationRepository.delete(id);
    }
}
