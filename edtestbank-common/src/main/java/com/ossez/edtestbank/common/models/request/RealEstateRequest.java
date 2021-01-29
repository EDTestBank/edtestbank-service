package com.ossez.edtestbank.common.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


/**
 * RealEstate Search Object, UI can send search String and related pagination
 *
 * @author YuCheng Hu
 */
public class RealEstateRequest implements Serializable {
    private static final long serialVersionUID = 6474765081240948885L;

    @JsonProperty("property_town")
    private String propertyTown;

    public String getPropertyTown() {
        return propertyTown;
    }

    public void setPropertyTown(String propertyTown) {
        this.propertyTown = propertyTown;
    }
}
