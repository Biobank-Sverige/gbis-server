package se.biobanksverige.gbis.gbisserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.biobanksverige.gbis.gbisserver.domain.Sample;

@RestController
public class GbisEndpoint {

    @RequestMapping("/")
    public Sample getSample(){
        return new Sample(
                "123",
                "STUDY-01",
                "RESEARCH",
                "2021-01-01",
                "19121212-1212",
                "456",
                "SRM",
                125,
                2,
                "PL-123",
                "A01"
        );
    }
}
