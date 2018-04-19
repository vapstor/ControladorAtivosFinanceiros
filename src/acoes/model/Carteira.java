package acoes.model;

/**
 *
 * @author vapstor
 */
public class Carteira {
    private double saldo;
    private int id;
    
    public Carteira(int idCarteira, double saldoCarteira) {
        this.id = idCarteira;
        this.saldo = saldoCarteira;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int idCarteira) {
        this.id = idCarteira;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldoCarteira) {
        this.saldo = saldoCarteira;
    }
    
}
