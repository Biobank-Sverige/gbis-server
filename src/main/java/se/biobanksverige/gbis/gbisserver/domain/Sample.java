package se.biobanksverige.gbis.gbisserver.domain;

public class Sample {
    public final String sampleId;
    public final String stydyId;
    public final String sampleUsage;
    public final String lastUsageDate;
    public final String donor;
    public final String parentSampleId;
    public final String materialType;
    public final Integer sampleVolume;
    public final Integer freezeThawCycles;
    public final String samplePlateId;
    public final String samplePlatePosition;

    public Sample(String sampleId, String stydyId, String sampleUsage, String lastUsageDate, String donor, String parentSampleId, String materialType, Integer sampleVolume, Integer freezeThawCycles, String samplePlateId, String samplePlatePosition) {
        this.sampleId = sampleId;
        this.stydyId = stydyId;
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
}
