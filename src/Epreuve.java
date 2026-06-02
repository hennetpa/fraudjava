import java.sql.Date;

public class Epreuve extends Formulaire{
    private Date DATE;
    private Date DateTime;
    private String ECUE;
    private String Cursus;
    private String modalité;

    public Epreuve(Date DATE, Date DateTime, String ECUE, String Cursus, String modalité) {
        this.DATE = DATE;
        this.DateTime = DateTime;
        this.ECUE = ECUE;
        if (Cursus.equals("E3e") || Cursus.equals("E3a") || Cursus.equals("E1") || Cursus.equals("E2") || Cursus.equals("E4") || Cursus.equals("E5")) {
        this.Cursus = Cursus;
        }
        if (modalité.equals("écrit") || modalité.equals("oral") || modalité.equals("Ordinateur") || modalité.equals("Projet") || modalité.equals("TP")) {
        this.modalité = modalité;
        }
    }


    public Date getDate() {
        return DATE;
    }

    public void setDate(Date date) {
        this.DATE = date;
    }

    public Date getDateTime(){
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        this.DateTime = dateTime;
    }

    public String getECUE() {
        return ECUE;
    }

    public void setECUE(String ECUE) {
        this.ECUE = ECUE;
    }

    public String getCursus() {
        return Cursus;
    }

    public void setCursus(String Cursus) {
        this.Cursus = Cursus;
    }

    public String getModalité() {
        return modalité;
    }

    public void setModalité(String modalité) {
        this.modalité = modalité;
    }


}
