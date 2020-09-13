package com.ossez.edtestbank.common.models;

import com.ossez.edtestbank.common.DataObject;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(catalog= "edtestbank", name = "QTitle")
public class QTitle extends DataObject implements java.io.Serializable {
    private static final long serialVersionUID = -612061041423673622L;

    private String state;

    private String positive;
    private String positiveScore;
    private String negativeScore;
    private String negativeRegularScore;
    private String commercialScore;
    private String grade;
    private String score;
    private String negative;
    private String pending;
    private String hospitalizedCurrently;
    private String hospitalizedCumulative;
    private String inIcuCurrently;
    private String inIcuCumulative;
    private String onVentilatorCurrently;
    private String onVentilatorCumulative;
    private String recovered;
    private String lastUpdateEt;
    private String checkTimeEt;
    private String death;
    private String hospitalized;
    private String total;
    private String totalTestResults;
    private String posNeg;
    private String fips;
    private String dateModified;
    private String dateChecked;
    private String hash;



    public QTitle() {
    }

//    @Id
//    @GeneratedValue
//    private long id = 0;
//
//    @Override
//    public long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(long id) {
//        this.id = id;
//    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getPositiveScore() {
        return positiveScore;
    }

    public void setPositiveScore(String positiveScore) {
        this.positiveScore = positiveScore;
    }

    public String getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(String negativeScore) {
        this.negativeScore = negativeScore;
    }

    public String getNegativeRegularScore() {
        return negativeRegularScore;
    }

    public void setNegativeRegularScore(String negativeRegularScore) {
        this.negativeRegularScore = negativeRegularScore;
    }

    public String getCommercialScore() {
        return commercialScore;
    }

    public void setCommercialScore(String commercialScore) {
        this.commercialScore = commercialScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getHospitalizedCurrently() {
        return hospitalizedCurrently;
    }

    public void setHospitalizedCurrently(String hospitalizedCurrently) {
        this.hospitalizedCurrently = hospitalizedCurrently;
    }

    public String getHospitalizedCumulative() {
        return hospitalizedCumulative;
    }

    public void setHospitalizedCumulative(String hospitalizedCumulative) {
        this.hospitalizedCumulative = hospitalizedCumulative;
    }

    public String getInIcuCurrently() {
        return inIcuCurrently;
    }

    public void setInIcuCurrently(String inIcuCurrently) {
        this.inIcuCurrently = inIcuCurrently;
    }

    public String getInIcuCumulative() {
        return inIcuCumulative;
    }

    public void setInIcuCumulative(String inIcuCumulative) {
        this.inIcuCumulative = inIcuCumulative;
    }

    public String getOnVentilatorCurrently() {
        return onVentilatorCurrently;
    }

    public void setOnVentilatorCurrently(String onVentilatorCurrently) {
        this.onVentilatorCurrently = onVentilatorCurrently;
    }

    public String getOnVentilatorCumulative() {
        return onVentilatorCumulative;
    }

    public void setOnVentilatorCumulative(String onVentilatorCumulative) {
        this.onVentilatorCumulative = onVentilatorCumulative;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getLastUpdateEt() {
        return lastUpdateEt;
    }

    public void setLastUpdateEt(String lastUpdateEt) {
        this.lastUpdateEt = lastUpdateEt;
    }

    public String getCheckTimeEt() {
        return checkTimeEt;
    }

    public void setCheckTimeEt(String checkTimeEt) {
        this.checkTimeEt = checkTimeEt;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(String hospitalized) {
        this.hospitalized = hospitalized;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalTestResults() {
        return totalTestResults;
    }

    public void setTotalTestResults(String totalTestResults) {
        this.totalTestResults = totalTestResults;
    }

    public String getPosNeg() {
        return posNeg;
    }

    public void setPosNeg(String posNeg) {
        this.posNeg = posNeg;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getDateChecked() {
        return dateChecked;
    }

    public void setDateChecked(String dateChecked) {
        this.dateChecked = dateChecked;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(state)
                .append(positive)
                .append(positiveScore)
                .append(negativeScore)
                .append(negativeRegularScore)
                .toHashCode();
    }


}
