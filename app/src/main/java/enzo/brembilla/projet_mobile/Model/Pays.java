package enzo.brembilla.projet_mobile.Model;

public class Pays {
    private String name;
    private String alpha2Code;
    private String capital;
    private String region;
    private String subregion;
    private int population;
    private String flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlphaCode() {
        return alpha2Code;
    }

    public void setAlphaCode(String url) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital(){ return capital;}

    public void setCapital(){this.capital=capital;}

    public String getRegion() {return region;}

    public void setRegion(){this.region=region;}

    public String getSubregion(){ return subregion;}

    public void setSubregion(){ this.subregion=subregion;}

    public int getPopulation(){return population;}

    public void setPopulation(){this.population=population;}

    public String getFlag(){return flag;}

    public void setFlag(){this.flag=flag;}
}
