package com.doctor.dosage.repository;

import com.doctor.dosage.model.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Long> {

}
