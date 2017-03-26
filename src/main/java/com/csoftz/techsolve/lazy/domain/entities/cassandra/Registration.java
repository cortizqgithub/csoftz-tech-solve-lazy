/*----------------------------------------------------------------------------*/
/* Source File:   REGISTRATION.JAVA                                           */
/* Description:   Domain object to map a Registration Cassandra table         */
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
package com.csoftz.techsolve.lazy.domain.entities.cassandra;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Domain object to map a Registration Cassandra table
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.25/2017
 * @since 1.8 (JDK), Mar.25/2017
 */
@Table("registration")
public class Registration {
    @Column("id")
    @PrimaryKey
    private UUID id;

    @Column("creation_date")
    private LocalDateTime creationDate;

    @Column("user_id_number")
    private String userIdNumber;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", userIdNumber='" + userIdNumber + '\'' +
                '}';
    }
}
