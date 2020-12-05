package com.ossez.edtestbank.common.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.event.spi.EventSource;
import org.hibernate.event.internal.DefaultDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;

/**
 * Delete Event Listener
 *
 * @author YuCheng Hu
 */
public class DeleteEventListener extends DefaultDeleteEventListener {

    private static final long serialVersionUID = 6910674958681477229L;

    /**
     * Transient Entity
     */
    @SuppressWarnings("rawtypes")
    protected void deleteTransientEntity(EventSource session, Object entity, boolean cascadeDeleteEnabled, EntityPersister persister,
                                         Set transientEntities) {
        super.deleteTransientEntity(session, entity, cascadeDeleteEnabled, persister,
                transientEntities == null ? new HashSet() : transientEntities);
    }
}
