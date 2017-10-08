package com.lkp.entity.vo;

import com.lkp.entity.TlkCptjEntity;
import com.lkp.entity.TlkProductEntity;

/**
 *
 */
public class TJproductVo {
    private TlkCptjEntity tlkCptjEntity;
    private TlkProductEntity tlkProductEntity;

    public TJproductVo(TlkCptjEntity tlkCptjEntity, TlkProductEntity tlkProductEntity) {
        this.tlkCptjEntity = tlkCptjEntity;
        this.tlkProductEntity = tlkProductEntity;
    }

    public TlkCptjEntity getTlkCptjEntity() {
        return tlkCptjEntity;
    }

    public void setTlkCptjEntity(TlkCptjEntity tlkCptjEntity) {
        this.tlkCptjEntity = tlkCptjEntity;
    }

    public TlkProductEntity getTlkProductEntity() {
        return tlkProductEntity;
    }

    public void setTlkProductEntity(TlkProductEntity tlkProductEntity) {
        this.tlkProductEntity = tlkProductEntity;
    }
}
