package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.entity.Participant;
import com.example.eventmanagementsystem.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    // Récupérer tous les participants
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Créer un nouveau participant
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    // Récupérer un participant par ID
    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Participant not found with id " + id));
    }

    // Mettre à jour un participant existant
    public Participant updateParticipant(Long id, Participant participantDetails) {
        Participant participant = getParticipantById(id);
        participant.setName(participantDetails.getName());
        participant.setEmail(participantDetails.getEmail());
        participant.setEventId(participantDetails.getEventId());
        return participantRepository.save(participant);
    }

    // Supprimer un participant
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
