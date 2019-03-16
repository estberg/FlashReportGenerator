package farestartreporting.responseModel;

import farestartreporting.dataRetriever.BusinessLocationRetrival;
import farestartreporting.utils.URLEncoderHelperFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessReport {
    public Date date;
    public List<BusinessLocation> locations;

    private BusinessLocationRetrival retreiver = new BusinessLocationRetrival();

    public BusinessReport(Date date, List<BusinessLocation> locations) {
        this.date = date;
        this.locations = locations;
    }


    public BusinessReport(Date date) throws IOException {

        String encodedDate = URLEncoderHelperFS.convertURL(date);

        List<BusinessLocation> locations = new ArrayList<>();

        BusinessLocation report1 = retreiver.getReport(1, encodedDate);
        BusinessLocation report2 = retreiver.getReport(2, encodedDate);

        locations.add(report1);
        locations.add(report2);
        this.date = date;
        this.locations = locations;

    }


}