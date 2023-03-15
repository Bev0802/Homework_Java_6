/*Подумать над структурой класса Ноутбук для магазина техники - 
выделить поля и методы. Реализовать в java. */

public class Notebook {
    private String mader;
    private int displaySize;
    private int ram;
    private String hdtype;
    private int rom;
    private String os;
    
    public Notebook(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    //public void setOs(String os) {
    //    this.os = os;
    //}

    private String color;

    public Notebook(String mader, int displaySize, int ram, String hdtype, int rom, String os, String color) {
        this.mader = mader;
        this.displaySize = displaySize;
        this.ram = ram;
        this.hdtype = hdtype;
        this.rom = rom;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nNotebook [mader=" + mader + ", displaySize=" + displaySize +"'"+ ", ram=" + ram + ", hdtype=" + hdtype
                + ", rom=" + rom +" Mb"+ ", OS=" + os + ", color=" + color + "]";
    }

    public String getMader() {
        return mader;
    }

    public void setMader(String mader) {
        this.mader = mader;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getHdtype() {
        return hdtype;
    }

    public void setHdtype(String hdtype) {
        this.hdtype = hdtype;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((mader == null) ? 0 : mader.hashCode());
    //     result = prime * result + Float.floatToIntBits(displaySize);
    //     result = prime * result + ram;
    //     result = prime * result + ((hdtype == null) ? 0 : hdtype.hashCode());
    //     result = prime * result + rom;
    //     result = prime * result + ((color == null) ? 0 : color.hashCode());
    //     return result;
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (mader == null) {
            if (other.mader != null)
                return false;
        } else if (!mader.equals(other.mader))
            return false;
        if (Float.floatToIntBits(displaySize) != Float.floatToIntBits(other.displaySize))
            return false;
        if (ram != other.ram)
            return false;
        if (hdtype == null) {
            if (other.hdtype != null)
                return false;
        } else if (!hdtype.equals(other.hdtype))
            return false;
        if (rom != other.rom)
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        return true;
    }   
    
    
}