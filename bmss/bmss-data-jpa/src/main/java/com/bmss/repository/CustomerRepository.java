package com.bmss.repository;

import com.bmss.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by fengxuan1 on 2017/4/27.
 */

@RepositoryRestResource()
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
