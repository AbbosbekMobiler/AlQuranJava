package mobiler.abbosbek.alquranjava.model;

import com.google.gson.annotations.SerializedName;

public class Surah {
    @SerializedName("number")
    private int number;

    public Surah(int number, String name, String englishName, String englishNameTranslation, int numberOfArrays, String revelationType) {
        this.number = number;
        this.name = name;
        this.englishName = englishName;
        this.englishNameTranslation = englishNameTranslation;
        this.numberOfArrays = numberOfArrays;
        this.revelationType = revelationType;
    }

    @SerializedName("name")
    private String name;

    @SerializedName("englishName")
    private String englishName;

    @SerializedName("englishNameTranslation")
    private String englishNameTranslation;

    @SerializedName("numberOfArrays")
    private int numberOfArrays;

    @SerializedName("revelationType")
    private String revelationType;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishNameTranslation() {
        return englishNameTranslation;
    }

    public void setEnglishNameTranslation(String englishNameTranslation) {
        this.englishNameTranslation = englishNameTranslation;
    }

    public int getNumberOfArrays() {
        return numberOfArrays;
    }

    public void setNumberOfArrays(int numberOfArrays) {
        this.numberOfArrays = numberOfArrays;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }
}
