package main.java.com.fraude.type;

public class fraudeIagConnecter extends fraudIag {

    private String adresseIP;

    public fraudeIagConnecter(String nomService, String adresseIP) {
        super(nomService);
        this.adresseIP = adresseIP;
    }

    public String getAdresseIP() {
        return adresseIP;
    }
    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

}