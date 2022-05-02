package com.sports.backend.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.concurrent.TimeUnit.DAYS;

public class Results {
    private String areaName;

    private List<Finding> findings = new ArrayList<>();

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<Finding> getFindings() {
        return findings;
    }

    public void setFindings(List<Finding> findings) {
        this.findings = findings;
    }

    public List<Finding> getFindingsByHoliday(List<Sport> sports, Holiday holiday) {
        List<Finding> findings = new ArrayList<>();
        for (Sport sport : sports) {
            Finding finding = new Finding();
            finding.setSportName(sport.getName());
            finding.setLocationName(sport.getLocation().getName());
            finding.setCost(sport.getAvgCostPerDay() *
                    DAYS.toChronoUnit().between(holiday.getStartingDate(), holiday.getEndingDate()));
            findings.add(finding);
        }
        findings.sort(Comparator.comparing(Finding::getCost));
        return findings;
    }
}
