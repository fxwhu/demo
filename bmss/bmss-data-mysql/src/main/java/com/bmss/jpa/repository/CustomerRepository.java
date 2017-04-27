package com.bmss.jpa.repository;

import com.bmss.jpa.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fengxuan1 on 2017/3/30.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findById(Long id, Pageable pageable);

}
