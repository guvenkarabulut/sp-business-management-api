package com.guvenkarabulut.businessmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("country")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("country_name")
    private String countryName;

    @Transient
    private Region region;

    @Transient
    private Location location;

    @Column("region_id")
    private Long regionId;


    public Long getId() {
        return this.id;
    }

    public Country id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public Country countryName(String countryName) {
        this.setCountryName(countryName);
        return this;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
        this.regionId = region != null ? region.getId() : null;
    }

    public Country region(Region region) {
        this.setRegion(region);
        return this;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        if (this.location != null) {
            this.location.setCountry(null);
        }
        if (location != null) {
            location.setCountry(this);
        }
        this.location = location;
    }

    public Country location(Location location) {
        this.setLocation(location);
        return this;
    }

    public Long getRegionId() {
        return this.regionId;
    }

    public void setRegionId(Long region) {
        this.regionId = region;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        return id != null && id.equals(((Country) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Country{" +
            "id=" + getId() +
            ", countryName='" + getCountryName() + "'" +
            "}";
    }
}
