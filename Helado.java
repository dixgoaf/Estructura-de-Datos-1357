import java.util.Objects;

public class Helado {
    private String sabor;
    private int cantidad;
    private double precio;

    public Helado(String sabor, int cantidad, double precio) {
        this.sabor = sabor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Helado{sabor=" + sabor + ", cantidad=" + cantidad + ", precio=" + precio + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Helado)) {
            return false;
        }
        Helado otro = (Helado) o;
        return cantidad == otro.cantidad
                && Double.compare(precio, otro.precio) == 0
                && Objects.equals(sabor, otro.sabor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sabor, cantidad, precio);
    }
}
