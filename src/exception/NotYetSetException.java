package exception;

/**
 * Custom exception yang dilempar ketika nilai mark belum diset.
 * Digunakan dalam class Assignment untuk menjaga integritas data nilai.
 */
public class NotYetSetException extends Exception {

    /**
     * Constructor dengan pesan custom.
     * @param s pesan error yang akan ditampilkan
     */
    public NotYetSetException(String s) {
        super(s);
    }
}
