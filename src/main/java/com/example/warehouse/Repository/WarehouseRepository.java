package com.example.warehouse.Repository;

import com.example.warehouse.Entity.AttachmentContent;
import com.example.warehouse.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
    Boolean deleteWarehouseById(Integer id);

    interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
        Optional<AttachmentContent> findAllByAttachmentId(Integer attachment_id);
    }
}
