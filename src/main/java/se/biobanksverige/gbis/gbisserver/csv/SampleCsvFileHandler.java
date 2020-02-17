package se.biobanksverige.gbis.gbisserver.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import se.biobanksverige.gbis.gbisserver.domain.Sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SampleCsvFileHandler {
    public List<Sample> readSampleDataFromCsv(File csvFile) {
        try (FileInputStream inputStream = new FileInputStream(csvFile)){
            return readSampleDataFromCsv(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sample> readSampleDataFromCsv(InputStream csvStream) {
        List<Sample> samples = new ArrayList<>();
        try (Reader reader = new InputStreamReader(csvStream)){
            for (CSVRecord record:CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(reader)){
                samples.add(new Sample(
                        record.get("sample_id"),
                        record.get("study_id"),
                        record.get("sample_usage"),
                        record.get("last_usage_date"),
                        record.get("donor"),
                        record.get("parent_sample_id"),
                        record.get("material_type"),
                        Integer.parseInt(record.get("sample_volume")),
                        Integer.parseInt(record.get("freeze_thaw_cycles")),
                        record.get("sample_plate_id"),
                        record.get("sample_plate_position")
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return samples;
    }


    public void writeSampleDataToCsv(File csvFile) {

    }

    public void writeSampleDataToCsv(OutputStream csvStream) {

    }
}
