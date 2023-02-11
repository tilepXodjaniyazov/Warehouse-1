package com.example.warehouse.Servis;

import com.example.warehouse.Entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    Optional<AttachmentContent> findAllByAttachmentId(Integer attachment_id);
}
