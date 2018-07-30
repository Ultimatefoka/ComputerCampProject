public class Tile {

    private String grafik;
    private String name;
    private boolean begehbar;

    public Tile(String grafik, String name, boolean begehbar) {

        this.grafik = grafik;
        this.name = name;
        this.begehbar = begehbar;
        
    }

    public void setGrafik(String grafik) {
        this.grafik = grafik;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBegehbar(boolean begehbar) {
        this.begehbar = begehbar;
    }

    public String getGrafik() {
        return grafik;
    }

    public String getName() {
        return name;
    }

    public boolean isBegehbar() {
        return begehbar;
    }
}
