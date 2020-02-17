package se.biobanksverige.gbis.gbisserver.csv;

import org.junit.jupiter.api.Test;
import se.biobanksverige.gbis.gbisserver.domain.Sample;

import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SampleCsvFileHandlerTest {

    @Test
    public void shouldReadSampleDataFromCsvStream(){
        InputStream csvInputStream = this.getClass().getClassLoader().getResourceAsStream("example-data.csv");
        List<Sample> samples = new SampleCsvFileHandler().readSampleDataFromCsv(csvInputStream);
        assertThat(samples).hasSize(2);
        assertThat(samples.get(0).sampleId).isEqualTo("12345");
    }
}