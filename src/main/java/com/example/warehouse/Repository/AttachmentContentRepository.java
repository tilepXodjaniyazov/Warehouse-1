package com.example.warehouse.Repository;

import com.example.warehouse.Entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    AttachmentContent findAttachmentContentByAttachmentId(Integer attachment_id);
}
