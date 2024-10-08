package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {}
