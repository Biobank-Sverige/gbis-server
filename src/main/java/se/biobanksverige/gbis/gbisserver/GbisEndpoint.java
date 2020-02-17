package se.biobanksverige.gbis.gbisserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.biobanksverige.gbis.gbisserver.csv.SampleCsvFileHandler;
import se.biobanksverige.gbis.gbisserver.domain.Sample;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GbisEndpoint {

    @Value("${datafile.path}")
    private String dataFile;

    @RequestMapping("/")
    public List<Sample> getSample(){
        return new SampleCsvFileHandler().readSampleDataFromCsv(new File(dataFile));
    }
}
