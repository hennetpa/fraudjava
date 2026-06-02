package main.java.com.fraude.type;

public class fraudpapier {
    private boolean plier;
    private int dimention;

    public fraudpapier(boolean plier, int dimention) {
        this.plier = plier;
        this.dimention = dimention;
    }

    public int getDimention() {
        return dimention;
    }

    public boolean isPlier() {
        return plier;
    }

    public void setPlier(boolean plier) {
        this.plier = plier;
    }

    public void setDimention(int dimention) {
        this.dimention = dimention;
    }


}
