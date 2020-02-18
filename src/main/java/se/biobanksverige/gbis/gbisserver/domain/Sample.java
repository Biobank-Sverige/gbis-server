package se.biobanksverige.gbis.gbisserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Sample {
    @JsonProperty("sample_id")
    public final String sampleId;
    @JsonProperty("study_id")
    public final String studyId;
    @JsonProperty("sample_taken_date")
    public final String sampleTakenDate;
    @JsonProperty("sample_usage")
    public final String sampleUsage;
    @JsonProperty("last_usage_date")
    public final String lastUsageDate;
    @JsonProperty("donor")
    public final String donor;
    @JsonProperty("parent_sample_id")
    public final String parentSampleId;
    @JsonProperty("material_type")
    public final String materialType;
    @JsonProperty("sample_volume")
    public final Integer sampleVolume;
    @JsonProperty("freeze_thaw_cycles")
    public final Integer freezeThawCycles;
    @JsonProperty("sample_plate_id")
    public final String samplePlateId;
    @JsonProperty("sample_plate_position")
    public final String samplePlatePosition;

    public Sample(String sampleId, String studyId, String sampleTakenDate, String sampleUsage, String lastUsageDate, String donor, String parentSampleId, String materialType, Integer sampleVolume, Integer freezeThawCycles, String samplePlateId, String samplePlatePosition) {
        this.sampleId = sampleId;
        this.studyId = studyId;
        this.sampleTakenDate = sampleTakenDate;
        this.sampleUsage = sampleUsage;
        this.lastUsageDate = lastUsageDate;
        this.donor = donor;
        this.parentSampleId = parentSampleId;
        this.materialType = materialType;
        this.sampleVolume = sampleVolume;
        this.freezeThawCycles = freezeThawCycles;
        this.samplePlateId = samplePlateId;
        this.samplePlatePosition = samplePlatePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample = (Sample) o;
        return sampleId.equals(sample.sampleId) &&
                Objects.equals(sampleTakenDate, sample.sampleTakenDate) &&
                Objects.equals(studyId, sample.studyId) &&
                Objects.equals(sampleUsage, sample.sampleUsage) &&
                Objects.equals(lastUsageDate, sample.lastUsageDate) &&
                Objects.equals(donor, sample.donor) &&
                Objects.equals(parentSampleId, sample.parentSampleId) &&
                Objects.equals(materialType, sample.materialType) &&
                Objects.equals(sampleVolume, sample.sampleVolume) &&
                Objects.equals(freezeThawCycles, sample.freezeThawCycles) &&
                Objects.equals(samplePlateId, sample.samplePlateId) &&
                Objects.equals(samplePlatePosition, sample.samplePlatePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sampleId, studyId, sampleTakenDate, sampleUsage, lastUsageDate, donor, parentSampleId, materialType, sampleVolume, freezeThawCycles, samplePlateId, samplePlatePosition);
    }

    @Override
    public String toString() {
        return "Sample{" +
                "sampleId='" + sampleId + '\'' +
                ", studyId='" + studyId + '\'' +
                ", sampleTakenDate='" + sampleTakenDate + '\'' +
                ", sampleUsage='" + sampleUsage + '\'' +
                ", lastUsageDate='" + lastUsageDate + '\'' +
                ", donor='" + donor + '\'' +
                ", parentSampleId='" + parentSampleId + '\'' +
                ", materialType='" + materialType + '\'' +
                ", sampleVolume=" + sampleVolume +
                ", freezeThawCycles=" + freezeThawCycles +
                ", samplePlateId='" + samplePlateId + '\'' +
                ", samplePlatePosition='" + samplePlatePosition + '\'' +
                '}';
    }
}
