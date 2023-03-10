package com.example.products.repository;

import com.example.products.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
